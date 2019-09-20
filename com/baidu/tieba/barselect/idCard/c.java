package com.baidu.tieba.barselect.idCard;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes3.dex */
public class c {
    static Timer ezc = null;
    private static int ezd = Runtime.getRuntime().availableProcessors();
    private static ExecutorService fixedThreadPool = Executors.newFixedThreadPool(ezd);

    public static void execute(Runnable runnable) {
        fixedThreadPool.execute(runnable);
    }

    public static Timer n(final Runnable runnable) {
        if (ezc != null) {
            return ezc;
        }
        ezc = new Timer();
        ezc.scheduleAtFixedRate(new TimerTask() { // from class: com.baidu.tieba.barselect.idCard.c.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                runnable.run();
            }
        }, 0L, 2000L);
        return ezc;
    }

    public static void aZS() {
        if (ezc != null) {
            ezc.cancel();
            ezc = null;
        }
    }
}
