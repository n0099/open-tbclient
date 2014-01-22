package com.baidu.tieba.im;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class o {
    private static LinkedBlockingQueue<Runnable> a = new LinkedBlockingQueue<>();
    private static Executor b = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, a, new p());

    public static <T> void a(SingleRunnable<T> singleRunnable, a<T> aVar) {
        if (a() > 5) {
            com.baidu.adp.lib.g.e.b("TiebaIMSingleExecutor queue size - " + a());
        }
        if (singleRunnable != null) {
            singleRunnable.a(aVar);
            b.execute(singleRunnable);
        }
    }

    public static int a() {
        return a.size();
    }
}
