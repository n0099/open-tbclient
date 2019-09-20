package com.baidu.tieba.VideoCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes4.dex */
public class l {
    private static l cWH;
    private ExecutorService cWI = Executors.newFixedThreadPool(10);

    public static l aCC() {
        if (cWH == null) {
            synchronized (l.class) {
                if (cWH == null) {
                    cWH = new l();
                }
            }
        }
        return cWH;
    }

    public void m(Runnable runnable) {
        if (this.cWI != null) {
            this.cWI.execute(runnable);
        }
    }

    public void destroy() {
        if (this.cWI != null) {
            this.cWI.shutdown();
            this.cWI = null;
            cWH = null;
        }
    }
}
