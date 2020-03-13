package com.baidu.tieba.VideoCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes9.dex */
public class l {
    private static l dXz;
    private ExecutorService aZo = Executors.newFixedThreadPool(10);

    public static l aXp() {
        if (dXz == null) {
            synchronized (l.class) {
                if (dXz == null) {
                    dXz = new l();
                }
            }
        }
        return dXz;
    }

    public void n(Runnable runnable) {
        if (this.aZo != null) {
            this.aZo.execute(runnable);
        }
    }

    public void destroy() {
        if (this.aZo != null) {
            this.aZo.shutdown();
            this.aZo = null;
            dXz = null;
        }
    }
}
