package com.baidu.tieba.VideoCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes.dex */
public class n {
    private static n aVa;
    private ExecutorService aVb = Executors.newFixedThreadPool(10);

    public static n LK() {
        if (aVa == null) {
            synchronized (n.class) {
                if (aVa == null) {
                    aVa = new n();
                }
            }
        }
        return aVa;
    }

    public void g(Runnable runnable) {
        if (this.aVb != null) {
            this.aVb.execute(runnable);
        }
    }

    public void destroy() {
        if (this.aVb != null) {
            this.aVb.shutdown();
            this.aVb = null;
            aVa = null;
        }
    }
}
