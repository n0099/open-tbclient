package com.baidu.tieba.VideoCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes.dex */
public class n {
    private static n aPY;
    private ExecutorService aPZ = Executors.newFixedThreadPool(10);

    public static n Kq() {
        if (aPY == null) {
            synchronized (n.class) {
                if (aPY == null) {
                    aPY = new n();
                }
            }
        }
        return aPY;
    }

    public void g(Runnable runnable) {
        if (this.aPZ != null) {
            this.aPZ.execute(runnable);
        }
    }

    public void destroy() {
        if (this.aPZ != null) {
            this.aPZ.shutdown();
            this.aPZ = null;
            aPY = null;
        }
    }
}
