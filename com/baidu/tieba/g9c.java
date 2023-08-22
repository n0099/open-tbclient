package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.n7c;
import com.baidu.tieba.q7c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.TimeoutException;
/* loaded from: classes6.dex */
public class g9c<T> implements n7c.b<T, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a<T> a;
    public final b<T> b;
    public final n7c<? extends T> c;
    public final q7c d;

    /* loaded from: classes6.dex */
    public interface a<T> {
        /* synthetic */ R call(T1 t1, T2 t2, T3 t3);
    }

    /* loaded from: classes6.dex */
    public interface b<T> {
        /* synthetic */ R call(T1 t1, T2 t2, T3 t3, T4 t4);
    }

    /* loaded from: classes6.dex */
    public static final class c<T> extends t7c<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final qcc e;
        public final xbc<T> f;
        public final b<T> g;
        public final n7c<? extends T> h;
        public final q7c.a i;
        public final n9c j;
        public boolean k;
        public long l;

        /* loaded from: classes6.dex */
        public class a extends t7c<T> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c e;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.e = cVar;
            }

            @Override // com.baidu.tieba.t7c
            public void f(p7c p7cVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, p7cVar) == null) {
                    this.e.j.c(p7cVar);
                }
            }

            @Override // com.baidu.tieba.o7c
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                    this.e.f.onError(th);
                }
            }

            @Override // com.baidu.tieba.o7c
            public void onNext(T t) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, t) == null) {
                    this.e.f.onNext(t);
                }
            }

            @Override // com.baidu.tieba.o7c
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.e.f.onCompleted();
                }
            }
        }

        public c(xbc<T> xbcVar, b<T> bVar, qcc qccVar, n7c<? extends T> n7cVar, q7c.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xbcVar, bVar, qccVar, n7cVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = xbcVar;
            this.g = bVar;
            this.e = qccVar;
            this.h = n7cVar;
            this.i = aVar;
            this.j = new n9c();
        }

        @Override // com.baidu.tieba.t7c
        public void f(p7c p7cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, p7cVar) == null) {
                this.j.c(p7cVar);
            }
        }

        @Override // com.baidu.tieba.o7c
        public void onError(Throwable th) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, th) == null) {
                synchronized (this) {
                    z = true;
                    if (!this.k) {
                        this.k = true;
                    } else {
                        z = false;
                    }
                }
                if (z) {
                    this.e.unsubscribe();
                    this.f.onError(th);
                }
            }
        }

        public void g(long j) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                synchronized (this) {
                    z = true;
                    if (j == this.l && !this.k) {
                        this.k = true;
                    } else {
                        z = false;
                    }
                }
                if (z) {
                    if (this.h == null) {
                        this.f.onError(new TimeoutException());
                        return;
                    }
                    a aVar = new a(this);
                    this.h.O(aVar);
                    this.e.a(aVar);
                }
            }
        }

        @Override // com.baidu.tieba.o7c
        public void onNext(T t) {
            long j;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, t) == null) {
                synchronized (this) {
                    if (!this.k) {
                        j = this.l + 1;
                        this.l = j;
                        z = true;
                    } else {
                        j = this.l;
                        z = false;
                    }
                }
                if (z) {
                    this.f.onNext(t);
                    this.e.a((u7c) this.g.call(this, Long.valueOf(j), t, this.i));
                }
            }
        }

        @Override // com.baidu.tieba.o7c
        public void onCompleted() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                synchronized (this) {
                    z = true;
                    if (!this.k) {
                        this.k = true;
                    } else {
                        z = false;
                    }
                }
                if (z) {
                    this.e.unsubscribe();
                    this.f.onCompleted();
                }
            }
        }
    }

    public g9c(a<T> aVar, b<T> bVar, n7c<? extends T> n7cVar, q7c q7cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, bVar, n7cVar, q7cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = aVar;
        this.b = bVar;
        this.c = n7cVar;
        this.d = q7cVar;
    }

    public t7c<? super T> call(t7c<? super T> t7cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, t7cVar)) == null) {
            q7c.a createWorker = this.d.createWorker();
            t7cVar.b(createWorker);
            xbc xbcVar = new xbc(t7cVar);
            qcc qccVar = new qcc();
            xbcVar.b(qccVar);
            c cVar = new c(xbcVar, this.b, qccVar, this.c, createWorker);
            xbcVar.b(cVar);
            xbcVar.f(cVar.j);
            qccVar.a((u7c) this.a.call(cVar, 0L, createWorker));
            return cVar;
        }
        return (t7c) invokeL.objValue;
    }

    @Override // com.baidu.tieba.n7c.b, com.baidu.tieba.g8c
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((t7c) ((t7c) obj));
    }
}
