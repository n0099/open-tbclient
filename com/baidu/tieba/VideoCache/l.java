package com.baidu.tieba.VideoCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes9.dex */
public class l {
    private static l dXl;
    private ExecutorService aZm = Executors.newFixedThreadPool(10);

    public static l aXm() {
        if (dXl == null) {
            synchronized (l.class) {
                if (dXl == null) {
                    dXl = new l();
                }
            }
        }
        return dXl;
    }

    public void n(Runnable runnable) {
        if (this.aZm != null) {
            this.aZm.execute(runnable);
        }
    }

    public void destroy() {
        if (this.aZm != null) {
            this.aZm.shutdown();
            this.aZm = null;
            dXl = null;
        }
    }
}
