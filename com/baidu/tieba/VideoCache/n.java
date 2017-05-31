package com.baidu.tieba.VideoCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class n {
    private static n aSZ;
    private ExecutorService aTa = Executors.newFixedThreadPool(10);

    public static n JT() {
        if (aSZ == null) {
            synchronized (n.class) {
                if (aSZ == null) {
                    aSZ = new n();
                }
            }
        }
        return aSZ;
    }

    public void g(Runnable runnable) {
        if (this.aTa != null) {
            this.aTa.execute(runnable);
        }
    }

    public void destroy() {
        if (this.aTa != null) {
            this.aTa.shutdown();
            this.aTa = null;
            aSZ = null;
        }
    }
}
