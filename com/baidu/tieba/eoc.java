package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.exceptions.OnErrorFailedException;
import rx.functions.Actions;
import rx.internal.operators.EmptyObservableHolder;
import rx.internal.operators.OnSubscribeCombineLatest;
import rx.internal.operators.OnSubscribeFromIterable;
import rx.internal.operators.OperatorMerge;
import rx.internal.operators.OperatorOnBackpressureLatest;
import rx.internal.operators.OperatorReplay;
import rx.internal.util.InternalObservableUtils;
import rx.internal.util.ScalarSynchronousObservable;
import rx.internal.util.UtilityFunctions;
import rx.schedulers.Schedulers;
/* loaded from: classes5.dex */
public class eoc<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a<T> a;

    /* loaded from: classes5.dex */
    public interface a<T> extends soc<koc<? super T>> {
    }

    /* loaded from: classes5.dex */
    public interface b<R, T> extends xoc<koc<? super R>, koc<? super T>> {
    }

    public eoc(a<T> aVar) {
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

    public static <T> eoc<T> d(a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, aVar)) == null) {
            return new eoc<>(usc.h(aVar));
        }
        return (eoc) invokeL.objValue;
    }

    public static <T> eoc<T> m(Iterable<? extends T> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, iterable)) == null) {
            return d(new OnSubscribeFromIterable(iterable));
        }
        return (eoc) invokeL.objValue;
    }

    public static <T> eoc<T> n(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, t)) == null) {
            return ScalarSynchronousObservable.P(t);
        }
        return (eoc) invokeL.objValue;
    }

    public static <T> eoc<T> q(Iterable<? extends eoc<? extends T>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, iterable)) == null) {
            return r(m(iterable));
        }
        return (eoc) invokeL.objValue;
    }

    public static <T> eoc<T> r(eoc<? extends eoc<? extends T>> eocVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, eocVar)) == null) {
            if (eocVar.getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) eocVar).S(UtilityFunctions.b());
            }
            return (eoc<T>) eocVar.o(OperatorMerge.b(false));
        }
        return (eoc) invokeL.objValue;
    }

    public final eoc<T> D(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            return (eoc<T>) o(new wpc(i));
        }
        return (eoc) invokeI.objValue;
    }

    public final loc F(koc<? super T> kocVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, kocVar)) == null) {
            return G(kocVar, this);
        }
        return (loc) invokeL.objValue;
    }

    public final loc H(soc<? super T> socVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, socVar)) == null) {
            if (socVar != null) {
                return F(new sqc(socVar, InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (loc) invokeL.objValue;
    }

    public final eoc<T> J(hoc hocVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, hocVar)) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).T(hocVar);
            }
            return d(new xpc(this, hocVar));
        }
        return (eoc) invokeL.objValue;
    }

    public final eoc<T> h(yoc<? super T, ? super T, Boolean> yocVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, yocVar)) == null) {
            return (eoc<T>) o(new ppc(yocVar));
        }
        return (eoc) invokeL.objValue;
    }

    public final eoc<T> i(soc<? super T> socVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, socVar)) == null) {
            return d(new gpc(this, new rqc(socVar, Actions.a(), Actions.a())));
        }
        return (eoc) invokeL.objValue;
    }

    public final eoc<T> k(xoc<? super T, Boolean> xocVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, xocVar)) == null) {
            return d(new hpc(this, xocVar));
        }
        return (eoc) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.baidu.tieba.xoc<? super T, ? extends com.baidu.tieba.eoc<? extends R>> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <R> eoc<R> l(xoc<? super T, ? extends eoc<? extends R>> xocVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, xocVar)) == null) {
            if (getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) this).S(xocVar);
            }
            return r(p(xocVar));
        }
        return (eoc) invokeL.objValue;
    }

    public final <R> eoc<R> o(b<? extends R, ? super T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, bVar)) == null) {
            return d(new ipc(this.a, bVar));
        }
        return (eoc) invokeL.objValue;
    }

    public final <R> eoc<R> p(xoc<? super T, ? extends R> xocVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, xocVar)) == null) {
            return d(new jpc(this, xocVar));
        }
        return (eoc) invokeL.objValue;
    }

    public final eoc<T> s(hoc hocVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, hocVar)) == null) {
            return t(hocVar, wqc.c);
        }
        return (eoc) invokeL.objValue;
    }

    public final lsc<T> z(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048605, this, i)) == null) {
            return OperatorReplay.R(this, i);
        }
        return (lsc) invokeI.objValue;
    }

    public static <T> loc G(koc<? super T> kocVar, eoc<T> eocVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, kocVar, eocVar)) == null) {
            if (kocVar != null) {
                if (eocVar.a != null) {
                    kocVar.d();
                    if (!(kocVar instanceof osc)) {
                        kocVar = new osc(kocVar);
                    }
                    try {
                        usc.p(eocVar, eocVar.a).call(kocVar);
                        return usc.o(kocVar);
                    } catch (Throwable th) {
                        qoc.e(th);
                        if (kocVar.isUnsubscribed()) {
                            usc.j(usc.m(th));
                        } else {
                            try {
                                kocVar.onError(usc.m(th));
                            } catch (Throwable th2) {
                                qoc.e(th2);
                                OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                                usc.m(onErrorFailedException);
                                throw onErrorFailedException;
                            }
                        }
                        return ktc.c();
                    }
                }
                throw new IllegalStateException("onSubscribe function can not be null.");
            }
            throw new IllegalArgumentException("subscriber can not be null");
        }
        return (loc) invokeLL.objValue;
    }

    public static eoc<Long> M(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65538, null, j, timeUnit)) == null) {
            return N(j, timeUnit, Schedulers.computation());
        }
        return (eoc) invokeJL.objValue;
    }

    public static <T, R> eoc<R> b(List<? extends eoc<? extends T>> list, bpc<? extends R> bpcVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, bpcVar)) == null) {
            return d(new OnSubscribeCombineLatest(list, bpcVar));
        }
        return (eoc) invokeLL.objValue;
    }

    public final eoc<T> K(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048585, this, j, timeUnit)) == null) {
            return L(j, timeUnit, null, Schedulers.computation());
        }
        return (eoc) invokeJL.objValue;
    }

    public final eoc<T> e(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048589, this, j, timeUnit)) == null) {
            return f(j, timeUnit, Schedulers.computation());
        }
        return (eoc) invokeJL.objValue;
    }

    public final eoc<T> t(hoc hocVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048599, this, hocVar, i)) == null) {
            return u(hocVar, false, i);
        }
        return (eoc) invokeLI.objValue;
    }

    public static eoc<Long> N(long j, TimeUnit timeUnit, hoc hocVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Long.valueOf(j), timeUnit, hocVar})) == null) {
            return d(new lpc(j, timeUnit, hocVar));
        }
        return (eoc) invokeCommon.objValue;
    }

    public static <T1, T2, R> eoc<R> c(eoc<? extends T1> eocVar, eoc<? extends T2> eocVar2, yoc<? super T1, ? super T2, ? extends R> yocVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, eocVar, eocVar2, yocVar)) == null) {
            return b(Arrays.asList(eocVar, eocVar2), cpc.a(yocVar));
        }
        return (eoc) invokeLLL.objValue;
    }

    public final lsc<T> B(long j, TimeUnit timeUnit, hoc hocVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), timeUnit, hocVar})) == null) {
            return OperatorReplay.S(this, j, timeUnit, hocVar);
        }
        return (lsc) invokeCommon.objValue;
    }

    public final eoc<T> f(long j, TimeUnit timeUnit, hoc hocVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{Long.valueOf(j), timeUnit, hocVar})) == null) {
            return (eoc<T>) o(new opc(j, timeUnit, hocVar));
        }
        return (eoc) invokeCommon.objValue;
    }

    public static <T> eoc<T> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return EmptyObservableHolder.instance();
        }
        return (eoc) invokeV.objValue;
    }

    public final eoc<T> C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return kpc.b(this);
        }
        return (eoc) invokeV.objValue;
    }

    public final loc E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return F(new sqc(Actions.a(), InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
        }
        return (loc) invokeV.objValue;
    }

    public final eoc<T> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return (eoc<T>) o(npc.b());
        }
        return (eoc) invokeV.objValue;
    }

    public final eoc<T> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return (eoc<T>) o(ppc.d());
        }
        return (eoc) invokeV.objValue;
    }

    public final eoc<T> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return (eoc<T>) o(tpc.b());
        }
        return (eoc) invokeV.objValue;
    }

    public final eoc<T> w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return (eoc<T>) o(upc.b());
        }
        return (eoc) invokeV.objValue;
    }

    public final eoc<T> x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return (eoc<T>) o(OperatorOnBackpressureLatest.b());
        }
        return (eoc) invokeV.objValue;
    }

    public final lsc<T> y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return OperatorReplay.Q(this);
        }
        return (lsc) invokeV.objValue;
    }

    public final lsc<T> A(int i, long j, TimeUnit timeUnit, hoc hocVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), timeUnit, hocVar})) == null) {
            if (i >= 0) {
                return OperatorReplay.T(this, j, timeUnit, hocVar, i);
            }
            throw new IllegalArgumentException("bufferSize < 0");
        }
        return (lsc) invokeCommon.objValue;
    }

    public final eoc<T> L(long j, TimeUnit timeUnit, eoc<? extends T> eocVar, hoc hocVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Long.valueOf(j), timeUnit, eocVar, hocVar})) == null) {
            return (eoc<T>) o(new ypc(j, timeUnit, eocVar, hocVar));
        }
        return (eoc) invokeCommon.objValue;
    }

    public final loc I(soc<? super T> socVar, soc<Throwable> socVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, socVar, socVar2)) == null) {
            if (socVar != null) {
                if (socVar2 != null) {
                    return F(new sqc(socVar, socVar2, Actions.a()));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (loc) invokeLL.objValue;
    }

    public final loc O(koc<? super T> kocVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, kocVar)) == null) {
            try {
                kocVar.d();
                usc.p(this, this.a).call(kocVar);
                return usc.o(kocVar);
            } catch (Throwable th) {
                qoc.e(th);
                try {
                    kocVar.onError(usc.m(th));
                    return ktc.c();
                } catch (Throwable th2) {
                    qoc.e(th2);
                    OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                    usc.m(onErrorFailedException);
                    throw onErrorFailedException;
                }
            }
        }
        return (loc) invokeL.objValue;
    }

    public final eoc<T> u(hoc hocVar, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048600, this, new Object[]{hocVar, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).T(hocVar);
            }
            return (eoc<T>) o(new spc(hocVar, z, i));
        }
        return (eoc) invokeCommon.objValue;
    }
}
