package com.baidu.tieba.VideoCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class l {
    private static l bPy;
    private ExecutorService bPz = Executors.newFixedThreadPool(10);

    public static l Tg() {
        if (bPy == null) {
            synchronized (l.class) {
                if (bPy == null) {
                    bPy = new l();
                }
            }
        }
        return bPy;
    }

    public void f(Runnable runnable) {
        if (this.bPz != null) {
            this.bPz.execute(runnable);
        }
    }

    public void destroy() {
        if (this.bPz != null) {
            this.bPz.shutdown();
            this.bPz = null;
            bPy = null;
        }
    }
}
