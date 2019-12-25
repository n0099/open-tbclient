package com.baidu.tieba.barselect.idCard;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes5.dex */
public class c {
    static Timer fyR = null;
    private static int fyS = Runtime.getRuntime().availableProcessors();
    private static ExecutorService fixedThreadPool = Executors.newFixedThreadPool(fyS);

    public static void execute(Runnable runnable) {
        fixedThreadPool.execute(runnable);
    }

    public static Timer o(final Runnable runnable) {
        if (fyR != null) {
            return fyR;
        }
        fyR = new Timer();
        fyR.scheduleAtFixedRate(new TimerTask() { // from class: com.baidu.tieba.barselect.idCard.c.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                runnable.run();
            }
        }, 0L, 2000L);
        return fyR;
    }

    public static void brW() {
        if (fyR != null) {
            fyR.cancel();
            fyR = null;
        }
    }
}
