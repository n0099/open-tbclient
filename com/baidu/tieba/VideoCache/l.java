package com.baidu.tieba.VideoCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes9.dex */
public class l {
    private static l dXm;
    private ExecutorService aZn = Executors.newFixedThreadPool(10);

    public static l aXo() {
        if (dXm == null) {
            synchronized (l.class) {
                if (dXm == null) {
                    dXm = new l();
                }
            }
        }
        return dXm;
    }

    public void n(Runnable runnable) {
        if (this.aZn != null) {
            this.aZn.execute(runnable);
        }
    }

    public void destroy() {
        if (this.aZn != null) {
            this.aZn.shutdown();
            this.aZn = null;
            dXm = null;
        }
    }
}
