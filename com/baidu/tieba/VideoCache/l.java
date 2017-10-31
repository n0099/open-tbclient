package com.baidu.tieba.VideoCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class l {
    private static l aYh;
    private ExecutorService aYi = Executors.newFixedThreadPool(10);

    public static l Lh() {
        if (aYh == null) {
            synchronized (l.class) {
                if (aYh == null) {
                    aYh = new l();
                }
            }
        }
        return aYh;
    }

    public void e(Runnable runnable) {
        if (this.aYi != null) {
            this.aYi.execute(runnable);
        }
    }

    public void destroy() {
        if (this.aYi != null) {
            this.aYi.shutdown();
            this.aYi = null;
            aYh = null;
        }
    }
}
