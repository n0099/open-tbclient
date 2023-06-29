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
/* loaded from: classes5.dex */
public class btb<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c<T> a;

    /* loaded from: classes5.dex */
    public interface c<T> extends ltb<ctb<? super T>> {
        @Override // com.baidu.tieba.ltb
        /* synthetic */ void call(T t);
    }

    /* loaded from: classes5.dex */
    public class a extends ctb<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ltb b;
        public final /* synthetic */ ltb c;

        public a(btb btbVar, ltb ltbVar, ltb ltbVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {btbVar, ltbVar, ltbVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ltbVar;
            this.c = ltbVar2;
        }

        @Override // com.baidu.tieba.ctb
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

        @Override // com.baidu.tieba.ctb
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

    /* loaded from: classes5.dex */
    public class b implements ltb<Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ltb a;

        public b(btb btbVar, ltb ltbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {btbVar, ltbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ltbVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ltb
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                this.a.call(th);
            }
        }
    }

    public btb(c<T> cVar) {
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
        this.a = kxb.i(cVar);
    }

    public final btb<T> h(atb atbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, atbVar)) == null) {
            if (this instanceof nvb) {
                return ((nvb) this).n(atbVar);
            }
            if (atbVar != null) {
                return b(new uub(this.a, atbVar));
            }
            throw new NullPointerException("scheduler is null");
        }
        return (btb) invokeL.objValue;
    }

    public static <T> xsb<T> a(btb<T> btbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, btbVar)) == null) {
            return xsb.d(new vub(btbVar.a));
        }
        return (xsb) invokeL.objValue;
    }

    public static <T> btb<T> b(c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, cVar)) == null) {
            return new btb<>(cVar);
        }
        return (btb) invokeL.objValue;
    }

    public static <T> btb<T> g(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, t)) == null) {
            return nvb.m(t);
        }
        return (btb) invokeL.objValue;
    }

    public final btb<T> e(ltb<Throwable> ltbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ltbVar)) == null) {
            if (ltbVar != null) {
                return b(new rub(this, Actions.a(), new b(this, ltbVar)));
            }
            throw new IllegalArgumentException("onError is null");
        }
        return (btb) invokeL.objValue;
    }

    public final btb<T> f(ltb<? super T> ltbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, ltbVar)) == null) {
            if (ltbVar != null) {
                return b(new rub(this, ltbVar, Actions.a()));
            }
            throw new IllegalArgumentException("onSuccess is null");
        }
        return (btb) invokeL.objValue;
    }

    public final btb<T> c(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, timeUnit)) == null) {
            return d(j, timeUnit, Schedulers.computation());
        }
        return (btb) invokeJL.objValue;
    }

    public final etb k(ltb<? super T> ltbVar, ltb<Throwable> ltbVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, ltbVar, ltbVar2)) == null) {
            if (ltbVar != null) {
                if (ltbVar2 != null) {
                    return j(new a(this, ltbVar2, ltbVar));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onSuccess can not be null");
        }
        return (etb) invokeLL.objValue;
    }

    public final btb<T> d(long j, TimeUnit timeUnit, atb atbVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), timeUnit, atbVar})) == null) {
            return b(new qub(this.a, j, timeUnit, atbVar));
        }
        return (btb) invokeCommon.objValue;
    }

    public final etb i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return k(Actions.a(), Actions.b());
        }
        return (etb) invokeV.objValue;
    }

    public final xsb<T> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return a(this);
        }
        return (xsb) invokeV.objValue;
    }

    public final etb j(ctb<? super T> ctbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, ctbVar)) == null) {
            if (ctbVar != null) {
                try {
                    kxb.t(this, this.a).call(ctbVar);
                    return kxb.s(ctbVar);
                } catch (Throwable th) {
                    jtb.e(th);
                    try {
                        ctbVar.b(kxb.r(th));
                        return ayb.b();
                    } catch (Throwable th2) {
                        jtb.e(th2);
                        RuntimeException runtimeException = new RuntimeException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                        kxb.r(runtimeException);
                        throw runtimeException;
                    }
                }
            }
            throw new IllegalArgumentException("te is null");
        }
        return (etb) invokeL.objValue;
    }
}
