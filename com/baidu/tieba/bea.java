package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.TimeUnit;
import rx.functions.Actions;
import rx.schedulers.Schedulers;
/* loaded from: classes3.dex */
public class bea<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c<T> a;

    /* loaded from: classes3.dex */
    public interface c<T> extends lea<cea<? super T>> {
        @Override // com.baidu.tieba.lea
        /* synthetic */ void call(T t);
    }

    /* loaded from: classes3.dex */
    public class a extends cea<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lea b;
        public final /* synthetic */ lea c;

        public a(bea beaVar, lea leaVar, lea leaVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {beaVar, leaVar, leaVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = leaVar;
            this.c = leaVar2;
        }

        @Override // com.baidu.tieba.cea
        public final void b(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                try {
                    this.b.call(th);
                } finally {
                    unsubscribe();
                }
            }
        }

        @Override // com.baidu.tieba.cea
        public final void c(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
                try {
                    this.c.call(t);
                } finally {
                    unsubscribe();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements lea<Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lea a;

        public b(bea beaVar, lea leaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {beaVar, leaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = leaVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lea
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                this.a.call(th);
            }
        }
    }

    public bea(c<T> cVar) {
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
        this.a = eia.i(cVar);
    }

    public final bea<T> h(aea aeaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, aeaVar)) == null) {
            if (this instanceof hga) {
                return ((hga) this).n(aeaVar);
            }
            if (aeaVar != null) {
                return b(new ofa(this.a, aeaVar));
            }
            throw new NullPointerException("scheduler is null");
        }
        return (bea) invokeL.objValue;
    }

    public static <T> xda<T> a(bea<T> beaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, beaVar)) == null) {
            return xda.a(new pfa(beaVar.a));
        }
        return (xda) invokeL.objValue;
    }

    public static <T> bea<T> b(c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, cVar)) == null) {
            return new bea<>(cVar);
        }
        return (bea) invokeL.objValue;
    }

    public static <T> bea<T> g(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, t)) == null) {
            return hga.m(t);
        }
        return (bea) invokeL.objValue;
    }

    public final bea<T> e(lea<Throwable> leaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, leaVar)) == null) {
            if (leaVar != null) {
                return b(new lfa(this, Actions.a(), new b(this, leaVar)));
            }
            throw new IllegalArgumentException("onError is null");
        }
        return (bea) invokeL.objValue;
    }

    public final bea<T> f(lea<? super T> leaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, leaVar)) == null) {
            if (leaVar != null) {
                return b(new lfa(this, leaVar, Actions.a()));
            }
            throw new IllegalArgumentException("onSuccess is null");
        }
        return (bea) invokeL.objValue;
    }

    public final bea<T> c(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, timeUnit)) == null) {
            return d(j, timeUnit, Schedulers.computation());
        }
        return (bea) invokeJL.objValue;
    }

    public final eea k(lea<? super T> leaVar, lea<Throwable> leaVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, leaVar, leaVar2)) == null) {
            if (leaVar != null) {
                if (leaVar2 != null) {
                    return j(new a(this, leaVar2, leaVar));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onSuccess can not be null");
        }
        return (eea) invokeLL.objValue;
    }

    public final bea<T> d(long j, TimeUnit timeUnit, aea aeaVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), timeUnit, aeaVar})) == null) {
            return b(new kfa(this.a, j, timeUnit, aeaVar));
        }
        return (bea) invokeCommon.objValue;
    }

    public final eea i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return k(Actions.a(), Actions.b());
        }
        return (eea) invokeV.objValue;
    }

    public final xda<T> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return a(this);
        }
        return (xda) invokeV.objValue;
    }

    public final eea j(cea<? super T> ceaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, ceaVar)) == null) {
            if (ceaVar != null) {
                try {
                    eia.t(this, this.a).call(ceaVar);
                    return eia.s(ceaVar);
                } catch (Throwable th) {
                    jea.e(th);
                    try {
                        ceaVar.b(eia.r(th));
                        return uia.b();
                    } catch (Throwable th2) {
                        jea.e(th2);
                        RuntimeException runtimeException = new RuntimeException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                        eia.r(runtimeException);
                        throw runtimeException;
                    }
                }
            }
            throw new IllegalArgumentException("te is null");
        }
        return (eea) invokeL.objValue;
    }
}
