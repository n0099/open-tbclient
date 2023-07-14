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
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes6.dex */
public class h3c<T> implements u1c.b<T, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final i2c<? super T> a;

    /* loaded from: classes6.dex */
    public class a implements w1c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AtomicLong a;

        public a(h3c h3cVar, AtomicLong atomicLong) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h3cVar, atomicLong};
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
        }

        @Override // com.baidu.tieba.w1c
        public void request(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                q2c.b(this.a, j);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends a2c<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean e;
        public final /* synthetic */ a2c f;
        public final /* synthetic */ AtomicLong g;
        public final /* synthetic */ h3c h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(h3c h3cVar, a2c a2cVar, a2c a2cVar2, AtomicLong atomicLong) {
            super(a2cVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h3cVar, a2cVar, a2cVar2, atomicLong};
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
            this.h = h3cVar;
            this.f = a2cVar2;
            this.g = atomicLong;
        }

        @Override // com.baidu.tieba.a2c
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                e(Long.MAX_VALUE);
            }
        }

        @Override // com.baidu.tieba.v1c
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && !this.e) {
                this.e = true;
                this.f.onCompleted();
            }
        }

        @Override // com.baidu.tieba.v1c
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                if (!this.e) {
                    this.e = true;
                    this.f.onError(th);
                    return;
                }
                h6c.j(th);
            }
        }

        @Override // com.baidu.tieba.v1c
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048579, this, t) != null) || this.e) {
                return;
            }
            if (this.g.get() > 0) {
                this.f.onNext(t);
                this.g.decrementAndGet();
                return;
            }
            i2c<? super T> i2cVar = this.h.a;
            if (i2cVar != null) {
                try {
                    i2cVar.call(t);
                } catch (Throwable th) {
                    g2c.g(th, this, t);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public static final h3c<Object> a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-794729806, "Lcom/baidu/tieba/h3c$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-794729806, "Lcom/baidu/tieba/h3c$c;");
                    return;
                }
            }
            a = new h3c<>();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public h3c() {
        this(null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((i2c) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static <T> h3c<T> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return (h3c<T>) c.a;
        }
        return (h3c) invokeV.objValue;
    }

    public h3c(i2c<? super T> i2cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {i2cVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = i2cVar;
    }

    public a2c<? super T> call(a2c<? super T> a2cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, a2cVar)) == null) {
            AtomicLong atomicLong = new AtomicLong();
            a2cVar.f(new a(this, atomicLong));
            return new b(this, a2cVar, a2cVar, atomicLong);
        }
        return (a2c) invokeL.objValue;
    }

    @Override // com.baidu.tieba.u1c.b, com.baidu.tieba.m2c
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((a2c) ((a2c) obj));
    }
}
