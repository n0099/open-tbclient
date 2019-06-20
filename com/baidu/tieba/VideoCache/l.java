package com.baidu.tieba.VideoCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes4.dex */
public class l {
    private static l cUl;
    private ExecutorService cUm = Executors.newFixedThreadPool(10);

    public static l aAX() {
        if (cUl == null) {
            synchronized (l.class) {
                if (cUl == null) {
                    cUl = new l();
                }
            }
        }
        return cUl;
    }

    public void l(Runnable runnable) {
        if (this.cUm != null) {
            this.cUm.execute(runnable);
        }
    }

    public void destroy() {
        if (this.cUm != null) {
            this.cUm.shutdown();
            this.cUm = null;
            cUl = null;
        }
    }
}
