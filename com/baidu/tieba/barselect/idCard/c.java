package com.baidu.tieba.barselect.idCard;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes8.dex */
public class c {
    static Timer gzi = null;
    private static int gzj = Runtime.getRuntime().availableProcessors();
    private static ExecutorService fixedThreadPool = Executors.newFixedThreadPool(gzj);

    public static void execute(Runnable runnable) {
        fixedThreadPool.execute(runnable);
    }

    public static Timer v(final Runnable runnable) {
        if (gzi != null) {
            return gzi;
        }
        gzi = new Timer();
        gzi.scheduleAtFixedRate(new TimerTask() { // from class: com.baidu.tieba.barselect.idCard.c.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                runnable.run();
            }
        }, 0L, 2000L);
        return gzi;
    }

    public static void bKO() {
        if (gzi != null) {
            gzi.cancel();
            gzi = null;
        }
    }
}
