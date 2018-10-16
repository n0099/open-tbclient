package com.baidu.tieba.VideoCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes6.dex */
public class l {
    private static l bvT;
    private ExecutorService bvU = Executors.newFixedThreadPool(10);

    public static l Ue() {
        if (bvT == null) {
            synchronized (l.class) {
                if (bvT == null) {
                    bvT = new l();
                }
            }
        }
        return bvT;
    }

    public void e(Runnable runnable) {
        if (this.bvU != null) {
            this.bvU.execute(runnable);
        }
    }

    public void destroy() {
        if (this.bvU != null) {
            this.bvU.shutdown();
            this.bvU = null;
            bvT = null;
        }
    }
}
