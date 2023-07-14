package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.u1c;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import rx.internal.util.UtilityFunctions;
/* loaded from: classes5.dex */
public final class c3c<T, U> implements u1c.b<T, T>, n2c<U, U, Boolean> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final m2c<? super T, ? extends U> a;
    public final n2c<? super U, ? super U, Boolean> b;

    /* loaded from: classes5.dex */
    public class a extends a2c<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public U e;
        public boolean f;
        public final /* synthetic */ a2c g;
        public final /* synthetic */ c3c h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c3c c3cVar, a2c a2cVar, a2c a2cVar2) {
            super(a2cVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c3cVar, a2cVar, a2cVar2};
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
            this.h = c3cVar;
            this.g = a2cVar2;
        }

        @Override // com.baidu.tieba.v1c
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.g.onCompleted();
            }
        }

        @Override // com.baidu.tieba.v1c
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                this.g.onError(th);
            }
        }

        @Override // com.baidu.tieba.v1c
        public void onNext(T t) {
            Object obj;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) {
                try {
                    U call = this.h.a.call(t);
                    U u = this.e;
                    this.e = call;
                    if (this.f) {
                        try {
                            if (!this.h.b.call(u, call).booleanValue()) {
                                this.g.onNext(t);
                                return;
                            } else {
                                e(1L);
                                return;
                            }
                        } catch (Throwable th) {
                            g2c.g(th, this.g, obj);
                            return;
                        }
                    }
                    this.f = true;
                    this.g.onNext(t);
                } catch (Throwable th2) {
                    g2c.g(th2, this.g, t);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public static final c3c<?, ?> a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-937875592, "Lcom/baidu/tieba/c3c$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-937875592, "Lcom/baidu/tieba/c3c$b;");
                    return;
                }
            }
            a = new c3c<>(UtilityFunctions.b());
        }
    }

    public c3c(m2c<? super T, ? extends U> m2cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {m2cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = m2cVar;
        this.b = this;
    }

    public a2c<? super T> call(a2c<? super T> a2cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, a2cVar)) == null) {
            return new a(this, a2cVar, a2cVar);
        }
        return (a2c) invokeL.objValue;
    }

    public c3c(n2c<? super U, ? super U, Boolean> n2cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {n2cVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = UtilityFunctions.b();
        this.b = n2cVar;
    }

    public static <T> c3c<T, T> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return (c3c<T, T>) b.a;
        }
        return (c3c) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.n2c
    public Boolean call(U u, U u2) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, u, u2)) == null) {
            if (u != u2 && (u == null || !u.equals(u2))) {
                z = false;
            } else {
                z = true;
            }
            return Boolean.valueOf(z);
        }
        return (Boolean) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.u1c.b, com.baidu.tieba.m2c
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((a2c) ((a2c) obj));
    }
}
