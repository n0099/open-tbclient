package com.baidu.tieba.VideoCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class l {
    private static l bbG;
    private ExecutorService bbH = Executors.newFixedThreadPool(10);

    public static l LT() {
        if (bbG == null) {
            synchronized (l.class) {
                if (bbG == null) {
                    bbG = new l();
                }
            }
        }
        return bbG;
    }

    public void e(Runnable runnable) {
        if (this.bbH != null) {
            this.bbH.execute(runnable);
        }
    }

    public void destroy() {
        if (this.bbH != null) {
            this.bbH.shutdown();
            this.bbH = null;
            bbG = null;
        }
    }
}
