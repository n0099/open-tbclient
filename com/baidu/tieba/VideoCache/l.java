package com.baidu.tieba.VideoCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class l {
    private static l blm;
    private ExecutorService bln = Executors.newFixedThreadPool(10);

    public static l Qh() {
        if (blm == null) {
            synchronized (l.class) {
                if (blm == null) {
                    blm = new l();
                }
            }
        }
        return blm;
    }

    public void e(Runnable runnable) {
        if (this.bln != null) {
            this.bln.execute(runnable);
        }
    }

    public void destroy() {
        if (this.bln != null) {
            this.bln.shutdown();
            this.bln = null;
            blm = null;
        }
    }
}
