package com.baidu.tieba.im;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class s {
    private static LinkedBlockingQueue<Runnable> a = new LinkedBlockingQueue<>();
    private static Executor b = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, a, new t());

    public static <T> void a(m<T> mVar, a<T> aVar) {
        if (a.size() > 5) {
            com.baidu.adp.lib.util.f.c("TiebaIMSingleExecutor queue size - " + a.size());
        }
        if (mVar != null) {
            mVar.a(aVar);
            b.execute(mVar);
        }
    }

    public static int a() {
        return a.size();
    }

    public static void b() {
        a.clear();
    }
}
