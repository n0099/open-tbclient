package com.baidu.tieba.VideoCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class l {
    private static l bRE;
    private ExecutorService bRF = Executors.newFixedThreadPool(10);

    public static l TR() {
        if (bRE == null) {
            synchronized (l.class) {
                if (bRE == null) {
                    bRE = new l();
                }
            }
        }
        return bRE;
    }

    public void f(Runnable runnable) {
        if (this.bRF != null) {
            this.bRF.execute(runnable);
        }
    }

    public void destroy() {
        if (this.bRF != null) {
            this.bRF.shutdown();
            this.bRF = null;
            bRE = null;
        }
    }
}
