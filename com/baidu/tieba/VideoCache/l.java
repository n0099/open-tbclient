package com.baidu.tieba.VideoCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class l {
    private static l aYe;
    private ExecutorService aYf = Executors.newFixedThreadPool(10);

    public static l Le() {
        if (aYe == null) {
            synchronized (l.class) {
                if (aYe == null) {
                    aYe = new l();
                }
            }
        }
        return aYe;
    }

    public void e(Runnable runnable) {
        if (this.aYf != null) {
            this.aYf.execute(runnable);
        }
    }

    public void destroy() {
        if (this.aYf != null) {
            this.aYf.shutdown();
            this.aYf = null;
            aYe = null;
        }
    }
}
