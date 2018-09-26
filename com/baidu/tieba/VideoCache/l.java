package com.baidu.tieba.VideoCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class l {
    private static l brL;
    private ExecutorService brM = Executors.newFixedThreadPool(10);

    public static l Si() {
        if (brL == null) {
            synchronized (l.class) {
                if (brL == null) {
                    brL = new l();
                }
            }
        }
        return brL;
    }

    public void e(Runnable runnable) {
        if (this.brM != null) {
            this.brM.execute(runnable);
        }
    }

    public void destroy() {
        if (this.brM != null) {
            this.brM.shutdown();
            this.brM = null;
            brL = null;
        }
    }
}
