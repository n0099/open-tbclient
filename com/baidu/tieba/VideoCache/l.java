package com.baidu.tieba.VideoCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class l {
    private static l aYq;
    private ExecutorService aYr = Executors.newFixedThreadPool(10);

    public static l Ls() {
        if (aYq == null) {
            synchronized (l.class) {
                if (aYq == null) {
                    aYq = new l();
                }
            }
        }
        return aYq;
    }

    public void e(Runnable runnable) {
        if (this.aYr != null) {
            this.aYr.execute(runnable);
        }
    }

    public void destroy() {
        if (this.aYr != null) {
            this.aYr.shutdown();
            this.aYr = null;
            aYq = null;
        }
    }
}
