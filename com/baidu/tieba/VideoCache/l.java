package com.baidu.tieba.VideoCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes4.dex */
public class l {
    private static l cUj;
    private ExecutorService cUk = Executors.newFixedThreadPool(10);

    public static l aAU() {
        if (cUj == null) {
            synchronized (l.class) {
                if (cUj == null) {
                    cUj = new l();
                }
            }
        }
        return cUj;
    }

    public void l(Runnable runnable) {
        if (this.cUk != null) {
            this.cUk.execute(runnable);
        }
    }

    public void destroy() {
        if (this.cUk != null) {
            this.cUk.shutdown();
            this.cUk = null;
            cUj = null;
        }
    }
}
