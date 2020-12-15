package com.baidu.tieba.barselect.idCard;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes21.dex */
public class c {
    static Timer iek = null;
    private static int iel = Runtime.getRuntime().availableProcessors();
    private static ExecutorService fixedThreadPool = Executors.newFixedThreadPool(iel);

    public static void execute(Runnable runnable) {
        fixedThreadPool.execute(runnable);
    }

    public static Timer r(final Runnable runnable) {
        if (iek != null) {
            return iek;
        }
        iek = new Timer();
        iek.scheduleAtFixedRate(new TimerTask() { // from class: com.baidu.tieba.barselect.idCard.c.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                runnable.run();
            }
        }, 0L, 2000L);
        return iek;
    }

    public static void crB() {
        if (iek != null) {
            iek.cancel();
            iek = null;
        }
    }
}
