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
/* loaded from: classes6.dex */
public class hoc<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c<T> a;

    /* loaded from: classes6.dex */
    public interface c<T> extends roc<ioc<? super T>> {
    }

    /* loaded from: classes6.dex */
    public class a extends ioc<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ roc b;
        public final /* synthetic */ roc c;

        public a(hoc hocVar, roc rocVar, roc rocVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hocVar, rocVar, rocVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rocVar;
            this.c = rocVar2;
        }

        @Override // com.baidu.tieba.ioc
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

        @Override // com.baidu.tieba.ioc
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

    /* loaded from: classes6.dex */
    public class b implements roc<Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ roc a;

        public b(hoc hocVar, roc rocVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hocVar, rocVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rocVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.roc
        /* renamed from: a */
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                this.a.call(th);
            }
        }
    }

    public hoc(c<T> cVar) {
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
        this.a = tsc.i(cVar);
    }

    public final hoc<T> h(goc gocVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, gocVar)) == null) {
            if (this instanceof wqc) {
                return ((wqc) this).n(gocVar);
            }
            if (gocVar != null) {
                return b(new dqc(this.a, gocVar));
            }
            throw new NullPointerException("scheduler is null");
        }
        return (hoc) invokeL.objValue;
    }

    public static <T> doc<T> a(hoc<T> hocVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, hocVar)) == null) {
            return doc.d(new eqc(hocVar.a));
        }
        return (doc) invokeL.objValue;
    }

    public static <T> hoc<T> b(c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, cVar)) == null) {
            return new hoc<>(cVar);
        }
        return (hoc) invokeL.objValue;
    }

    public static <T> hoc<T> g(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, t)) == null) {
            return wqc.m(t);
        }
        return (hoc) invokeL.objValue;
    }

    public final hoc<T> e(roc<Throwable> rocVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, rocVar)) == null) {
            if (rocVar != null) {
                return b(new aqc(this, Actions.a(), new b(this, rocVar)));
            }
            throw new IllegalArgumentException("onError is null");
        }
        return (hoc) invokeL.objValue;
    }

    public final hoc<T> f(roc<? super T> rocVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, rocVar)) == null) {
            if (rocVar != null) {
                return b(new aqc(this, rocVar, Actions.a()));
            }
            throw new IllegalArgumentException("onSuccess is null");
        }
        return (hoc) invokeL.objValue;
    }

    public final hoc<T> c(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, timeUnit)) == null) {
            return d(j, timeUnit, Schedulers.computation());
        }
        return (hoc) invokeJL.objValue;
    }

    public final koc k(roc<? super T> rocVar, roc<Throwable> rocVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, rocVar, rocVar2)) == null) {
            if (rocVar != null) {
                if (rocVar2 != null) {
                    return j(new a(this, rocVar2, rocVar));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onSuccess can not be null");
        }
        return (koc) invokeLL.objValue;
    }

    public final hoc<T> d(long j, TimeUnit timeUnit, goc gocVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), timeUnit, gocVar})) == null) {
            return b(new zpc(this.a, j, timeUnit, gocVar));
        }
        return (hoc) invokeCommon.objValue;
    }

    public final koc i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return k(Actions.a(), Actions.b());
        }
        return (koc) invokeV.objValue;
    }

    public final doc<T> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return a(this);
        }
        return (doc) invokeV.objValue;
    }

    public final koc j(ioc<? super T> iocVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, iocVar)) == null) {
            if (iocVar != null) {
                try {
                    tsc.t(this, this.a).call(iocVar);
                    return tsc.s(iocVar);
                } catch (Throwable th) {
                    poc.e(th);
                    try {
                        iocVar.b(tsc.r(th));
                        return jtc.b();
                    } catch (Throwable th2) {
                        poc.e(th2);
                        RuntimeException runtimeException = new RuntimeException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                        tsc.r(runtimeException);
                        throw runtimeException;
                    }
                }
            }
            throw new IllegalArgumentException("te is null");
        }
        return (koc) invokeL.objValue;
    }
}
