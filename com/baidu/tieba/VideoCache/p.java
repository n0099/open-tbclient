package com.baidu.tieba.VideoCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes.dex */
public class p {
    private static p aOB;
    private ExecutorService aOC = Executors.newFixedThreadPool(10);

    public static p Kt() {
        if (aOB == null) {
            synchronized (p.class) {
                if (aOB == null) {
                    aOB = new p();
                }
            }
        }
        return aOB;
    }

    public void g(Runnable runnable) {
        if (this.aOC != null) {
            this.aOC.execute(runnable);
        }
    }

    public void destroy() {
        if (this.aOC != null) {
            this.aOC.shutdown();
            this.aOC = null;
            aOB = null;
        }
    }
}
