package com.baidu.tieba.VideoCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes6.dex */
public class l {
    private static l bAb;
    private ExecutorService bAc = Executors.newFixedThreadPool(10);

    public static l Vt() {
        if (bAb == null) {
            synchronized (l.class) {
                if (bAb == null) {
                    bAb = new l();
                }
            }
        }
        return bAb;
    }

    public void f(Runnable runnable) {
        if (this.bAc != null) {
            this.bAc.execute(runnable);
        }
    }

    public void destroy() {
        if (this.bAc != null) {
            this.bAc.shutdown();
            this.bAc = null;
            bAb = null;
        }
    }
}
