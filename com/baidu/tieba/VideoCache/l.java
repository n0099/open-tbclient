package com.baidu.tieba.VideoCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class l {
    private static l blS;
    private ExecutorService blT = Executors.newFixedThreadPool(10);

    public static l Qo() {
        if (blS == null) {
            synchronized (l.class) {
                if (blS == null) {
                    blS = new l();
                }
            }
        }
        return blS;
    }

    public void e(Runnable runnable) {
        if (this.blT != null) {
            this.blT.execute(runnable);
        }
    }

    public void destroy() {
        if (this.blT != null) {
            this.blT.shutdown();
            this.blT = null;
            blS = null;
        }
    }
}
