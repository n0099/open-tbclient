package com.baidu.tieba.VideoCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class l {
    private static l bPG;
    private ExecutorService bPH = Executors.newFixedThreadPool(10);

    public static l Ti() {
        if (bPG == null) {
            synchronized (l.class) {
                if (bPG == null) {
                    bPG = new l();
                }
            }
        }
        return bPG;
    }

    public void f(Runnable runnable) {
        if (this.bPH != null) {
            this.bPH.execute(runnable);
        }
    }

    public void destroy() {
        if (this.bPH != null) {
            this.bPH.shutdown();
            this.bPH = null;
            bPG = null;
        }
    }
}
