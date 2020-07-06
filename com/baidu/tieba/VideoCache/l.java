package com.baidu.tieba.VideoCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes9.dex */
public class l {
    private static l eWO;
    private ExecutorService bKx = Executors.newFixedThreadPool(10);

    public static l bok() {
        if (eWO == null) {
            synchronized (l.class) {
                if (eWO == null) {
                    eWO = new l();
                }
            }
        }
        return eWO;
    }

    public void s(Runnable runnable) {
        if (this.bKx != null) {
            this.bKx.execute(runnable);
        }
    }

    public void destroy() {
        if (this.bKx != null) {
            this.bKx.shutdown();
            this.bKx = null;
            eWO = null;
        }
    }
}
