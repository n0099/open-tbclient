package com.baidu.tieba.barselect.idCard;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes6.dex */
public class c {
    static Timer fCc = null;
    private static int fCd = Runtime.getRuntime().availableProcessors();
    private static ExecutorService fixedThreadPool = Executors.newFixedThreadPool(fCd);

    public static void execute(Runnable runnable) {
        fixedThreadPool.execute(runnable);
    }

    public static Timer o(final Runnable runnable) {
        if (fCc != null) {
            return fCc;
        }
        fCc = new Timer();
        fCc.scheduleAtFixedRate(new TimerTask() { // from class: com.baidu.tieba.barselect.idCard.c.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                runnable.run();
            }
        }, 0L, 2000L);
        return fCc;
    }

    public static void bsY() {
        if (fCc != null) {
            fCc.cancel();
            fCc = null;
        }
    }
}
