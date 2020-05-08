package com.baidu.tieba.VideoCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes9.dex */
public class l {
    private static l exP;
    private ExecutorService byg = Executors.newFixedThreadPool(10);

    public static l bfw() {
        if (exP == null) {
            synchronized (l.class) {
                if (exP == null) {
                    exP = new l();
                }
            }
        }
        return exP;
    }

    public void q(Runnable runnable) {
        if (this.byg != null) {
            this.byg.execute(runnable);
        }
    }

    public void destroy() {
        if (this.byg != null) {
            this.byg.shutdown();
            this.byg = null;
            exP = null;
        }
    }
}
