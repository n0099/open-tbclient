package com.baidu.tieba.VideoCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes4.dex */
public class l {
    private static l cUk;
    private ExecutorService cUl = Executors.newFixedThreadPool(10);

    public static l aAX() {
        if (cUk == null) {
            synchronized (l.class) {
                if (cUk == null) {
                    cUk = new l();
                }
            }
        }
        return cUk;
    }

    public void l(Runnable runnable) {
        if (this.cUl != null) {
            this.cUl.execute(runnable);
        }
    }

    public void destroy() {
        if (this.cUl != null) {
            this.cUl.shutdown();
            this.cUl = null;
            cUk = null;
        }
    }
}
