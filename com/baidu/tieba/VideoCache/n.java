package com.baidu.tieba.VideoCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class n {
    private static n aUs;
    private ExecutorService aUt = Executors.newFixedThreadPool(10);

    public static n Kr() {
        if (aUs == null) {
            synchronized (n.class) {
                if (aUs == null) {
                    aUs = new n();
                }
            }
        }
        return aUs;
    }

    public void g(Runnable runnable) {
        if (this.aUt != null) {
            this.aUt.execute(runnable);
        }
    }

    public void destroy() {
        if (this.aUt != null) {
            this.aUt.shutdown();
            this.aUt = null;
            aUs = null;
        }
    }
}
