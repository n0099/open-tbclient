package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.u1c;
import com.baidu.tieba.x1c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public final class b3c<T> implements u1c.b<T, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final long a;
    public final TimeUnit b;
    public final x1c c;

    /* loaded from: classes5.dex */
    public class a extends a2c<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean e;
        public final /* synthetic */ x1c.a f;
        public final /* synthetic */ a2c g;
        public final /* synthetic */ b3c h;

        /* renamed from: com.baidu.tieba.b3c$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0241a implements h2c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0241a(a aVar) {
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
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // com.baidu.tieba.h2c
            public void call() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    a aVar = this.a;
                    if (!aVar.e) {
                        aVar.e = true;
                        aVar.g.onCompleted();
                    }
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements h2c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Throwable a;
            public final /* synthetic */ a b;

            public b(a aVar, Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, th};
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
                this.a = th;
            }

            @Override // com.baidu.tieba.h2c
            public void call() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    a aVar = this.b;
                    if (!aVar.e) {
                        aVar.e = true;
                        aVar.g.onError(this.a);
                        this.b.f.unsubscribe();
                    }
                }
            }
        }

        /* loaded from: classes5.dex */
        public class c implements h2c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Object a;
            public final /* synthetic */ a b;

            public c(a aVar, Object obj) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, obj};
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
                this.a = obj;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: com.baidu.tieba.a2c */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.h2c
            public void call() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    a aVar = this.b;
                    if (!aVar.e) {
                        aVar.g.onNext(this.a);
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b3c b3cVar, a2c a2cVar, x1c.a aVar, a2c a2cVar2) {
            super(a2cVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b3cVar, a2cVar, aVar, a2cVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((a2c) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = b3cVar;
            this.f = aVar;
            this.g = a2cVar2;
        }

        @Override // com.baidu.tieba.v1c
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                x1c.a aVar = this.f;
                C0241a c0241a = new C0241a(this);
                b3c b3cVar = this.h;
                aVar.c(c0241a, b3cVar.a, b3cVar.b);
            }
        }

        @Override // com.baidu.tieba.v1c
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                this.f.b(new b(this, th));
            }
        }

        @Override // com.baidu.tieba.v1c
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) {
                x1c.a aVar = this.f;
                c cVar = new c(this, t);
                b3c b3cVar = this.h;
                aVar.c(cVar, b3cVar.a, b3cVar.b);
            }
        }
    }

    public b3c(long j, TimeUnit timeUnit, x1c x1cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), timeUnit, x1cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = j;
        this.b = timeUnit;
        this.c = x1cVar;
    }

    public a2c<? super T> call(a2c<? super T> a2cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, a2cVar)) == null) {
            x1c.a createWorker = this.c.createWorker();
            a2cVar.b(createWorker);
            return new a(this, a2cVar, createWorker, a2cVar);
        }
        return (a2c) invokeL.objValue;
    }

    @Override // com.baidu.tieba.u1c.b, com.baidu.tieba.m2c
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((a2c) ((a2c) obj));
    }
}
