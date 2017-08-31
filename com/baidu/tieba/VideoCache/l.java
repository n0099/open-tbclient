package com.baidu.tieba.VideoCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class l {
    private static l aWt;
    private ExecutorService aWu = Executors.newFixedThreadPool(10);

    public static l KM() {
        if (aWt == null) {
            synchronized (l.class) {
                if (aWt == null) {
                    aWt = new l();
                }
            }
        }
        return aWt;
    }

    public void e(Runnable runnable) {
        if (this.aWu != null) {
            this.aWu.execute(runnable);
        }
    }

    public void destroy() {
        if (this.aWu != null) {
            this.aWu.shutdown();
            this.aWu = null;
            aWt = null;
        }
    }
}
