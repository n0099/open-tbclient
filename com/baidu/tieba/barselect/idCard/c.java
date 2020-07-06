package com.baidu.tieba.barselect.idCard;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes8.dex */
public class c {
    static Timer gLU = null;
    private static int gLV = Runtime.getRuntime().availableProcessors();
    private static ExecutorService fixedThreadPool = Executors.newFixedThreadPool(gLV);

    public static void execute(Runnable runnable) {
        fixedThreadPool.execute(runnable);
    }

    public static Timer v(final Runnable runnable) {
        if (gLU != null) {
            return gLU;
        }
        gLU = new Timer();
        gLU.scheduleAtFixedRate(new TimerTask() { // from class: com.baidu.tieba.barselect.idCard.c.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                runnable.run();
            }
        }, 0L, 2000L);
        return gLU;
    }

    public static void bNU() {
        if (gLU != null) {
            gLU.cancel();
            gLU = null;
        }
    }
}
