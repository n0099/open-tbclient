package com.baidu.tieba.VideoCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes.dex */
public class p {
    private static p aNs;
    private ExecutorService aNt = Executors.newFixedThreadPool(10);

    public static p JH() {
        if (aNs == null) {
            synchronized (p.class) {
                if (aNs == null) {
                    aNs = new p();
                }
            }
        }
        return aNs;
    }

    public void g(Runnable runnable) {
        if (this.aNt != null) {
            this.aNt.execute(runnable);
        }
    }

    public void destroy() {
        if (this.aNt != null) {
            this.aNt.shutdown();
            this.aNt = null;
            aNs = null;
        }
    }
}
