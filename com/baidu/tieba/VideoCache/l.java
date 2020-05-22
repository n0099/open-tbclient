package com.baidu.tieba.VideoCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes9.dex */
public class l {
    private static l eMr;
    private ExecutorService bFJ = Executors.newFixedThreadPool(10);

    public static l blI() {
        if (eMr == null) {
            synchronized (l.class) {
                if (eMr == null) {
                    eMr = new l();
                }
            }
        }
        return eMr;
    }

    public void s(Runnable runnable) {
        if (this.bFJ != null) {
            this.bFJ.execute(runnable);
        }
    }

    public void destroy() {
        if (this.bFJ != null) {
            this.bFJ.shutdown();
            this.bFJ = null;
            eMr = null;
        }
    }
}
