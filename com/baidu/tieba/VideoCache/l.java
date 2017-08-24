package com.baidu.tieba.VideoCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class l {
    private static l aWJ;
    private ExecutorService aWK = Executors.newFixedThreadPool(10);

    public static l KC() {
        if (aWJ == null) {
            synchronized (l.class) {
                if (aWJ == null) {
                    aWJ = new l();
                }
            }
        }
        return aWJ;
    }

    public void g(Runnable runnable) {
        if (this.aWK != null) {
            this.aWK.execute(runnable);
        }
    }

    public void destroy() {
        if (this.aWK != null) {
            this.aWK.shutdown();
            this.aWK = null;
            aWJ = null;
        }
    }
}
