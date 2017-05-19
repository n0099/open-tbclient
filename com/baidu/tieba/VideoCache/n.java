package com.baidu.tieba.VideoCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class n {
    private static n aVx;
    private ExecutorService aVy = Executors.newFixedThreadPool(10);

    public static n KY() {
        if (aVx == null) {
            synchronized (n.class) {
                if (aVx == null) {
                    aVx = new n();
                }
            }
        }
        return aVx;
    }

    public void g(Runnable runnable) {
        if (this.aVy != null) {
            this.aVy.execute(runnable);
        }
    }

    public void destroy() {
        if (this.aVy != null) {
            this.aVy.shutdown();
            this.aVy = null;
            aVx = null;
        }
    }
}
