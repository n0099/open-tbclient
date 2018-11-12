package com.baidu.tieba.VideoCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes6.dex */
public class l {
    private static l bwE;
    private ExecutorService bwF = Executors.newFixedThreadPool(10);

    public static l Un() {
        if (bwE == null) {
            synchronized (l.class) {
                if (bwE == null) {
                    bwE = new l();
                }
            }
        }
        return bwE;
    }

    public void e(Runnable runnable) {
        if (this.bwF != null) {
            this.bwF.execute(runnable);
        }
    }

    public void destroy() {
        if (this.bwF != null) {
            this.bwF.shutdown();
            this.bwF = null;
            bwE = null;
        }
    }
}
