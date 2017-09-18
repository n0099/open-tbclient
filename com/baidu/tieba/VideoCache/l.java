package com.baidu.tieba.VideoCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class l {
    private static l aWq;
    private ExecutorService aWr = Executors.newFixedThreadPool(10);

    public static l KM() {
        if (aWq == null) {
            synchronized (l.class) {
                if (aWq == null) {
                    aWq = new l();
                }
            }
        }
        return aWq;
    }

    public void e(Runnable runnable) {
        if (this.aWr != null) {
            this.aWr.execute(runnable);
        }
    }

    public void destroy() {
        if (this.aWr != null) {
            this.aWr.shutdown();
            this.aWr = null;
            aWq = null;
        }
    }
}
