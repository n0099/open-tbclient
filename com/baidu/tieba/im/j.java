package com.baidu.tieba.im;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class j {
    private static LinkedBlockingQueue<Runnable> a = new LinkedBlockingQueue<>();
    private static Executor b = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, a, new k());

    public static <T> void a(c<T> cVar, a<T> aVar) {
        if (a() > 5) {
            com.baidu.adp.lib.util.f.c("TiebaIMSingleExecutor queue size - " + a());
        }
        if (cVar != null) {
            cVar.a(aVar);
            b.execute(cVar);
        }
    }

    public static int a() {
        return a.size();
    }

    public static void b() {
        a.clear();
    }
}
