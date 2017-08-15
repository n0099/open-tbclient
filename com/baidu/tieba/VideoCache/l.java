package com.baidu.tieba.VideoCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class l {
    private static l aWI;
    private ExecutorService aWJ = Executors.newFixedThreadPool(10);

    public static l KC() {
        if (aWI == null) {
            synchronized (l.class) {
                if (aWI == null) {
                    aWI = new l();
                }
            }
        }
        return aWI;
    }

    public void g(Runnable runnable) {
        if (this.aWJ != null) {
            this.aWJ.execute(runnable);
        }
    }

    public void destroy() {
        if (this.aWJ != null) {
            this.aWJ.shutdown();
            this.aWJ = null;
            aWI = null;
        }
    }
}
