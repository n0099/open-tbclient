package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.sac;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes6.dex */
public class gcc<T> implements sac.b<T, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final gbc<? super T> a;

    /* loaded from: classes6.dex */
    public class a implements uac {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AtomicLong a;

        public a(gcc gccVar, AtomicLong atomicLong) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gccVar, atomicLong};
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

        @Override // com.baidu.tieba.uac
        public void request(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                pbc.b(this.a, j);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends yac<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean e;
        public final /* synthetic */ yac f;
        public final /* synthetic */ AtomicLong g;
        public final /* synthetic */ gcc h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(gcc gccVar, yac yacVar, yac yacVar2, AtomicLong atomicLong) {
            super(yacVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gccVar, yacVar, yacVar2, atomicLong};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((yac) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = gccVar;
            this.f = yacVar2;
            this.g = atomicLong;
        }

        @Override // com.baidu.tieba.yac
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                e(Long.MAX_VALUE);
            }
        }

        @Override // com.baidu.tieba.tac
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && !this.e) {
                this.e = true;
                this.f.onCompleted();
            }
        }

        @Override // com.baidu.tieba.tac
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                if (!this.e) {
                    this.e = true;
                    this.f.onError(th);
                    return;
                }
                gfc.j(th);
            }
        }

        @Override // com.baidu.tieba.tac
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
            gbc<? super T> gbcVar = this.h.a;
            if (gbcVar != null) {
                try {
                    gbcVar.call(t);
                } catch (Throwable th) {
                    ebc.g(th, this, t);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public static final gcc<Object> a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-779029949, "Lcom/baidu/tieba/gcc$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-779029949, "Lcom/baidu/tieba/gcc$c;");
                    return;
                }
            }
            a = new gcc<>();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public gcc() {
        this(null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((gbc) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static <T> gcc<T> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return (gcc<T>) c.a;
        }
        return (gcc) invokeV.objValue;
    }

    public gcc(gbc<? super T> gbcVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gbcVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = gbcVar;
    }

    public yac<? super T> call(yac<? super T> yacVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, yacVar)) == null) {
            AtomicLong atomicLong = new AtomicLong();
            yacVar.f(new a(this, atomicLong));
            return new b(this, yacVar, yacVar, atomicLong);
        }
        return (yac) invokeL.objValue;
    }

    @Override // com.baidu.tieba.sac.b, com.baidu.tieba.lbc
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((yac) ((yac) obj));
    }
}
