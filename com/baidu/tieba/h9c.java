package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.q7c;
import com.baidu.tieba.r7c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public final class h9c<T> implements r7c.c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final r7c.c<T> a;
    public final long b;
    public final TimeUnit c;
    public final q7c d;

    /* loaded from: classes6.dex */
    public static final class a<T> extends s7c<T> implements a8c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final s7c<? super T> b;
        public final q7c.a c;
        public final long d;
        public final TimeUnit e;
        public T f;
        public Throwable g;

        public a(s7c<? super T> s7cVar, q7c.a aVar, long j, TimeUnit timeUnit) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s7cVar, aVar, Long.valueOf(j), timeUnit};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = s7cVar;
            this.c = aVar;
            this.d = j;
            this.e = timeUnit;
        }

        @Override // com.baidu.tieba.s7c
        public void b(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                this.g = th;
                this.c.c(this, this.d, this.e);
            }
        }

        @Override // com.baidu.tieba.s7c
        public void c(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
                this.f = t;
                this.c.c(this, this.d, this.e);
            }
        }

        @Override // com.baidu.tieba.a8c
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                try {
                    Throwable th = this.g;
                    if (th != null) {
                        this.g = null;
                        this.b.b(th);
                    } else {
                        T t = this.f;
                        this.f = null;
                        this.b.c(t);
                    }
                } finally {
                    this.c.unsubscribe();
                }
            }
        }
    }

    public h9c(r7c.c<T> cVar, long j, TimeUnit timeUnit, q7c q7cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, Long.valueOf(j), timeUnit, q7cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = cVar;
        this.d = q7cVar;
        this.b = j;
        this.c = timeUnit;
    }

    public void call(s7c<? super T> s7cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, s7cVar) == null) {
            q7c.a createWorker = this.d.createWorker();
            a aVar = new a(s7cVar, createWorker, this.b, this.c);
            s7cVar.a(createWorker);
            s7cVar.a(aVar);
            this.a.call(aVar);
        }
    }

    @Override // com.baidu.tieba.r7c.c, com.baidu.tieba.b8c
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((s7c) ((s7c) obj));
    }
}
