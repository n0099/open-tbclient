package com.baidu.tieba.VideoCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes6.dex */
public class l {
    private static l bAe;
    private ExecutorService bAf = Executors.newFixedThreadPool(10);

    public static l Vv() {
        if (bAe == null) {
            synchronized (l.class) {
                if (bAe == null) {
                    bAe = new l();
                }
            }
        }
        return bAe;
    }

    public void f(Runnable runnable) {
        if (this.bAf != null) {
            this.bAf.execute(runnable);
        }
    }

    public void destroy() {
        if (this.bAf != null) {
            this.bAf.shutdown();
            this.bAf = null;
            bAe = null;
        }
    }
}
