package com.baidu.tieba.VideoCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class l {
    private static l bRO;
    private ExecutorService bRP = Executors.newFixedThreadPool(10);

    public static l TR() {
        if (bRO == null) {
            synchronized (l.class) {
                if (bRO == null) {
                    bRO = new l();
                }
            }
        }
        return bRO;
    }

    public void f(Runnable runnable) {
        if (this.bRP != null) {
            this.bRP.execute(runnable);
        }
    }

    public void destroy() {
        if (this.bRP != null) {
            this.bRP.shutdown();
            this.bRP = null;
            bRO = null;
        }
    }
}
