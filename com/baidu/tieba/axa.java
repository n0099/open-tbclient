package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public final class axa {
    public static /* synthetic */ Interceptable $ic;
    public static List<WeakReference<ScheduledFuture<?>>> a;
    public static ExecutorService b;
    public static ScheduledExecutorService c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947631935, "Lcom/baidu/tieba/axa;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947631935, "Lcom/baidu/tieba/axa;");
                return;
            }
        }
        a = new ArrayList();
        b = Executors.newFixedThreadPool(2);
        c = Executors.newScheduledThreadPool(2);
    }

    public static synchronized void a(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, runnable) == null) {
            synchronized (axa.class) {
                if (c == null || c.isShutdown()) {
                    c = Executors.newScheduledThreadPool(2);
                }
                c.execute(runnable);
            }
        }
    }

    public static void c(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, runnable) == null) {
            ExecutorService executorService = b;
            if (executorService == null || executorService.isShutdown()) {
                b = Executors.newFixedThreadPool(2);
            }
            b.execute(runnable);
        }
    }

    public static synchronized void b(Runnable runnable, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{runnable, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            synchronized (axa.class) {
                if (c == null || c.isShutdown()) {
                    c = Executors.newScheduledThreadPool(2);
                }
                a.add(new WeakReference<>(c.scheduleAtFixedRate(runnable, j, j2, TimeUnit.MILLISECONDS)));
            }
        }
    }
}
