package com.baidu.tieba.VideoCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class l {
    private static l aVv;
    private ExecutorService aVw = Executors.newFixedThreadPool(10);

    public static l Kx() {
        if (aVv == null) {
            synchronized (l.class) {
                if (aVv == null) {
                    aVv = new l();
                }
            }
        }
        return aVv;
    }

    public void g(Runnable runnable) {
        if (this.aVw != null) {
            this.aVw.execute(runnable);
        }
    }

    public void destroy() {
        if (this.aVw != null) {
            this.aVw.shutdown();
            this.aVw = null;
            aVv = null;
        }
    }
}
