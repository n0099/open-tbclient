package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.b1c;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.internal.schedulers.ScheduledAction;
import rx.internal.util.RxThreadFactory;
/* loaded from: classes5.dex */
public class e3c extends b1c.a implements f1c {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public static final int d;
    public static final ConcurrentHashMap<ScheduledThreadPoolExecutor, ScheduledThreadPoolExecutor> e;
    public static final AtomicReference<ScheduledExecutorService> f;
    public static volatile Object g;
    public static final Object h;
    public transient /* synthetic */ FieldHolder $fh;
    public final ScheduledExecutorService a;
    public volatile boolean b;

    /* loaded from: classes5.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                e3c.f();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        boolean z;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947684852, "Lcom/baidu/tieba/e3c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947684852, "Lcom/baidu/tieba/e3c;");
                return;
            }
        }
        h = new Object();
        e = new ConcurrentHashMap<>();
        f = new AtomicReference<>();
        d = Integer.getInteger("rx.scheduler.jdk6.purge-frequency-millis", 1000).intValue();
        boolean z2 = Boolean.getBoolean("rx.scheduler.jdk6.purge-force");
        int a2 = m3c.a();
        if (!z2 && (a2 == 0 || a2 >= 21)) {
            z = true;
        } else {
            z = false;
        }
        c = z;
    }

    public e3c(ThreadFactory threadFactory) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {threadFactory};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        if (!k(newScheduledThreadPool) && (newScheduledThreadPool instanceof ScheduledThreadPoolExecutor)) {
            g((ScheduledThreadPoolExecutor) newScheduledThreadPool);
        }
        this.a = newScheduledThreadPool;
    }

    public static Method e(ScheduledExecutorService scheduledExecutorService) {
        InterceptResult invokeL;
        Method[] methods;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, scheduledExecutorService)) == null) {
            for (Method method : scheduledExecutorService.getClass().getMethods()) {
                if (method.getName().equals("setRemoveOnCancelPolicy")) {
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    if (parameterTypes.length == 1 && parameterTypes[0] == Boolean.TYPE) {
                        return method;
                    }
                }
            }
            return null;
        }
        return (Method) invokeL.objValue;
    }

    public static void d(ScheduledExecutorService scheduledExecutorService) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, scheduledExecutorService) == null) {
            e.remove(scheduledExecutorService);
        }
    }

    @Override // com.baidu.tieba.b1c.a
    public f1c b(l1c l1cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, l1cVar)) == null) {
            return c(l1cVar, 0L, null);
        }
        return (f1c) invokeL.objValue;
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            try {
                Iterator<ScheduledThreadPoolExecutor> it = e.keySet().iterator();
                while (it.hasNext()) {
                    ScheduledThreadPoolExecutor next = it.next();
                    if (!next.isShutdown()) {
                        next.purge();
                    } else {
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                k1c.e(th);
                l5c.j(th);
            }
        }
    }

    public static void g(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, scheduledThreadPoolExecutor) == null) {
            while (true) {
                if (f.get() != null) {
                    break;
                }
                ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, new RxThreadFactory("RxSchedulerPurge-"));
                if (f.compareAndSet(null, newScheduledThreadPool)) {
                    a aVar = new a();
                    int i = d;
                    newScheduledThreadPool.scheduleAtFixedRate(aVar, i, i, TimeUnit.MILLISECONDS);
                    break;
                }
                newScheduledThreadPool.shutdownNow();
            }
            e.putIfAbsent(scheduledThreadPoolExecutor, scheduledThreadPoolExecutor);
        }
    }

    public static boolean k(ScheduledExecutorService scheduledExecutorService) {
        InterceptResult invokeL;
        Method e2;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, scheduledExecutorService)) == null) {
            if (c) {
                if (scheduledExecutorService instanceof ScheduledThreadPoolExecutor) {
                    Object obj2 = g;
                    if (obj2 == h) {
                        return false;
                    }
                    if (obj2 == null) {
                        e2 = e(scheduledExecutorService);
                        if (e2 != null) {
                            obj = e2;
                        } else {
                            obj = h;
                        }
                        g = obj;
                    } else {
                        e2 = (Method) obj2;
                    }
                } else {
                    e2 = e(scheduledExecutorService);
                }
                if (e2 != null) {
                    try {
                        e2.invoke(scheduledExecutorService, Boolean.TRUE);
                        return true;
                    } catch (IllegalAccessException e3) {
                        l5c.j(e3);
                    } catch (IllegalArgumentException e4) {
                        l5c.j(e4);
                    } catch (InvocationTargetException e5) {
                        l5c.j(e5);
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.b1c.a
    public f1c c(l1c l1cVar, long j, TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{l1cVar, Long.valueOf(j), timeUnit})) == null) {
            if (this.b) {
                return b6c.c();
            }
            return h(l1cVar, j, timeUnit);
        }
        return (f1c) invokeCommon.objValue;
    }

    public ScheduledAction h(l1c l1cVar, long j, TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Future<?> schedule;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{l1cVar, Long.valueOf(j), timeUnit})) == null) {
            ScheduledAction scheduledAction = new ScheduledAction(l5c.q(l1cVar));
            if (j <= 0) {
                schedule = this.a.submit(scheduledAction);
            } else {
                schedule = this.a.schedule(scheduledAction, j, timeUnit);
            }
            scheduledAction.add(schedule);
            return scheduledAction;
        }
        return (ScheduledAction) invokeCommon.objValue;
    }

    public ScheduledAction i(l1c l1cVar, long j, TimeUnit timeUnit, p3c p3cVar) {
        InterceptResult invokeCommon;
        Future<?> schedule;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{l1cVar, Long.valueOf(j), timeUnit, p3cVar})) == null) {
            ScheduledAction scheduledAction = new ScheduledAction(l5c.q(l1cVar), p3cVar);
            p3cVar.a(scheduledAction);
            if (j <= 0) {
                schedule = this.a.submit(scheduledAction);
            } else {
                schedule = this.a.schedule(scheduledAction, j, timeUnit);
            }
            scheduledAction.add(schedule);
            return scheduledAction;
        }
        return (ScheduledAction) invokeCommon.objValue;
    }

    public ScheduledAction j(l1c l1cVar, long j, TimeUnit timeUnit, y5c y5cVar) {
        InterceptResult invokeCommon;
        Future<?> schedule;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{l1cVar, Long.valueOf(j), timeUnit, y5cVar})) == null) {
            ScheduledAction scheduledAction = new ScheduledAction(l5c.q(l1cVar), y5cVar);
            y5cVar.a(scheduledAction);
            if (j <= 0) {
                schedule = this.a.submit(scheduledAction);
            } else {
                schedule = this.a.schedule(scheduledAction, j, timeUnit);
            }
            scheduledAction.add(schedule);
            return scheduledAction;
        }
        return (ScheduledAction) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.f1c
    public boolean isUnsubscribed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.f1c
    public void unsubscribe() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.b = true;
            this.a.shutdownNow();
            d(this.a);
        }
    }
}
