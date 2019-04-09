package com.baidu.tieba.VideoCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes4.dex */
public class l {
    private static l cLY;
    private ExecutorService cLZ = Executors.newFixedThreadPool(10);

    public static l avO() {
        if (cLY == null) {
            synchronized (l.class) {
                if (cLY == null) {
                    cLY = new l();
                }
            }
        }
        return cLY;
    }

    public void k(Runnable runnable) {
        if (this.cLZ != null) {
            this.cLZ.execute(runnable);
        }
    }

    public void destroy() {
        if (this.cLZ != null) {
            this.cLZ.shutdown();
            this.cLZ = null;
            cLY = null;
        }
    }
}
