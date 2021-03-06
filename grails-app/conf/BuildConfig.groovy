grails.project.work.dir = 'target'
grails.project.target.level = 1.6
grails.project.source.level = 1.6

grails.project.fork = [
    // configure settings for compilation JVM, note that if you alter the Groovy version forked compilation is required
    //  compile: [maxMemory: 256, minMemory: 64, debug: false, maxPerm: 256, daemon:true],

    // configure settings for the test-app JVM, uses the daemon by default
    test: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, daemon:true],
    // configure settings for the run-app JVM
    run: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve:false],
    // configure settings for the run-war JVM
    war: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve:false],
    // configure settings for the Console UI JVM
    console: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256]
]

grails.project.dependency.resolver = "maven" // or ivy
grails.project.dependency.resolution = {
    inherits 'global'
    log "warn"
    repositories {
        grailsCentral()
        grailsPlugins()
        mavenCentral()   
    }

    plugins {
        runtime ":spud-core:0.1.4"
        runtime ":spud-permalinks:0.1.0"
        runtime ':cache:1.1.1'
        runtime ':sitemaps:0.2.0'

        build(":release:3.0.0",
              ":rest-client-builder:1.0.3") {
            export = false
        }
    }
}

// grails.plugin.location."spud-core" = "../spud-core"
// grails.plugin.location."spud-permalinks" = "../spud-permalinks"
