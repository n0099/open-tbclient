package com.baidu.tieba.VideoCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes6.dex */
public class l {
    private static l bAR;
    private ExecutorService bAS = Executors.newFixedThreadPool(10);

    public static l VR() {
        if (bAR == null) {
            synchronized (l.class) {
                if (bAR == null) {
                    bAR = new l();
                }
            }
        }
        return bAR;
    }

    public void f(Runnable runnable) {
        if (this.bAS != null) {
            this.bAS.execute(runnable);
        }
    }

    public void destroy() {
        if (this.bAS != null) {
            this.bAS.shutdown();
            this.bAS = null;
            bAR = null;
        }
    }
}
