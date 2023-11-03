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
/* loaded from: classes6.dex */
public class ijc<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a<T> a;

    /* loaded from: classes6.dex */
    public interface a<T> extends wjc<ojc<? super T>> {
    }

    /* loaded from: classes6.dex */
    public interface b<R, T> extends bkc<ojc<? super R>, ojc<? super T>> {
    }

    public ijc(a<T> aVar) {
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

    public static <T> ijc<T> d(a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, aVar)) == null) {
            return new ijc<>(ync.h(aVar));
        }
        return (ijc) invokeL.objValue;
    }

    public static <T> ijc<T> m(Iterable<? extends T> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, iterable)) == null) {
            return d(new OnSubscribeFromIterable(iterable));
        }
        return (ijc) invokeL.objValue;
    }

    public static <T> ijc<T> n(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, t)) == null) {
            return ScalarSynchronousObservable.P(t);
        }
        return (ijc) invokeL.objValue;
    }

    public static <T> ijc<T> q(Iterable<? extends ijc<? extends T>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, iterable)) == null) {
            return r(m(iterable));
        }
        return (ijc) invokeL.objValue;
    }

    public static <T> ijc<T> r(ijc<? extends ijc<? extends T>> ijcVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, ijcVar)) == null) {
            if (ijcVar.getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) ijcVar).S(UtilityFunctions.b());
            }
            return (ijc<T>) ijcVar.o(OperatorMerge.b(false));
        }
        return (ijc) invokeL.objValue;
    }

    public final ijc<T> D(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            return (ijc<T>) o(new alc(i));
        }
        return (ijc) invokeI.objValue;
    }

    public final pjc F(ojc<? super T> ojcVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, ojcVar)) == null) {
            return G(ojcVar, this);
        }
        return (pjc) invokeL.objValue;
    }

    public final pjc H(wjc<? super T> wjcVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, wjcVar)) == null) {
            if (wjcVar != null) {
                return F(new wlc(wjcVar, InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (pjc) invokeL.objValue;
    }

    public final ijc<T> J(ljc ljcVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ljcVar)) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).T(ljcVar);
            }
            return d(new blc(this, ljcVar));
        }
        return (ijc) invokeL.objValue;
    }

    public final ijc<T> h(ckc<? super T, ? super T, Boolean> ckcVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, ckcVar)) == null) {
            return (ijc<T>) o(new tkc(ckcVar));
        }
        return (ijc) invokeL.objValue;
    }

    public final ijc<T> i(wjc<? super T> wjcVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, wjcVar)) == null) {
            return d(new kkc(this, new vlc(wjcVar, Actions.a(), Actions.a())));
        }
        return (ijc) invokeL.objValue;
    }

    public final ijc<T> k(bkc<? super T, Boolean> bkcVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, bkcVar)) == null) {
            return d(new lkc(this, bkcVar));
        }
        return (ijc) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.baidu.tieba.bkc<? super T, ? extends com.baidu.tieba.ijc<? extends R>> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <R> ijc<R> l(bkc<? super T, ? extends ijc<? extends R>> bkcVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, bkcVar)) == null) {
            if (getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) this).S(bkcVar);
            }
            return r(p(bkcVar));
        }
        return (ijc) invokeL.objValue;
    }

    public final <R> ijc<R> o(b<? extends R, ? super T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, bVar)) == null) {
            return d(new mkc(this.a, bVar));
        }
        return (ijc) invokeL.objValue;
    }

    public final <R> ijc<R> p(bkc<? super T, ? extends R> bkcVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, bkcVar)) == null) {
            return d(new nkc(this, bkcVar));
        }
        return (ijc) invokeL.objValue;
    }

    public final ijc<T> s(ljc ljcVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, ljcVar)) == null) {
            return t(ljcVar, amc.c);
        }
        return (ijc) invokeL.objValue;
    }

    public final pnc<T> z(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048605, this, i)) == null) {
            return OperatorReplay.R(this, i);
        }
        return (pnc) invokeI.objValue;
    }

    public static <T> pjc G(ojc<? super T> ojcVar, ijc<T> ijcVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, ojcVar, ijcVar)) == null) {
            if (ojcVar != null) {
                if (ijcVar.a != null) {
                    ojcVar.d();
                    if (!(ojcVar instanceof snc)) {
                        ojcVar = new snc(ojcVar);
                    }
                    try {
                        ync.p(ijcVar, ijcVar.a).call(ojcVar);
                        return ync.o(ojcVar);
                    } catch (Throwable th) {
                        ujc.e(th);
                        if (ojcVar.isUnsubscribed()) {
                            ync.j(ync.m(th));
                        } else {
                            try {
                                ojcVar.onError(ync.m(th));
                            } catch (Throwable th2) {
                                ujc.e(th2);
                                OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                                ync.m(onErrorFailedException);
                                throw onErrorFailedException;
                            }
                        }
                        return ooc.c();
                    }
                }
                throw new IllegalStateException("onSubscribe function can not be null.");
            }
            throw new IllegalArgumentException("subscriber can not be null");
        }
        return (pjc) invokeLL.objValue;
    }

    public static ijc<Long> M(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65538, null, j, timeUnit)) == null) {
            return N(j, timeUnit, Schedulers.computation());
        }
        return (ijc) invokeJL.objValue;
    }

    public static <T, R> ijc<R> b(List<? extends ijc<? extends T>> list, fkc<? extends R> fkcVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, fkcVar)) == null) {
            return d(new OnSubscribeCombineLatest(list, fkcVar));
        }
        return (ijc) invokeLL.objValue;
    }

    public final ijc<T> K(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048585, this, j, timeUnit)) == null) {
            return L(j, timeUnit, null, Schedulers.computation());
        }
        return (ijc) invokeJL.objValue;
    }

    public final ijc<T> e(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048589, this, j, timeUnit)) == null) {
            return f(j, timeUnit, Schedulers.computation());
        }
        return (ijc) invokeJL.objValue;
    }

    public final ijc<T> t(ljc ljcVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048599, this, ljcVar, i)) == null) {
            return u(ljcVar, false, i);
        }
        return (ijc) invokeLI.objValue;
    }

    public static ijc<Long> N(long j, TimeUnit timeUnit, ljc ljcVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Long.valueOf(j), timeUnit, ljcVar})) == null) {
            return d(new pkc(j, timeUnit, ljcVar));
        }
        return (ijc) invokeCommon.objValue;
    }

    public static <T1, T2, R> ijc<R> c(ijc<? extends T1> ijcVar, ijc<? extends T2> ijcVar2, ckc<? super T1, ? super T2, ? extends R> ckcVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, ijcVar, ijcVar2, ckcVar)) == null) {
            return b(Arrays.asList(ijcVar, ijcVar2), gkc.a(ckcVar));
        }
        return (ijc) invokeLLL.objValue;
    }

    public final pnc<T> B(long j, TimeUnit timeUnit, ljc ljcVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), timeUnit, ljcVar})) == null) {
            return OperatorReplay.S(this, j, timeUnit, ljcVar);
        }
        return (pnc) invokeCommon.objValue;
    }

    public final ijc<T> f(long j, TimeUnit timeUnit, ljc ljcVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{Long.valueOf(j), timeUnit, ljcVar})) == null) {
            return (ijc<T>) o(new skc(j, timeUnit, ljcVar));
        }
        return (ijc) invokeCommon.objValue;
    }

    public static <T> ijc<T> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return EmptyObservableHolder.instance();
        }
        return (ijc) invokeV.objValue;
    }

    public final ijc<T> C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return okc.b(this);
        }
        return (ijc) invokeV.objValue;
    }

    public final pjc E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return F(new wlc(Actions.a(), InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
        }
        return (pjc) invokeV.objValue;
    }

    public final ijc<T> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return (ijc<T>) o(rkc.b());
        }
        return (ijc) invokeV.objValue;
    }

    public final ijc<T> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return (ijc<T>) o(tkc.d());
        }
        return (ijc) invokeV.objValue;
    }

    public final ijc<T> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return (ijc<T>) o(xkc.b());
        }
        return (ijc) invokeV.objValue;
    }

    public final ijc<T> w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return (ijc<T>) o(ykc.b());
        }
        return (ijc) invokeV.objValue;
    }

    public final ijc<T> x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return (ijc<T>) o(OperatorOnBackpressureLatest.b());
        }
        return (ijc) invokeV.objValue;
    }

    public final pnc<T> y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return OperatorReplay.Q(this);
        }
        return (pnc) invokeV.objValue;
    }

    public final pnc<T> A(int i, long j, TimeUnit timeUnit, ljc ljcVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), timeUnit, ljcVar})) == null) {
            if (i >= 0) {
                return OperatorReplay.T(this, j, timeUnit, ljcVar, i);
            }
            throw new IllegalArgumentException("bufferSize < 0");
        }
        return (pnc) invokeCommon.objValue;
    }

    public final ijc<T> L(long j, TimeUnit timeUnit, ijc<? extends T> ijcVar, ljc ljcVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Long.valueOf(j), timeUnit, ijcVar, ljcVar})) == null) {
            return (ijc<T>) o(new clc(j, timeUnit, ijcVar, ljcVar));
        }
        return (ijc) invokeCommon.objValue;
    }

    public final pjc I(wjc<? super T> wjcVar, wjc<Throwable> wjcVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, wjcVar, wjcVar2)) == null) {
            if (wjcVar != null) {
                if (wjcVar2 != null) {
                    return F(new wlc(wjcVar, wjcVar2, Actions.a()));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (pjc) invokeLL.objValue;
    }

    public final pjc O(ojc<? super T> ojcVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, ojcVar)) == null) {
            try {
                ojcVar.d();
                ync.p(this, this.a).call(ojcVar);
                return ync.o(ojcVar);
            } catch (Throwable th) {
                ujc.e(th);
                try {
                    ojcVar.onError(ync.m(th));
                    return ooc.c();
                } catch (Throwable th2) {
                    ujc.e(th2);
                    OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                    ync.m(onErrorFailedException);
                    throw onErrorFailedException;
                }
            }
        }
        return (pjc) invokeL.objValue;
    }

    public final ijc<T> u(ljc ljcVar, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048600, this, new Object[]{ljcVar, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).T(ljcVar);
            }
            return (ijc<T>) o(new wkc(ljcVar, z, i));
        }
        return (ijc) invokeCommon.objValue;
    }
}
