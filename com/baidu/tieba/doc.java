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
public class doc<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a<T> a;

    /* loaded from: classes5.dex */
    public interface a<T> extends roc<joc<? super T>> {
    }

    /* loaded from: classes5.dex */
    public interface b<R, T> extends woc<joc<? super R>, joc<? super T>> {
    }

    public doc(a<T> aVar) {
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

    public static <T> doc<T> d(a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, aVar)) == null) {
            return new doc<>(tsc.h(aVar));
        }
        return (doc) invokeL.objValue;
    }

    public static <T> doc<T> m(Iterable<? extends T> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, iterable)) == null) {
            return d(new OnSubscribeFromIterable(iterable));
        }
        return (doc) invokeL.objValue;
    }

    public static <T> doc<T> n(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, t)) == null) {
            return ScalarSynchronousObservable.P(t);
        }
        return (doc) invokeL.objValue;
    }

    public static <T> doc<T> q(Iterable<? extends doc<? extends T>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, iterable)) == null) {
            return r(m(iterable));
        }
        return (doc) invokeL.objValue;
    }

    public static <T> doc<T> r(doc<? extends doc<? extends T>> docVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, docVar)) == null) {
            if (docVar.getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) docVar).S(UtilityFunctions.b());
            }
            return (doc<T>) docVar.o(OperatorMerge.b(false));
        }
        return (doc) invokeL.objValue;
    }

    public final doc<T> D(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            return (doc<T>) o(new vpc(i));
        }
        return (doc) invokeI.objValue;
    }

    public final koc F(joc<? super T> jocVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, jocVar)) == null) {
            return G(jocVar, this);
        }
        return (koc) invokeL.objValue;
    }

    public final koc H(roc<? super T> rocVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, rocVar)) == null) {
            if (rocVar != null) {
                return F(new rqc(rocVar, InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (koc) invokeL.objValue;
    }

    public final doc<T> J(goc gocVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, gocVar)) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).T(gocVar);
            }
            return d(new wpc(this, gocVar));
        }
        return (doc) invokeL.objValue;
    }

    public final doc<T> h(xoc<? super T, ? super T, Boolean> xocVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, xocVar)) == null) {
            return (doc<T>) o(new opc(xocVar));
        }
        return (doc) invokeL.objValue;
    }

    public final doc<T> i(roc<? super T> rocVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, rocVar)) == null) {
            return d(new fpc(this, new qqc(rocVar, Actions.a(), Actions.a())));
        }
        return (doc) invokeL.objValue;
    }

    public final doc<T> k(woc<? super T, Boolean> wocVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, wocVar)) == null) {
            return d(new gpc(this, wocVar));
        }
        return (doc) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.baidu.tieba.woc<? super T, ? extends com.baidu.tieba.doc<? extends R>> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <R> doc<R> l(woc<? super T, ? extends doc<? extends R>> wocVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, wocVar)) == null) {
            if (getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) this).S(wocVar);
            }
            return r(p(wocVar));
        }
        return (doc) invokeL.objValue;
    }

    public final <R> doc<R> o(b<? extends R, ? super T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, bVar)) == null) {
            return d(new hpc(this.a, bVar));
        }
        return (doc) invokeL.objValue;
    }

    public final <R> doc<R> p(woc<? super T, ? extends R> wocVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, wocVar)) == null) {
            return d(new ipc(this, wocVar));
        }
        return (doc) invokeL.objValue;
    }

    public final doc<T> s(goc gocVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, gocVar)) == null) {
            return t(gocVar, vqc.c);
        }
        return (doc) invokeL.objValue;
    }

    public final ksc<T> z(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048605, this, i)) == null) {
            return OperatorReplay.R(this, i);
        }
        return (ksc) invokeI.objValue;
    }

    public static <T> koc G(joc<? super T> jocVar, doc<T> docVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, jocVar, docVar)) == null) {
            if (jocVar != null) {
                if (docVar.a != null) {
                    jocVar.d();
                    if (!(jocVar instanceof nsc)) {
                        jocVar = new nsc(jocVar);
                    }
                    try {
                        tsc.p(docVar, docVar.a).call(jocVar);
                        return tsc.o(jocVar);
                    } catch (Throwable th) {
                        poc.e(th);
                        if (jocVar.isUnsubscribed()) {
                            tsc.j(tsc.m(th));
                        } else {
                            try {
                                jocVar.onError(tsc.m(th));
                            } catch (Throwable th2) {
                                poc.e(th2);
                                OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                                tsc.m(onErrorFailedException);
                                throw onErrorFailedException;
                            }
                        }
                        return jtc.c();
                    }
                }
                throw new IllegalStateException("onSubscribe function can not be null.");
            }
            throw new IllegalArgumentException("subscriber can not be null");
        }
        return (koc) invokeLL.objValue;
    }

    public static doc<Long> M(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65538, null, j, timeUnit)) == null) {
            return N(j, timeUnit, Schedulers.computation());
        }
        return (doc) invokeJL.objValue;
    }

    public static <T, R> doc<R> b(List<? extends doc<? extends T>> list, apc<? extends R> apcVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, apcVar)) == null) {
            return d(new OnSubscribeCombineLatest(list, apcVar));
        }
        return (doc) invokeLL.objValue;
    }

    public final doc<T> K(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048585, this, j, timeUnit)) == null) {
            return L(j, timeUnit, null, Schedulers.computation());
        }
        return (doc) invokeJL.objValue;
    }

    public final doc<T> e(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048589, this, j, timeUnit)) == null) {
            return f(j, timeUnit, Schedulers.computation());
        }
        return (doc) invokeJL.objValue;
    }

    public final doc<T> t(goc gocVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048599, this, gocVar, i)) == null) {
            return u(gocVar, false, i);
        }
        return (doc) invokeLI.objValue;
    }

    public static doc<Long> N(long j, TimeUnit timeUnit, goc gocVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Long.valueOf(j), timeUnit, gocVar})) == null) {
            return d(new kpc(j, timeUnit, gocVar));
        }
        return (doc) invokeCommon.objValue;
    }

    public static <T1, T2, R> doc<R> c(doc<? extends T1> docVar, doc<? extends T2> docVar2, xoc<? super T1, ? super T2, ? extends R> xocVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, docVar, docVar2, xocVar)) == null) {
            return b(Arrays.asList(docVar, docVar2), bpc.a(xocVar));
        }
        return (doc) invokeLLL.objValue;
    }

    public final ksc<T> B(long j, TimeUnit timeUnit, goc gocVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), timeUnit, gocVar})) == null) {
            return OperatorReplay.S(this, j, timeUnit, gocVar);
        }
        return (ksc) invokeCommon.objValue;
    }

    public final doc<T> f(long j, TimeUnit timeUnit, goc gocVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{Long.valueOf(j), timeUnit, gocVar})) == null) {
            return (doc<T>) o(new npc(j, timeUnit, gocVar));
        }
        return (doc) invokeCommon.objValue;
    }

    public static <T> doc<T> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return EmptyObservableHolder.instance();
        }
        return (doc) invokeV.objValue;
    }

    public final doc<T> C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return jpc.b(this);
        }
        return (doc) invokeV.objValue;
    }

    public final koc E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return F(new rqc(Actions.a(), InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
        }
        return (koc) invokeV.objValue;
    }

    public final doc<T> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return (doc<T>) o(mpc.b());
        }
        return (doc) invokeV.objValue;
    }

    public final doc<T> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return (doc<T>) o(opc.d());
        }
        return (doc) invokeV.objValue;
    }

    public final doc<T> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return (doc<T>) o(spc.b());
        }
        return (doc) invokeV.objValue;
    }

    public final doc<T> w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return (doc<T>) o(tpc.b());
        }
        return (doc) invokeV.objValue;
    }

    public final doc<T> x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return (doc<T>) o(OperatorOnBackpressureLatest.b());
        }
        return (doc) invokeV.objValue;
    }

    public final ksc<T> y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return OperatorReplay.Q(this);
        }
        return (ksc) invokeV.objValue;
    }

    public final ksc<T> A(int i, long j, TimeUnit timeUnit, goc gocVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), timeUnit, gocVar})) == null) {
            if (i >= 0) {
                return OperatorReplay.T(this, j, timeUnit, gocVar, i);
            }
            throw new IllegalArgumentException("bufferSize < 0");
        }
        return (ksc) invokeCommon.objValue;
    }

    public final doc<T> L(long j, TimeUnit timeUnit, doc<? extends T> docVar, goc gocVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Long.valueOf(j), timeUnit, docVar, gocVar})) == null) {
            return (doc<T>) o(new xpc(j, timeUnit, docVar, gocVar));
        }
        return (doc) invokeCommon.objValue;
    }

    public final koc I(roc<? super T> rocVar, roc<Throwable> rocVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, rocVar, rocVar2)) == null) {
            if (rocVar != null) {
                if (rocVar2 != null) {
                    return F(new rqc(rocVar, rocVar2, Actions.a()));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (koc) invokeLL.objValue;
    }

    public final koc O(joc<? super T> jocVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, jocVar)) == null) {
            try {
                jocVar.d();
                tsc.p(this, this.a).call(jocVar);
                return tsc.o(jocVar);
            } catch (Throwable th) {
                poc.e(th);
                try {
                    jocVar.onError(tsc.m(th));
                    return jtc.c();
                } catch (Throwable th2) {
                    poc.e(th2);
                    OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                    tsc.m(onErrorFailedException);
                    throw onErrorFailedException;
                }
            }
        }
        return (koc) invokeL.objValue;
    }

    public final doc<T> u(goc gocVar, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048600, this, new Object[]{gocVar, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).T(gocVar);
            }
            return (doc<T>) o(new rpc(gocVar, z, i));
        }
        return (doc) invokeCommon.objValue;
    }
}
