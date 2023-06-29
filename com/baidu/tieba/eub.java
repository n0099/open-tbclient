package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.atb;
import com.baidu.tieba.xsb;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public final class eub<T> implements xsb.b<T, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final long a;
    public final TimeUnit b;
    public final atb c;

    /* loaded from: classes5.dex */
    public class a extends dtb<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean e;
        public final /* synthetic */ atb.a f;
        public final /* synthetic */ dtb g;
        public final /* synthetic */ eub h;

        /* renamed from: com.baidu.tieba.eub$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0288a implements ktb {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0288a(a aVar) {
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

            @Override // com.baidu.tieba.ktb
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
        public class b implements ktb {
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

            @Override // com.baidu.tieba.ktb
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
        public class c implements ktb {
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

            /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: com.baidu.tieba.dtb */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.ktb
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
        public a(eub eubVar, dtb dtbVar, atb.a aVar, dtb dtbVar2) {
            super(dtbVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eubVar, dtbVar, aVar, dtbVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((dtb) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = eubVar;
            this.f = aVar;
            this.g = dtbVar2;
        }

        @Override // com.baidu.tieba.ysb
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                atb.a aVar = this.f;
                C0288a c0288a = new C0288a(this);
                eub eubVar = this.h;
                aVar.c(c0288a, eubVar.a, eubVar.b);
            }
        }

        @Override // com.baidu.tieba.ysb
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                this.f.b(new b(this, th));
            }
        }

        @Override // com.baidu.tieba.ysb
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) {
                atb.a aVar = this.f;
                c cVar = new c(this, t);
                eub eubVar = this.h;
                aVar.c(cVar, eubVar.a, eubVar.b);
            }
        }
    }

    public eub(long j, TimeUnit timeUnit, atb atbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), timeUnit, atbVar};
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
        this.c = atbVar;
    }

    public dtb<? super T> call(dtb<? super T> dtbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dtbVar)) == null) {
            atb.a createWorker = this.c.createWorker();
            dtbVar.b(createWorker);
            return new a(this, dtbVar, createWorker, dtbVar);
        }
        return (dtb) invokeL.objValue;
    }

    @Override // com.baidu.tieba.xsb.b, com.baidu.tieba.ptb
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((dtb) ((dtb) obj));
    }
}
