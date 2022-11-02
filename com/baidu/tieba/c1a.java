package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.jz9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import rx.internal.schedulers.ScheduledAction;
/* loaded from: classes3.dex */
public final class c1a extends jz9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Executor a;

    /* loaded from: classes3.dex */
    public static final class a extends jz9.a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Executor a;
        public final a4a b;
        public final ConcurrentLinkedQueue<ScheduledAction> c;
        public final AtomicInteger d;
        public final ScheduledExecutorService e;

        /* renamed from: com.baidu.tieba.c1a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0220a implements tz9 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b4a a;
            public final /* synthetic */ a b;

            public C0220a(a aVar, b4a b4aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, b4aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = b4aVar;
            }

            @Override // com.baidu.tieba.tz9
            public void call() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.b.b(this.a);
                }
            }
        }

        /* loaded from: classes3.dex */
        public class b implements tz9 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b4a a;
            public final /* synthetic */ tz9 b;
            public final /* synthetic */ nz9 c;
            public final /* synthetic */ a d;

            public b(a aVar, b4a b4aVar, tz9 tz9Var, nz9 nz9Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, b4aVar, tz9Var, nz9Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.d = aVar;
                this.a = b4aVar;
                this.b = tz9Var;
                this.c = nz9Var;
            }

            @Override // com.baidu.tieba.tz9
            public void call() {
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.isUnsubscribed()) {
                    return;
                }
                nz9 b = this.d.b(this.b);
                this.a.a(b);
                if (b.getClass() == ScheduledAction.class) {
                    ((ScheduledAction) b).add(this.c);
                }
            }
        }

        public a(Executor executor) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {executor};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = executor;
            this.c = new ConcurrentLinkedQueue<>();
            this.d = new AtomicInteger();
            this.b = new a4a();
            this.e = d1a.a();
        }

        @Override // com.baidu.tieba.jz9.a
        public nz9 b(tz9 tz9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, tz9Var)) == null) {
                if (isUnsubscribed()) {
                    return d4a.c();
                }
                ScheduledAction scheduledAction = new ScheduledAction(n3a.q(tz9Var), this.b);
                this.b.a(scheduledAction);
                this.c.offer(scheduledAction);
                if (this.d.getAndIncrement() == 0) {
                    try {
                        this.a.execute(this);
                    } catch (RejectedExecutionException e) {
                        this.b.b(scheduledAction);
                        this.d.decrementAndGet();
                        n3a.j(e);
                        throw e;
                    }
                }
                return scheduledAction;
            }
            return (nz9) invokeL.objValue;
        }

        @Override // com.baidu.tieba.jz9.a
        public nz9 c(tz9 tz9Var, long j, TimeUnit timeUnit) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{tz9Var, Long.valueOf(j), timeUnit})) == null) {
                if (j <= 0) {
                    return b(tz9Var);
                }
                if (isUnsubscribed()) {
                    return d4a.c();
                }
                tz9 q = n3a.q(tz9Var);
                b4a b4aVar = new b4a();
                b4a b4aVar2 = new b4a();
                b4aVar2.a(b4aVar);
                this.b.a(b4aVar2);
                nz9 a = d4a.a(new C0220a(this, b4aVar2));
                ScheduledAction scheduledAction = new ScheduledAction(new b(this, b4aVar2, q, a));
                b4aVar.a(scheduledAction);
                try {
                    scheduledAction.add(this.e.schedule(scheduledAction, j, timeUnit));
                    return a;
                } catch (RejectedExecutionException e) {
                    n3a.j(e);
                    throw e;
                }
            }
            return (nz9) invokeCommon.objValue;
        }

        @Override // com.baidu.tieba.nz9
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.b.isUnsubscribed();
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.nz9
        public void unsubscribe() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.b.unsubscribe();
                this.c.clear();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                while (!this.b.isUnsubscribed()) {
                    ScheduledAction poll = this.c.poll();
                    if (poll == null) {
                        return;
                    }
                    if (!poll.isUnsubscribed()) {
                        if (!this.b.isUnsubscribed()) {
                            poll.run();
                        } else {
                            this.c.clear();
                            return;
                        }
                    }
                    if (this.d.decrementAndGet() == 0) {
                        return;
                    }
                }
                this.c.clear();
            }
        }
    }

    public c1a(Executor executor) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {executor};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = executor;
    }

    @Override // com.baidu.tieba.jz9
    public jz9.a createWorker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new a(this.a);
        }
        return (jz9.a) invokeV.objValue;
    }
}
