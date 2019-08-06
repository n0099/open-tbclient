package com.baidu.tieba.VideoCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes4.dex */
public class l {
    private static l cVO;
    private ExecutorService cVP = Executors.newFixedThreadPool(10);

    public static l aCo() {
        if (cVO == null) {
            synchronized (l.class) {
                if (cVO == null) {
                    cVO = new l();
                }
            }
        }
        return cVO;
    }

    public void m(Runnable runnable) {
        if (this.cVP != null) {
            this.cVP.execute(runnable);
        }
    }

    public void destroy() {
        if (this.cVP != null) {
            this.cVP.shutdown();
            this.cVP = null;
            cVO = null;
        }
    }
}
