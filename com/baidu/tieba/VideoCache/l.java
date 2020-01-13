package com.baidu.tieba.VideoCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes7.dex */
public class l {
    private static l dTg;
    private ExecutorService aVa = Executors.newFixedThreadPool(10);

    public static l aUW() {
        if (dTg == null) {
            synchronized (l.class) {
                if (dTg == null) {
                    dTg = new l();
                }
            }
        }
        return dTg;
    }

    public void n(Runnable runnable) {
        if (this.aVa != null) {
            this.aVa.execute(runnable);
        }
    }

    public void destroy() {
        if (this.aVa != null) {
            this.aVa.shutdown();
            this.aVa = null;
            dTg = null;
        }
    }
}
