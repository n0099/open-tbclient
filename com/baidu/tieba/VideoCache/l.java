package com.baidu.tieba.VideoCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class l {
    private static l aXR;
    private ExecutorService aXS = Executors.newFixedThreadPool(10);

    public static l KY() {
        if (aXR == null) {
            synchronized (l.class) {
                if (aXR == null) {
                    aXR = new l();
                }
            }
        }
        return aXR;
    }

    public void e(Runnable runnable) {
        if (this.aXS != null) {
            this.aXS.execute(runnable);
        }
    }

    public void destroy() {
        if (this.aXS != null) {
            this.aXS.shutdown();
            this.aXS = null;
            aXR = null;
        }
    }
}
