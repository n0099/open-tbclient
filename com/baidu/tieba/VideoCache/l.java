package com.baidu.tieba.VideoCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class l {
    private static l bbC;
    private ExecutorService bbD = Executors.newFixedThreadPool(10);

    public static l Ml() {
        if (bbC == null) {
            synchronized (l.class) {
                if (bbC == null) {
                    bbC = new l();
                }
            }
        }
        return bbC;
    }

    public void e(Runnable runnable) {
        if (this.bbD != null) {
            this.bbD.execute(runnable);
        }
    }

    public void destroy() {
        if (this.bbD != null) {
            this.bbD.shutdown();
            this.bbD = null;
            bbC = null;
        }
    }
}
