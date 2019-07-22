package com.baidu.tieba.VideoCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes4.dex */
public class l {
    private static l cVH;
    private ExecutorService cVI = Executors.newFixedThreadPool(10);

    public static l aCm() {
        if (cVH == null) {
            synchronized (l.class) {
                if (cVH == null) {
                    cVH = new l();
                }
            }
        }
        return cVH;
    }

    public void m(Runnable runnable) {
        if (this.cVI != null) {
            this.cVI.execute(runnable);
        }
    }

    public void destroy() {
        if (this.cVI != null) {
            this.cVI.shutdown();
            this.cVI = null;
            cVH = null;
        }
    }
}
