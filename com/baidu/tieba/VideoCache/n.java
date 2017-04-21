package com.baidu.tieba.VideoCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes.dex */
public class n {
    private static n aVc;
    private ExecutorService aVd = Executors.newFixedThreadPool(10);

    public static n LK() {
        if (aVc == null) {
            synchronized (n.class) {
                if (aVc == null) {
                    aVc = new n();
                }
            }
        }
        return aVc;
    }

    public void g(Runnable runnable) {
        if (this.aVd != null) {
            this.aVd.execute(runnable);
        }
    }

    public void destroy() {
        if (this.aVd != null) {
            this.aVd.shutdown();
            this.aVd = null;
            aVc = null;
        }
    }
}
