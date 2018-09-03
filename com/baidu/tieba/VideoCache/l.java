package com.baidu.tieba.VideoCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class l {
    private static l blX;
    private ExecutorService blY = Executors.newFixedThreadPool(10);

    public static l Qu() {
        if (blX == null) {
            synchronized (l.class) {
                if (blX == null) {
                    blX = new l();
                }
            }
        }
        return blX;
    }

    public void e(Runnable runnable) {
        if (this.blY != null) {
            this.blY.execute(runnable);
        }
    }

    public void destroy() {
        if (this.blY != null) {
            this.blY.shutdown();
            this.blY = null;
            blX = null;
        }
    }
}
