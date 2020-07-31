package com.baidu.tieba.barselect.idCard;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes15.dex */
public class c {
    static Timer gRA = null;
    private static int gRB = Runtime.getRuntime().availableProcessors();
    private static ExecutorService fixedThreadPool = Executors.newFixedThreadPool(gRB);

    public static void execute(Runnable runnable) {
        fixedThreadPool.execute(runnable);
    }

    public static Timer u(final Runnable runnable) {
        if (gRA != null) {
            return gRA;
        }
        gRA = new Timer();
        gRA.scheduleAtFixedRate(new TimerTask() { // from class: com.baidu.tieba.barselect.idCard.c.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                runnable.run();
            }
        }, 0L, 2000L);
        return gRA;
    }

    public static void bRf() {
        if (gRA != null) {
            gRA.cancel();
            gRA = null;
        }
    }
}
