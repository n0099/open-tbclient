package com.baidu.tieba.VideoCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes4.dex */
public class l {
    private static l dfl;
    private ExecutorService dfm = Executors.newFixedThreadPool(10);

    public static l aCJ() {
        if (dfl == null) {
            synchronized (l.class) {
                if (dfl == null) {
                    dfl = new l();
                }
            }
        }
        return dfl;
    }

    public void k(Runnable runnable) {
        if (this.dfm != null) {
            this.dfm.execute(runnable);
        }
    }

    public void destroy() {
        if (this.dfm != null) {
            this.dfm.shutdown();
            this.dfm = null;
            dfl = null;
        }
    }
}
