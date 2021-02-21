package com.baidu.tieba.barselect.idCard;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes8.dex */
public class c {
    static Timer irQ = null;
    private static int irR = Runtime.getRuntime().availableProcessors();
    private static ExecutorService fixedThreadPool = Executors.newFixedThreadPool(irR);

    public static void execute(Runnable runnable) {
        fixedThreadPool.execute(runnable);
    }

    public static Timer o(final Runnable runnable) {
        if (irQ != null) {
            return irQ;
        }
        irQ = new Timer();
        irQ.scheduleAtFixedRate(new TimerTask() { // from class: com.baidu.tieba.barselect.idCard.c.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                runnable.run();
            }
        }, 0L, 2000L);
        return irQ;
    }

    public static void crU() {
        if (irQ != null) {
            irQ.cancel();
            irQ = null;
        }
    }
}
