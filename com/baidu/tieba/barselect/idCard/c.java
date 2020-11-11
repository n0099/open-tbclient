package com.baidu.tieba.barselect.idCard;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes21.dex */
public class c {
    static Timer hSL = null;
    private static int hSM = Runtime.getRuntime().availableProcessors();
    private static ExecutorService fixedThreadPool = Executors.newFixedThreadPool(hSM);

    public static void execute(Runnable runnable) {
        fixedThreadPool.execute(runnable);
    }

    public static Timer r(final Runnable runnable) {
        if (hSL != null) {
            return hSL;
        }
        hSL = new Timer();
        hSL.scheduleAtFixedRate(new TimerTask() { // from class: com.baidu.tieba.barselect.idCard.c.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                runnable.run();
            }
        }, 0L, 2000L);
        return hSL;
    }

    public static void cnL() {
        if (hSL != null) {
            hSL.cancel();
            hSL = null;
        }
    }
}
