package com.baidu.tieba.VideoCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes4.dex */
public class l {
    private static l cLX;
    private ExecutorService cLY = Executors.newFixedThreadPool(10);

    public static l avO() {
        if (cLX == null) {
            synchronized (l.class) {
                if (cLX == null) {
                    cLX = new l();
                }
            }
        }
        return cLX;
    }

    public void k(Runnable runnable) {
        if (this.cLY != null) {
            this.cLY.execute(runnable);
        }
    }

    public void destroy() {
        if (this.cLY != null) {
            this.cLY.shutdown();
            this.cLY = null;
            cLX = null;
        }
    }
}
