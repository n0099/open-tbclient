package com.baidu.tieba.im;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    private static LinkedBlockingQueue<Runnable> f1716a = new LinkedBlockingQueue<>();
    private static Executor b = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, f1716a, new n());

    public static <T> void a(SingleRunnable<T> singleRunnable, a<T> aVar) {
        if (a() > 5) {
            com.baidu.adp.lib.h.d.b("TiebaIMSingleExecutor queue size - " + a());
        }
        if (singleRunnable != null) {
            singleRunnable.a(aVar);
            b.execute(singleRunnable);
        }
    }

    public static int a() {
        return f1716a.size();
    }

    public static void b() {
        f1716a.clear();
    }
}
