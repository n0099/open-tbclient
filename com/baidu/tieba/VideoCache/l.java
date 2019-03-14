package com.baidu.tieba.VideoCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes4.dex */
public class l {
    private static l cLV;
    private ExecutorService cLW = Executors.newFixedThreadPool(10);

    public static l avR() {
        if (cLV == null) {
            synchronized (l.class) {
                if (cLV == null) {
                    cLV = new l();
                }
            }
        }
        return cLV;
    }

    public void k(Runnable runnable) {
        if (this.cLW != null) {
            this.cLW.execute(runnable);
        }
    }

    public void destroy() {
        if (this.cLW != null) {
            this.cLW.shutdown();
            this.cLW = null;
            cLV = null;
        }
    }
}
