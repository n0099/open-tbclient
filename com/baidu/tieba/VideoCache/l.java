package com.baidu.tieba.VideoCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes6.dex */
public class l {
    private static l bAS;
    private ExecutorService bAT = Executors.newFixedThreadPool(10);

    public static l VR() {
        if (bAS == null) {
            synchronized (l.class) {
                if (bAS == null) {
                    bAS = new l();
                }
            }
        }
        return bAS;
    }

    public void f(Runnable runnable) {
        if (this.bAT != null) {
            this.bAT.execute(runnable);
        }
    }

    public void destroy() {
        if (this.bAT != null) {
            this.bAT.shutdown();
            this.bAT = null;
            bAS = null;
        }
    }
}
