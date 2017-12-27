package com.baidu.tieba.VideoCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class l {
    private static l bPr;
    private ExecutorService bPs = Executors.newFixedThreadPool(10);

    public static l Ts() {
        if (bPr == null) {
            synchronized (l.class) {
                if (bPr == null) {
                    bPr = new l();
                }
            }
        }
        return bPr;
    }

    public void f(Runnable runnable) {
        if (this.bPs != null) {
            this.bPs.execute(runnable);
        }
    }

    public void destroy() {
        if (this.bPs != null) {
            this.bPs.shutdown();
            this.bPs = null;
            bPr = null;
        }
    }
}
