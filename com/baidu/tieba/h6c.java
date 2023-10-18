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
public class h6c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a<T> a;

    /* loaded from: classes6.dex */
    public interface a<T> extends v6c<n6c<? super T>> {
    }

    /* loaded from: classes6.dex */
    public interface b<R, T> extends a7c<n6c<? super R>, n6c<? super T>> {
    }

    public h6c(a<T> aVar) {
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

    public static <T> h6c<T> d(a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, aVar)) == null) {
            return new h6c<>(xac.h(aVar));
        }
        return (h6c) invokeL.objValue;
    }

    public static <T> h6c<T> m(Iterable<? extends T> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, iterable)) == null) {
            return d(new OnSubscribeFromIterable(iterable));
        }
        return (h6c) invokeL.objValue;
    }

    public static <T> h6c<T> n(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, t)) == null) {
            return ScalarSynchronousObservable.P(t);
        }
        return (h6c) invokeL.objValue;
    }

    public static <T> h6c<T> q(Iterable<? extends h6c<? extends T>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, iterable)) == null) {
            return r(m(iterable));
        }
        return (h6c) invokeL.objValue;
    }

    public static <T> h6c<T> r(h6c<? extends h6c<? extends T>> h6cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, h6cVar)) == null) {
            if (h6cVar.getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) h6cVar).S(UtilityFunctions.b());
            }
            return (h6c<T>) h6cVar.o(OperatorMerge.b(false));
        }
        return (h6c) invokeL.objValue;
    }

    public final h6c<T> D(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            return (h6c<T>) o(new z7c(i));
        }
        return (h6c) invokeI.objValue;
    }

    public final o6c F(n6c<? super T> n6cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, n6cVar)) == null) {
            return G(n6cVar, this);
        }
        return (o6c) invokeL.objValue;
    }

    public final o6c H(v6c<? super T> v6cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, v6cVar)) == null) {
            if (v6cVar != null) {
                return F(new v8c(v6cVar, InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (o6c) invokeL.objValue;
    }

    public final h6c<T> J(k6c k6cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, k6cVar)) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).T(k6cVar);
            }
            return d(new a8c(this, k6cVar));
        }
        return (h6c) invokeL.objValue;
    }

    public final h6c<T> h(b7c<? super T, ? super T, Boolean> b7cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, b7cVar)) == null) {
            return (h6c<T>) o(new s7c(b7cVar));
        }
        return (h6c) invokeL.objValue;
    }

    public final h6c<T> i(v6c<? super T> v6cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, v6cVar)) == null) {
            return d(new j7c(this, new u8c(v6cVar, Actions.a(), Actions.a())));
        }
        return (h6c) invokeL.objValue;
    }

    public final h6c<T> k(a7c<? super T, Boolean> a7cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, a7cVar)) == null) {
            return d(new k7c(this, a7cVar));
        }
        return (h6c) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.baidu.tieba.a7c<? super T, ? extends com.baidu.tieba.h6c<? extends R>> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <R> h6c<R> l(a7c<? super T, ? extends h6c<? extends R>> a7cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, a7cVar)) == null) {
            if (getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) this).S(a7cVar);
            }
            return r(p(a7cVar));
        }
        return (h6c) invokeL.objValue;
    }

    public final <R> h6c<R> o(b<? extends R, ? super T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, bVar)) == null) {
            return d(new l7c(this.a, bVar));
        }
        return (h6c) invokeL.objValue;
    }

    public final <R> h6c<R> p(a7c<? super T, ? extends R> a7cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, a7cVar)) == null) {
            return d(new m7c(this, a7cVar));
        }
        return (h6c) invokeL.objValue;
    }

    public final h6c<T> s(k6c k6cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, k6cVar)) == null) {
            return t(k6cVar, z8c.c);
        }
        return (h6c) invokeL.objValue;
    }

    public final oac<T> z(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048605, this, i)) == null) {
            return OperatorReplay.R(this, i);
        }
        return (oac) invokeI.objValue;
    }

    public static <T> o6c G(n6c<? super T> n6cVar, h6c<T> h6cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, n6cVar, h6cVar)) == null) {
            if (n6cVar != null) {
                if (h6cVar.a != null) {
                    n6cVar.d();
                    if (!(n6cVar instanceof rac)) {
                        n6cVar = new rac(n6cVar);
                    }
                    try {
                        xac.p(h6cVar, h6cVar.a).call(n6cVar);
                        return xac.o(n6cVar);
                    } catch (Throwable th) {
                        t6c.e(th);
                        if (n6cVar.isUnsubscribed()) {
                            xac.j(xac.m(th));
                        } else {
                            try {
                                n6cVar.onError(xac.m(th));
                            } catch (Throwable th2) {
                                t6c.e(th2);
                                OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                                xac.m(onErrorFailedException);
                                throw onErrorFailedException;
                            }
                        }
                        return nbc.c();
                    }
                }
                throw new IllegalStateException("onSubscribe function can not be null.");
            }
            throw new IllegalArgumentException("subscriber can not be null");
        }
        return (o6c) invokeLL.objValue;
    }

    public static h6c<Long> M(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65538, null, j, timeUnit)) == null) {
            return N(j, timeUnit, Schedulers.computation());
        }
        return (h6c) invokeJL.objValue;
    }

    public static <T, R> h6c<R> b(List<? extends h6c<? extends T>> list, e7c<? extends R> e7cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, e7cVar)) == null) {
            return d(new OnSubscribeCombineLatest(list, e7cVar));
        }
        return (h6c) invokeLL.objValue;
    }

    public final h6c<T> K(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048585, this, j, timeUnit)) == null) {
            return L(j, timeUnit, null, Schedulers.computation());
        }
        return (h6c) invokeJL.objValue;
    }

    public final h6c<T> e(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048589, this, j, timeUnit)) == null) {
            return f(j, timeUnit, Schedulers.computation());
        }
        return (h6c) invokeJL.objValue;
    }

    public final h6c<T> t(k6c k6cVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048599, this, k6cVar, i)) == null) {
            return u(k6cVar, false, i);
        }
        return (h6c) invokeLI.objValue;
    }

    public static h6c<Long> N(long j, TimeUnit timeUnit, k6c k6cVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Long.valueOf(j), timeUnit, k6cVar})) == null) {
            return d(new o7c(j, timeUnit, k6cVar));
        }
        return (h6c) invokeCommon.objValue;
    }

    public static <T1, T2, R> h6c<R> c(h6c<? extends T1> h6cVar, h6c<? extends T2> h6cVar2, b7c<? super T1, ? super T2, ? extends R> b7cVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, h6cVar, h6cVar2, b7cVar)) == null) {
            return b(Arrays.asList(h6cVar, h6cVar2), f7c.a(b7cVar));
        }
        return (h6c) invokeLLL.objValue;
    }

    public final oac<T> B(long j, TimeUnit timeUnit, k6c k6cVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), timeUnit, k6cVar})) == null) {
            return OperatorReplay.S(this, j, timeUnit, k6cVar);
        }
        return (oac) invokeCommon.objValue;
    }

    public final h6c<T> f(long j, TimeUnit timeUnit, k6c k6cVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{Long.valueOf(j), timeUnit, k6cVar})) == null) {
            return (h6c<T>) o(new r7c(j, timeUnit, k6cVar));
        }
        return (h6c) invokeCommon.objValue;
    }

    public static <T> h6c<T> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return EmptyObservableHolder.instance();
        }
        return (h6c) invokeV.objValue;
    }

    public final h6c<T> C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return n7c.b(this);
        }
        return (h6c) invokeV.objValue;
    }

    public final o6c E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return F(new v8c(Actions.a(), InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
        }
        return (o6c) invokeV.objValue;
    }

    public final h6c<T> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return (h6c<T>) o(q7c.b());
        }
        return (h6c) invokeV.objValue;
    }

    public final h6c<T> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return (h6c<T>) o(s7c.d());
        }
        return (h6c) invokeV.objValue;
    }

    public final h6c<T> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return (h6c<T>) o(w7c.b());
        }
        return (h6c) invokeV.objValue;
    }

    public final h6c<T> w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return (h6c<T>) o(x7c.b());
        }
        return (h6c) invokeV.objValue;
    }

    public final h6c<T> x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return (h6c<T>) o(OperatorOnBackpressureLatest.b());
        }
        return (h6c) invokeV.objValue;
    }

    public final oac<T> y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return OperatorReplay.Q(this);
        }
        return (oac) invokeV.objValue;
    }

    public final oac<T> A(int i, long j, TimeUnit timeUnit, k6c k6cVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), timeUnit, k6cVar})) == null) {
            if (i >= 0) {
                return OperatorReplay.T(this, j, timeUnit, k6cVar, i);
            }
            throw new IllegalArgumentException("bufferSize < 0");
        }
        return (oac) invokeCommon.objValue;
    }

    public final h6c<T> L(long j, TimeUnit timeUnit, h6c<? extends T> h6cVar, k6c k6cVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Long.valueOf(j), timeUnit, h6cVar, k6cVar})) == null) {
            return (h6c<T>) o(new b8c(j, timeUnit, h6cVar, k6cVar));
        }
        return (h6c) invokeCommon.objValue;
    }

    public final o6c I(v6c<? super T> v6cVar, v6c<Throwable> v6cVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, v6cVar, v6cVar2)) == null) {
            if (v6cVar != null) {
                if (v6cVar2 != null) {
                    return F(new v8c(v6cVar, v6cVar2, Actions.a()));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (o6c) invokeLL.objValue;
    }

    public final o6c O(n6c<? super T> n6cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, n6cVar)) == null) {
            try {
                n6cVar.d();
                xac.p(this, this.a).call(n6cVar);
                return xac.o(n6cVar);
            } catch (Throwable th) {
                t6c.e(th);
                try {
                    n6cVar.onError(xac.m(th));
                    return nbc.c();
                } catch (Throwable th2) {
                    t6c.e(th2);
                    OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                    xac.m(onErrorFailedException);
                    throw onErrorFailedException;
                }
            }
        }
        return (o6c) invokeL.objValue;
    }

    public final h6c<T> u(k6c k6cVar, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048600, this, new Object[]{k6cVar, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).T(k6cVar);
            }
            return (h6c<T>) o(new v7c(k6cVar, z, i));
        }
        return (h6c) invokeCommon.objValue;
    }
}
