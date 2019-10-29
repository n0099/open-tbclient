package com.baidu.tieba.VideoCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes4.dex */
public class l {
    private static l dgc;
    private ExecutorService dgd = Executors.newFixedThreadPool(10);

    public static l aCL() {
        if (dgc == null) {
            synchronized (l.class) {
                if (dgc == null) {
                    dgc = new l();
                }
            }
        }
        return dgc;
    }

    public void k(Runnable runnable) {
        if (this.dgd != null) {
            this.dgd.execute(runnable);
        }
    }

    public void destroy() {
        if (this.dgd != null) {
            this.dgd.shutdown();
            this.dgd = null;
            dgc = null;
        }
    }
}
