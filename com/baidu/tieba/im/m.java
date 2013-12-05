package com.baidu.tieba.im;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    private static LinkedBlockingQueue<Runnable> f1789a = new LinkedBlockingQueue<>();
    private static Executor b = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, f1789a, new n());

    public static <T> void a(SingleRunnable<T> singleRunnable, a<T> aVar) {
        if (a() > 5) {
            com.baidu.adp.lib.h.e.b("TiebaIMSingleExecutor queue size - " + a());
        }
        if (singleRunnable != null) {
            singleRunnable.a(aVar);
            b.execute(singleRunnable);
        }
    }

    public static int a() {
        return f1789a.size();
    }

    public static void b() {
        f1789a.clear();
    }
}
