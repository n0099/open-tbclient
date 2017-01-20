package com.baidu.tieba.VideoCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes.dex */
public class n {
    private static n aPb;
    private ExecutorService aPc = Executors.newFixedThreadPool(10);

    public static n KF() {
        if (aPb == null) {
            synchronized (n.class) {
                if (aPb == null) {
                    aPb = new n();
                }
            }
        }
        return aPb;
    }

    public void g(Runnable runnable) {
        if (this.aPc != null) {
            this.aPc.execute(runnable);
        }
    }

    public void destroy() {
        if (this.aPc != null) {
            this.aPc.shutdown();
            this.aPc = null;
            aPb = null;
        }
    }
}
