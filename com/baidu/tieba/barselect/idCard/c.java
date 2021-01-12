package com.baidu.tieba.barselect.idCard;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes7.dex */
public class c {
    static Timer ilW = null;
    private static int ilX = Runtime.getRuntime().availableProcessors();
    private static ExecutorService fixedThreadPool = Executors.newFixedThreadPool(ilX);

    public static void execute(Runnable runnable) {
        fixedThreadPool.execute(runnable);
    }

    public static Timer q(final Runnable runnable) {
        if (ilW != null) {
            return ilW;
        }
        ilW = new Timer();
        ilW.scheduleAtFixedRate(new TimerTask() { // from class: com.baidu.tieba.barselect.idCard.c.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                runnable.run();
            }
        }, 0L, 2000L);
        return ilW;
    }

    public static void cqD() {
        if (ilW != null) {
            ilW.cancel();
            ilW = null;
        }
    }
}
