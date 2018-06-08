package com.baidu.tieba.VideoCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class l {
    private static l bjN;
    private ExecutorService bjO = Executors.newFixedThreadPool(10);

    public static l PK() {
        if (bjN == null) {
            synchronized (l.class) {
                if (bjN == null) {
                    bjN = new l();
                }
            }
        }
        return bjN;
    }

    public void e(Runnable runnable) {
        if (this.bjO != null) {
            this.bjO.execute(runnable);
        }
    }

    public void destroy() {
        if (this.bjO != null) {
            this.bjO.shutdown();
            this.bjO = null;
            bjN = null;
        }
    }
}
