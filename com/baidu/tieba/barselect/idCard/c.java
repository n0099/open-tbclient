package com.baidu.tieba.barselect.idCard;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes21.dex */
public class c {
    static Timer hMO = null;
    private static int hMP = Runtime.getRuntime().availableProcessors();
    private static ExecutorService fixedThreadPool = Executors.newFixedThreadPool(hMP);

    public static void execute(Runnable runnable) {
        fixedThreadPool.execute(runnable);
    }

    public static Timer r(final Runnable runnable) {
        if (hMO != null) {
            return hMO;
        }
        hMO = new Timer();
        hMO.scheduleAtFixedRate(new TimerTask() { // from class: com.baidu.tieba.barselect.idCard.c.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                runnable.run();
            }
        }, 0L, 2000L);
        return hMO;
    }

    public static void clk() {
        if (hMO != null) {
            hMO.cancel();
            hMO = null;
        }
    }
}
