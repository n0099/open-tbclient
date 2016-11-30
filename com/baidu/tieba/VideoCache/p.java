package com.baidu.tieba.VideoCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes.dex */
public class p {
    private static p aQH;
    private ExecutorService aQI = Executors.newFixedThreadPool(10);

    public static p KX() {
        if (aQH == null) {
            synchronized (p.class) {
                if (aQH == null) {
                    aQH = new p();
                }
            }
        }
        return aQH;
    }

    public void g(Runnable runnable) {
        if (this.aQI != null) {
            this.aQI.execute(runnable);
        }
    }

    public void destroy() {
        if (this.aQI != null) {
            this.aQI.shutdown();
            this.aQI = null;
            aQH = null;
        }
    }
}
