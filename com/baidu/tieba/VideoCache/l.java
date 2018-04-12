package com.baidu.tieba.VideoCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class l {
    private static l bbB;
    private ExecutorService bbC = Executors.newFixedThreadPool(10);

    public static l Mn() {
        if (bbB == null) {
            synchronized (l.class) {
                if (bbB == null) {
                    bbB = new l();
                }
            }
        }
        return bbB;
    }

    public void e(Runnable runnable) {
        if (this.bbC != null) {
            this.bbC.execute(runnable);
        }
    }

    public void destroy() {
        if (this.bbC != null) {
            this.bbC.shutdown();
            this.bbC = null;
            bbB = null;
        }
    }
}
