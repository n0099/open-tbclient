package com.baidu.tieba.barselect.idCard;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes15.dex */
public class c {
    static Timer hes = null;
    private static int het = Runtime.getRuntime().availableProcessors();
    private static ExecutorService fixedThreadPool = Executors.newFixedThreadPool(het);

    public static void execute(Runnable runnable) {
        fixedThreadPool.execute(runnable);
    }

    public static Timer r(final Runnable runnable) {
        if (hes != null) {
            return hes;
        }
        hes = new Timer();
        hes.scheduleAtFixedRate(new TimerTask() { // from class: com.baidu.tieba.barselect.idCard.c.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                runnable.run();
            }
        }, 0L, 2000L);
        return hes;
    }

    public static void cbr() {
        if (hes != null) {
            hes.cancel();
            hes = null;
        }
    }
}
