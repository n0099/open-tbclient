package com.baidu.tieba.VideoCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class l {
    private static l bRB;
    private ExecutorService bRC = Executors.newFixedThreadPool(10);

    public static l TQ() {
        if (bRB == null) {
            synchronized (l.class) {
                if (bRB == null) {
                    bRB = new l();
                }
            }
        }
        return bRB;
    }

    public void f(Runnable runnable) {
        if (this.bRC != null) {
            this.bRC.execute(runnable);
        }
    }

    public void destroy() {
        if (this.bRC != null) {
            this.bRC.shutdown();
            this.bRC = null;
            bRB = null;
        }
    }
}
