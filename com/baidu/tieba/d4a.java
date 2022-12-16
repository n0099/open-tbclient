package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.b3a;
import com.baidu.tieba.e3a;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.Notification;
import rx.schedulers.Schedulers;
/* loaded from: classes4.dex */
public final class d4a<T> implements b3a.a<T> {
    public static /* synthetic */ Interceptable $ic;
    public static final t3a<b3a<? extends Notification<?>>, b3a<?>> f;
    public transient /* synthetic */ FieldHolder $fh;
    public final b3a<T> a;
    public final t3a<? super b3a<? extends Notification<?>>, ? extends b3a<?>> b;
    public final boolean c;
    public final boolean d;
    public final e3a e;

    /* loaded from: classes4.dex */
    public static class a implements t3a<b3a<? extends Notification<?>>, b3a<?>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.baidu.tieba.d4a$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0247a implements t3a<Notification<?>, Notification<?>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0247a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.t3a
            public Notification<?> call(Notification<?> notification) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, notification)) == null) {
                    return Notification.c(null);
                }
                return (Notification) invokeL.objValue;
            }
        }

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

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Type inference failed for r5v1. Raw type applied. Possible types: com.baidu.tieba.b3a<R>, com.baidu.tieba.b3a<?> */
        @Override // com.baidu.tieba.t3a
        public b3a<?> call(b3a<? extends Notification<?>> b3aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, b3aVar)) == null) {
                return b3aVar.h(new C0247a(this));
            }
            return (b3a) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements o3a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h3a a;
        public final /* synthetic */ t7a b;
        public final /* synthetic */ u4a c;
        public final /* synthetic */ AtomicLong d;
        public final /* synthetic */ x7a e;
        public final /* synthetic */ d4a f;

        /* loaded from: classes4.dex */
        public class a extends h3a<T> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public boolean e;
            public final /* synthetic */ b f;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f = bVar;
            }

            @Override // com.baidu.tieba.h3a
            public void f(d3a d3aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, d3aVar) == null) {
                    this.f.c.c(d3aVar);
                }
            }

            @Override // com.baidu.tieba.c3a
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048579, this, th) == null) && !this.e) {
                    this.e = true;
                    unsubscribe();
                    this.f.b.onNext(Notification.b(th));
                }
            }

            @Override // com.baidu.tieba.c3a
            public void onNext(T t) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048580, this, t) == null) && !this.e) {
                    this.f.a.onNext(t);
                    g();
                    this.f.c.b(1L);
                }
            }

            public final void g() {
                long j;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    do {
                        j = this.f.d.get();
                        if (j == Long.MAX_VALUE) {
                            return;
                        }
                    } while (!this.f.d.compareAndSet(j, j - 1));
                }
            }

            @Override // com.baidu.tieba.c3a
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && !this.e) {
                    this.e = true;
                    unsubscribe();
                    this.f.b.onNext(Notification.a());
                }
            }
        }

        public b(d4a d4aVar, h3a h3aVar, t7a t7aVar, u4a u4aVar, AtomicLong atomicLong, x7a x7aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d4aVar, h3aVar, t7aVar, u4aVar, atomicLong, x7aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = d4aVar;
            this.a = h3aVar;
            this.b = t7aVar;
            this.c = u4aVar;
            this.d = atomicLong;
            this.e = x7aVar;
        }

        @Override // com.baidu.tieba.o3a
        public void call() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.isUnsubscribed()) {
                return;
            }
            a aVar = new a(this);
            this.e.a(aVar);
            this.f.a.B(aVar);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements b3a.b<Notification<?>, Notification<?>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d4a a;

        /* loaded from: classes4.dex */
        public class a extends h3a<Notification<?>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ h3a e;
            public final /* synthetic */ c f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(c cVar, h3a h3aVar, h3a h3aVar2) {
                super(h3aVar);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, h3aVar, h3aVar2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((h3a) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f = cVar;
                this.e = h3aVar2;
            }

            @Override // com.baidu.tieba.h3a
            public void f(d3a d3aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, d3aVar) == null) {
                    d3aVar.request(Long.MAX_VALUE);
                }
            }

            @Override // com.baidu.tieba.c3a
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, th) == null) {
                    this.e.onError(th);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.c3a
            /* renamed from: g */
            public void onNext(Notification<?> notification) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, notification) == null) {
                    if (notification.i() && this.f.a.c) {
                        this.e.onCompleted();
                    } else if (notification.j() && this.f.a.d) {
                        this.e.onError(notification.e());
                    } else {
                        this.e.onNext(notification);
                    }
                }
            }

            @Override // com.baidu.tieba.c3a
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.e.onCompleted();
                }
            }
        }

        public c(d4a d4aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d4aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d4aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b3a.b, com.baidu.tieba.t3a
        public h3a<? super Notification<?>> call(h3a<? super Notification<?>> h3aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, h3aVar)) == null) {
                return new a(this, h3aVar, h3aVar);
            }
            return (h3a) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements o3a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b3a a;
        public final /* synthetic */ h3a b;
        public final /* synthetic */ AtomicLong c;
        public final /* synthetic */ e3a.a d;
        public final /* synthetic */ o3a e;
        public final /* synthetic */ AtomicBoolean f;

        /* loaded from: classes4.dex */
        public class a extends h3a<Object> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(d dVar, h3a h3aVar) {
                super(h3aVar);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, h3aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((h3a) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.e = dVar;
            }

            @Override // com.baidu.tieba.h3a
            public void f(d3a d3aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, d3aVar) == null) {
                    d3aVar.request(Long.MAX_VALUE);
                }
            }

            @Override // com.baidu.tieba.c3a
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                    this.e.b.onError(th);
                }
            }

            @Override // com.baidu.tieba.c3a
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.e.b.onCompleted();
                }
            }

            @Override // com.baidu.tieba.c3a
            public void onNext(Object obj) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048579, this, obj) == null) && !this.e.b.isUnsubscribed()) {
                    if (this.e.c.get() > 0) {
                        d dVar = this.e;
                        dVar.d.b(dVar.e);
                        return;
                    }
                    this.e.f.compareAndSet(false, true);
                }
            }
        }

        public d(d4a d4aVar, b3a b3aVar, h3a h3aVar, AtomicLong atomicLong, e3a.a aVar, o3a o3aVar, AtomicBoolean atomicBoolean) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d4aVar, b3aVar, h3aVar, atomicLong, aVar, o3aVar, atomicBoolean};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b3aVar;
            this.b = h3aVar;
            this.c = atomicLong;
            this.d = aVar;
            this.e = o3aVar;
            this.f = atomicBoolean;
        }

        @Override // com.baidu.tieba.o3a
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.B(new a(this, this.b));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements d3a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AtomicLong a;
        public final /* synthetic */ u4a b;
        public final /* synthetic */ AtomicBoolean c;
        public final /* synthetic */ e3a.a d;
        public final /* synthetic */ o3a e;

        public e(d4a d4aVar, AtomicLong atomicLong, u4a u4aVar, AtomicBoolean atomicBoolean, e3a.a aVar, o3a o3aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d4aVar, atomicLong, u4aVar, atomicBoolean, aVar, o3aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = atomicLong;
            this.b = u4aVar;
            this.c = atomicBoolean;
            this.d = aVar;
            this.e = o3aVar;
        }

        @Override // com.baidu.tieba.d3a
        public void request(long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(1048576, this, j) == null) && j > 0) {
                w3a.b(this.a, j);
                this.b.request(j);
                if (this.c.compareAndSet(true, false)) {
                    this.d.b(this.e);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947655960, "Lcom/baidu/tieba/d4a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947655960, "Lcom/baidu/tieba/d4a;");
                return;
            }
        }
        f = new a();
    }

    public d4a(b3a<T> b3aVar, t3a<? super b3a<? extends Notification<?>>, ? extends b3a<?>> t3aVar, boolean z, boolean z2, e3a e3aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {b3aVar, t3aVar, Boolean.valueOf(z), Boolean.valueOf(z2), e3aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = b3aVar;
        this.b = t3aVar;
        this.c = z;
        this.d = z2;
        this.e = e3aVar;
    }

    public static <T> b3a<T> a(b3a<T> b3aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, b3aVar)) == null) {
            return b(b3aVar, f);
        }
        return (b3a) invokeL.objValue;
    }

    @Override // com.baidu.tieba.b3a.a, com.baidu.tieba.p3a
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((h3a) ((h3a) obj));
    }

    public static <T> b3a<T> b(b3a<T> b3aVar, t3a<? super b3a<? extends Notification<?>>, ? extends b3a<?>> t3aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, b3aVar, t3aVar)) == null) {
            return b3a.a(new d4a(b3aVar, t3aVar, true, false, Schedulers.trampoline()));
        }
        return (b3a) invokeLL.objValue;
    }

    public void call(h3a<? super T> h3aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, h3aVar) == null) {
            AtomicBoolean atomicBoolean = new AtomicBoolean(true);
            AtomicLong atomicLong = new AtomicLong();
            e3a.a createWorker = this.e.createWorker();
            h3aVar.b(createWorker);
            x7a x7aVar = new x7a();
            h3aVar.b(x7aVar);
            s7a<T, T> C = q7a.D().C();
            C.u(f7a.a());
            u4a u4aVar = new u4a();
            b bVar = new b(this, h3aVar, C, u4aVar, atomicLong, x7aVar);
            createWorker.b(new d(this, this.b.call(C.g(new c(this))), h3aVar, atomicLong, createWorker, bVar, atomicBoolean));
            h3aVar.f(new e(this, atomicLong, u4aVar, atomicBoolean, createWorker, bVar));
        }
    }
}
