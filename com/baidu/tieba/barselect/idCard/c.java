package com.baidu.tieba.barselect.idCard;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes21.dex */
public class c {
    static Timer iei = null;
    private static int iej = Runtime.getRuntime().availableProcessors();
    private static ExecutorService fixedThreadPool = Executors.newFixedThreadPool(iej);

    public static void execute(Runnable runnable) {
        fixedThreadPool.execute(runnable);
    }

    public static Timer r(final Runnable runnable) {
        if (iei != null) {
            return iei;
        }
        iei = new Timer();
        iei.scheduleAtFixedRate(new TimerTask() { // from class: com.baidu.tieba.barselect.idCard.c.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                runnable.run();
            }
        }, 0L, 2000L);
        return iei;
    }

    public static void crA() {
        if (iei != null) {
            iei.cancel();
            iei = null;
        }
    }
}
