package com.baidu.tieba.VideoCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class l {
    private static l aWH;
    private ExecutorService aWI = Executors.newFixedThreadPool(10);

    public static l KC() {
        if (aWH == null) {
            synchronized (l.class) {
                if (aWH == null) {
                    aWH = new l();
                }
            }
        }
        return aWH;
    }

    public void g(Runnable runnable) {
        if (this.aWI != null) {
            this.aWI.execute(runnable);
        }
    }

    public void destroy() {
        if (this.aWI != null) {
            this.aWI.shutdown();
            this.aWI = null;
            aWH = null;
        }
    }
}
