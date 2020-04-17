package com.baidu.tieba.VideoCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes9.dex */
public class l {
    private static l exK;
    private ExecutorService byb = Executors.newFixedThreadPool(10);

    public static l bfy() {
        if (exK == null) {
            synchronized (l.class) {
                if (exK == null) {
                    exK = new l();
                }
            }
        }
        return exK;
    }

    public void q(Runnable runnable) {
        if (this.byb != null) {
            this.byb.execute(runnable);
        }
    }

    public void destroy() {
        if (this.byb != null) {
            this.byb.shutdown();
            this.byb = null;
            exK = null;
        }
    }
}
