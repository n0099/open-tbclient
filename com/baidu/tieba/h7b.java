package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.TimeUnit;
import rx.exceptions.OnErrorFailedException;
import rx.functions.Actions;
import rx.internal.operators.EmptyObservableHolder;
import rx.internal.operators.OnSubscribeFromIterable;
import rx.internal.operators.OperatorMerge;
import rx.internal.operators.OperatorReplay;
import rx.internal.util.InternalObservableUtils;
import rx.internal.util.ScalarSynchronousObservable;
import rx.internal.util.UtilityFunctions;
import rx.schedulers.Schedulers;
/* loaded from: classes5.dex */
public class h7b<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a<T> a;

    /* loaded from: classes5.dex */
    public interface a<T> extends v7b<n7b<? super T>> {
        @Override // com.baidu.tieba.v7b
        /* synthetic */ void call(T t);
    }

    /* loaded from: classes5.dex */
    public interface b<R, T> extends z7b<n7b<? super R>, n7b<? super T>> {
        @Override // com.baidu.tieba.z7b
        /* synthetic */ R call(T t);
    }

    public h7b(a<T> aVar) {
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

    public static <T> h7b<T> a(a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, aVar)) == null) {
            return new h7b<>(rbb.h(aVar));
        }
        return (h7b) invokeL.objValue;
    }

    public static <T> h7b<T> g(Iterable<? extends T> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, iterable)) == null) {
            return a(new OnSubscribeFromIterable(iterable));
        }
        return (h7b) invokeL.objValue;
    }

    public static <T> h7b<T> h(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, t)) == null) {
            return ScalarSynchronousObservable.G(t);
        }
        return (h7b) invokeL.objValue;
    }

    public static <T> h7b<T> k(Iterable<? extends h7b<? extends T>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, iterable)) == null) {
            return l(g(iterable));
        }
        return (h7b) invokeL.objValue;
    }

    public static <T> h7b<T> l(h7b<? extends h7b<? extends T>> h7bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, h7bVar)) == null) {
            if (h7bVar.getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) h7bVar).J(UtilityFunctions.b());
            }
            return (h7b<T>) h7bVar.i(OperatorMerge.a(false));
        }
        return (h7b) invokeL.objValue;
    }

    public final h7b<T> A(k7b k7bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, k7bVar)) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).K(k7bVar);
            }
            return a(new u8b(this, k7bVar));
        }
        return (h7b) invokeL.objValue;
    }

    public final h7b<T> b(a8b<? super T, ? super T, Boolean> a8bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, a8bVar)) == null) {
            return (h7b<T>) i(new n8b(a8bVar));
        }
        return (h7b) invokeL.objValue;
    }

    public final h7b<T> c(v7b<? super T> v7bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, v7bVar)) == null) {
            return a(new g8b(this, new o9b(v7bVar, Actions.a(), Actions.a())));
        }
        return (h7b) invokeL.objValue;
    }

    public final h7b<T> e(z7b<? super T, Boolean> z7bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, z7bVar)) == null) {
            return a(new h8b(this, z7bVar));
        }
        return (h7b) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.baidu.tieba.z7b<? super T, ? extends com.baidu.tieba.h7b<? extends R>> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <R> h7b<R> f(z7b<? super T, ? extends h7b<? extends R>> z7bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, z7bVar)) == null) {
            if (getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) this).J(z7bVar);
            }
            return l(j(z7bVar));
        }
        return (h7b) invokeL.objValue;
    }

    public final <R> h7b<R> i(b<? extends R, ? super T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar)) == null) {
            return a(new i8b(this.a, bVar));
        }
        return (h7b) invokeL.objValue;
    }

    public final <R> h7b<R> j(z7b<? super T, ? extends R> z7bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, z7bVar)) == null) {
            return a(new j8b(this, z7bVar));
        }
        return (h7b) invokeL.objValue;
    }

    public final h7b<T> m(k7b k7bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, k7bVar)) == null) {
            return n(k7bVar, t9b.c);
        }
        return (h7b) invokeL.objValue;
    }

    public final ibb<T> r(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i)) == null) {
            return OperatorReplay.I(this, i);
        }
        return (ibb) invokeI.objValue;
    }

    public final o7b w(n7b<? super T> n7bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, n7bVar)) == null) {
            return x(n7bVar, this);
        }
        return (o7b) invokeL.objValue;
    }

    public final o7b y(v7b<? super T> v7bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, v7bVar)) == null) {
            if (v7bVar != null) {
                return w(new p9b(v7bVar, InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (o7b) invokeL.objValue;
    }

    public static h7b<Long> D(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65537, null, j, timeUnit)) == null) {
            return E(j, timeUnit, Schedulers.computation());
        }
        return (h7b) invokeJL.objValue;
    }

    public final h7b<T> B(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j, timeUnit)) == null) {
            return C(j, timeUnit, null, Schedulers.computation());
        }
        return (h7b) invokeJL.objValue;
    }

    public final h7b<T> n(k7b k7bVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048587, this, k7bVar, i)) == null) {
            return o(k7bVar, false, i);
        }
        return (h7b) invokeLI.objValue;
    }

    public static h7b<Long> E(long j, TimeUnit timeUnit, k7b k7bVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Long.valueOf(j), timeUnit, k7bVar})) == null) {
            return a(new l8b(j, timeUnit, k7bVar));
        }
        return (h7b) invokeCommon.objValue;
    }

    public final ibb<T> t(long j, TimeUnit timeUnit, k7b k7bVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{Long.valueOf(j), timeUnit, k7bVar})) == null) {
            return OperatorReplay.J(this, j, timeUnit, k7bVar);
        }
        return (ibb) invokeCommon.objValue;
    }

    public static <T> h7b<T> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return EmptyObservableHolder.instance();
        }
        return (h7b) invokeV.objValue;
    }

    public final h7b<T> p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return (h7b<T>) i(r8b.a());
        }
        return (h7b) invokeV.objValue;
    }

    public final ibb<T> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return OperatorReplay.H(this);
        }
        return (ibb) invokeV.objValue;
    }

    public final h7b<T> u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return k8b.a(this);
        }
        return (h7b) invokeV.objValue;
    }

    public final o7b v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return w(new p9b(Actions.a(), InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
        }
        return (o7b) invokeV.objValue;
    }

    public static <T> o7b x(n7b<? super T> n7bVar, h7b<T> h7bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, n7bVar, h7bVar)) == null) {
            if (n7bVar != null) {
                if (h7bVar.a != null) {
                    n7bVar.d();
                    if (!(n7bVar instanceof lbb)) {
                        n7bVar = new lbb(n7bVar);
                    }
                    try {
                        rbb.p(h7bVar, h7bVar.a).call(n7bVar);
                        return rbb.o(n7bVar);
                    } catch (Throwable th) {
                        t7b.e(th);
                        if (n7bVar.isUnsubscribed()) {
                            rbb.j(rbb.m(th));
                        } else {
                            try {
                                n7bVar.onError(rbb.m(th));
                            } catch (Throwable th2) {
                                t7b.e(th2);
                                OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                                rbb.m(onErrorFailedException);
                                throw onErrorFailedException;
                            }
                        }
                        return hcb.c();
                    }
                }
                throw new IllegalStateException("onSubscribe function can not be null.");
            }
            throw new IllegalArgumentException("subscriber can not be null");
        }
        return (o7b) invokeLL.objValue;
    }

    public final h7b<T> C(long j, TimeUnit timeUnit, h7b<? extends T> h7bVar, k7b k7bVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), timeUnit, h7bVar, k7bVar})) == null) {
            return (h7b<T>) i(new v8b(j, timeUnit, h7bVar, k7bVar));
        }
        return (h7b) invokeCommon.objValue;
    }

    public final ibb<T> s(int i, long j, TimeUnit timeUnit, k7b k7bVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), timeUnit, k7bVar})) == null) {
            if (i >= 0) {
                return OperatorReplay.K(this, j, timeUnit, k7bVar, i);
            }
            throw new IllegalArgumentException("bufferSize < 0");
        }
        return (ibb) invokeCommon.objValue;
    }

    public final o7b F(n7b<? super T> n7bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, n7bVar)) == null) {
            try {
                n7bVar.d();
                rbb.p(this, this.a).call(n7bVar);
                return rbb.o(n7bVar);
            } catch (Throwable th) {
                t7b.e(th);
                try {
                    n7bVar.onError(rbb.m(th));
                    return hcb.c();
                } catch (Throwable th2) {
                    t7b.e(th2);
                    OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                    rbb.m(onErrorFailedException);
                    throw onErrorFailedException;
                }
            }
        }
        return (o7b) invokeL.objValue;
    }

    public final h7b<T> o(k7b k7bVar, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{k7bVar, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).K(k7bVar);
            }
            return (h7b<T>) i(new q8b(k7bVar, z, i));
        }
        return (h7b) invokeCommon.objValue;
    }

    public final o7b z(v7b<? super T> v7bVar, v7b<Throwable> v7bVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048598, this, v7bVar, v7bVar2)) == null) {
            if (v7bVar != null) {
                if (v7bVar2 != null) {
                    return w(new p9b(v7bVar, v7bVar2, Actions.a()));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (o7b) invokeLL.objValue;
    }
}
