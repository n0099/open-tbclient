package com.baidu.tieba.VideoCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes9.dex */
public class l {
    private static l dXP;
    private ExecutorService aZB = Executors.newFixedThreadPool(10);

    public static l aXt() {
        if (dXP == null) {
            synchronized (l.class) {
                if (dXP == null) {
                    dXP = new l();
                }
            }
        }
        return dXP;
    }

    public void n(Runnable runnable) {
        if (this.aZB != null) {
            this.aZB.execute(runnable);
        }
    }

    public void destroy() {
        if (this.aZB != null) {
            this.aZB.shutdown();
            this.aZB = null;
            dXP = null;
        }
    }
}
