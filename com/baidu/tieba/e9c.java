package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.n7c;
import com.baidu.tieba.q7c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class e9c<T> implements n7c.a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final q7c a;
    public final n7c<T> b;

    /* loaded from: classes5.dex */
    public class a implements a8c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t7c a;
        public final /* synthetic */ q7c.a b;
        public final /* synthetic */ e9c c;

        /* renamed from: com.baidu.tieba.e9c$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0274a extends t7c<T> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Thread e;
            public final /* synthetic */ a f;

            /* renamed from: com.baidu.tieba.e9c$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public class C0275a implements p7c {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ p7c a;
                public final /* synthetic */ C0274a b;

                /* renamed from: com.baidu.tieba.e9c$a$a$a$a  reason: collision with other inner class name */
                /* loaded from: classes5.dex */
                public class C0276a implements a8c {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ long a;
                    public final /* synthetic */ C0275a b;

                    public C0276a(C0275a c0275a, long j) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {c0275a, Long.valueOf(j)};
                            interceptable.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.b = c0275a;
                        this.a = j;
                    }

                    @Override // com.baidu.tieba.a8c
                    public void call() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            this.b.a.request(this.a);
                        }
                    }
                }

                public C0275a(C0274a c0274a, p7c p7cVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0274a, p7cVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = c0274a;
                    this.a = p7cVar;
                }

                @Override // com.baidu.tieba.p7c
                public void request(long j) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                        if (this.b.e == Thread.currentThread()) {
                            this.a.request(j);
                        } else {
                            this.b.f.b.b(new C0276a(this, j));
                        }
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0274a(a aVar, t7c t7cVar, Thread thread) {
                super(t7cVar);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, t7cVar, thread};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((t7c) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f = aVar;
                this.e = thread;
            }

            @Override // com.baidu.tieba.t7c
            public void f(p7c p7cVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, p7cVar) == null) {
                    this.f.a.f(new C0275a(this, p7cVar));
                }
            }

            @Override // com.baidu.tieba.o7c
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                    try {
                        this.f.a.onError(th);
                    } finally {
                        this.f.b.unsubscribe();
                    }
                }
            }

            @Override // com.baidu.tieba.o7c
            public void onNext(T t) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, t) == null) {
                    this.f.a.onNext(t);
                }
            }

            @Override // com.baidu.tieba.o7c
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    try {
                        this.f.a.onCompleted();
                    } finally {
                        this.f.b.unsubscribe();
                    }
                }
            }
        }

        public a(e9c e9cVar, t7c t7cVar, q7c.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e9cVar, t7cVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = e9cVar;
            this.a = t7cVar;
            this.b = aVar;
        }

        @Override // com.baidu.tieba.a8c
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.b.O(new C0274a(this, this.a, Thread.currentThread()));
            }
        }
    }

    public e9c(n7c<T> n7cVar, q7c q7cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {n7cVar, q7cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = q7cVar;
        this.b = n7cVar;
    }

    public void call(t7c<? super T> t7cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, t7cVar) == null) {
            q7c.a createWorker = this.a.createWorker();
            t7cVar.b(createWorker);
            createWorker.b(new a(this, t7cVar, createWorker));
        }
    }

    @Override // com.baidu.tieba.n7c.a, com.baidu.tieba.b8c
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((t7c) ((t7c) obj));
    }
}
