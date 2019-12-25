package com.baidu.tieba.VideoCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes6.dex */
public class l {
    private static l dSX;
    private ExecutorService aUi = Executors.newFixedThreadPool(10);

    public static l aUC() {
        if (dSX == null) {
            synchronized (l.class) {
                if (dSX == null) {
                    dSX = new l();
                }
            }
        }
        return dSX;
    }

    public void n(Runnable runnable) {
        if (this.aUi != null) {
            this.aUi.execute(runnable);
        }
    }

    public void destroy() {
        if (this.aUi != null) {
            this.aUi.shutdown();
            this.aUi = null;
            dSX = null;
        }
    }
}
