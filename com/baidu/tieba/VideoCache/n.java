package com.baidu.tieba.VideoCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes.dex */
public class n {
    private static n aUN;
    private ExecutorService aUO = Executors.newFixedThreadPool(10);

    public static n Lk() {
        if (aUN == null) {
            synchronized (n.class) {
                if (aUN == null) {
                    aUN = new n();
                }
            }
        }
        return aUN;
    }

    public void g(Runnable runnable) {
        if (this.aUO != null) {
            this.aUO.execute(runnable);
        }
    }

    public void destroy() {
        if (this.aUO != null) {
            this.aUO.shutdown();
            this.aUO = null;
            aUN = null;
        }
    }
}
