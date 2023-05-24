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
public class i7b<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a<T> a;

    /* loaded from: classes5.dex */
    public interface a<T> extends w7b<o7b<? super T>> {
        @Override // com.baidu.tieba.w7b
        /* synthetic */ void call(T t);
    }

    /* loaded from: classes5.dex */
    public interface b<R, T> extends a8b<o7b<? super R>, o7b<? super T>> {
        @Override // com.baidu.tieba.a8b
        /* synthetic */ R call(T t);
    }

    public i7b(a<T> aVar) {
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

    public static <T> i7b<T> a(a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, aVar)) == null) {
            return new i7b<>(sbb.h(aVar));
        }
        return (i7b) invokeL.objValue;
    }

    public static <T> i7b<T> g(Iterable<? extends T> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, iterable)) == null) {
            return a(new OnSubscribeFromIterable(iterable));
        }
        return (i7b) invokeL.objValue;
    }

    public static <T> i7b<T> h(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, t)) == null) {
            return ScalarSynchronousObservable.G(t);
        }
        return (i7b) invokeL.objValue;
    }

    public static <T> i7b<T> k(Iterable<? extends i7b<? extends T>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, iterable)) == null) {
            return l(g(iterable));
        }
        return (i7b) invokeL.objValue;
    }

    public static <T> i7b<T> l(i7b<? extends i7b<? extends T>> i7bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, i7bVar)) == null) {
            if (i7bVar.getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) i7bVar).J(UtilityFunctions.b());
            }
            return (i7b<T>) i7bVar.i(OperatorMerge.a(false));
        }
        return (i7b) invokeL.objValue;
    }

    public final i7b<T> A(l7b l7bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, l7bVar)) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).K(l7bVar);
            }
            return a(new v8b(this, l7bVar));
        }
        return (i7b) invokeL.objValue;
    }

    public final i7b<T> b(b8b<? super T, ? super T, Boolean> b8bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, b8bVar)) == null) {
            return (i7b<T>) i(new o8b(b8bVar));
        }
        return (i7b) invokeL.objValue;
    }

    public final i7b<T> c(w7b<? super T> w7bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, w7bVar)) == null) {
            return a(new h8b(this, new p9b(w7bVar, Actions.a(), Actions.a())));
        }
        return (i7b) invokeL.objValue;
    }

    public final i7b<T> e(a8b<? super T, Boolean> a8bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, a8bVar)) == null) {
            return a(new i8b(this, a8bVar));
        }
        return (i7b) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.baidu.tieba.a8b<? super T, ? extends com.baidu.tieba.i7b<? extends R>> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <R> i7b<R> f(a8b<? super T, ? extends i7b<? extends R>> a8bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, a8bVar)) == null) {
            if (getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) this).J(a8bVar);
            }
            return l(j(a8bVar));
        }
        return (i7b) invokeL.objValue;
    }

    public final <R> i7b<R> i(b<? extends R, ? super T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar)) == null) {
            return a(new j8b(this.a, bVar));
        }
        return (i7b) invokeL.objValue;
    }

    public final <R> i7b<R> j(a8b<? super T, ? extends R> a8bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, a8bVar)) == null) {
            return a(new k8b(this, a8bVar));
        }
        return (i7b) invokeL.objValue;
    }

    public final i7b<T> m(l7b l7bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, l7bVar)) == null) {
            return n(l7bVar, u9b.c);
        }
        return (i7b) invokeL.objValue;
    }

    public final jbb<T> r(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i)) == null) {
            return OperatorReplay.I(this, i);
        }
        return (jbb) invokeI.objValue;
    }

    public final p7b w(o7b<? super T> o7bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, o7bVar)) == null) {
            return x(o7bVar, this);
        }
        return (p7b) invokeL.objValue;
    }

    public final p7b y(w7b<? super T> w7bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, w7bVar)) == null) {
            if (w7bVar != null) {
                return w(new q9b(w7bVar, InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (p7b) invokeL.objValue;
    }

    public static i7b<Long> D(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65537, null, j, timeUnit)) == null) {
            return E(j, timeUnit, Schedulers.computation());
        }
        return (i7b) invokeJL.objValue;
    }

    public final i7b<T> B(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j, timeUnit)) == null) {
            return C(j, timeUnit, null, Schedulers.computation());
        }
        return (i7b) invokeJL.objValue;
    }

    public final i7b<T> n(l7b l7bVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048587, this, l7bVar, i)) == null) {
            return o(l7bVar, false, i);
        }
        return (i7b) invokeLI.objValue;
    }

    public static i7b<Long> E(long j, TimeUnit timeUnit, l7b l7bVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Long.valueOf(j), timeUnit, l7bVar})) == null) {
            return a(new m8b(j, timeUnit, l7bVar));
        }
        return (i7b) invokeCommon.objValue;
    }

    public final jbb<T> t(long j, TimeUnit timeUnit, l7b l7bVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{Long.valueOf(j), timeUnit, l7bVar})) == null) {
            return OperatorReplay.J(this, j, timeUnit, l7bVar);
        }
        return (jbb) invokeCommon.objValue;
    }

    public static <T> i7b<T> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return EmptyObservableHolder.instance();
        }
        return (i7b) invokeV.objValue;
    }

    public final i7b<T> p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return (i7b<T>) i(s8b.a());
        }
        return (i7b) invokeV.objValue;
    }

    public final jbb<T> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return OperatorReplay.H(this);
        }
        return (jbb) invokeV.objValue;
    }

    public final i7b<T> u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return l8b.a(this);
        }
        return (i7b) invokeV.objValue;
    }

    public final p7b v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return w(new q9b(Actions.a(), InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
        }
        return (p7b) invokeV.objValue;
    }

    public static <T> p7b x(o7b<? super T> o7bVar, i7b<T> i7bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, o7bVar, i7bVar)) == null) {
            if (o7bVar != null) {
                if (i7bVar.a != null) {
                    o7bVar.d();
                    if (!(o7bVar instanceof mbb)) {
                        o7bVar = new mbb(o7bVar);
                    }
                    try {
                        sbb.p(i7bVar, i7bVar.a).call(o7bVar);
                        return sbb.o(o7bVar);
                    } catch (Throwable th) {
                        u7b.e(th);
                        if (o7bVar.isUnsubscribed()) {
                            sbb.j(sbb.m(th));
                        } else {
                            try {
                                o7bVar.onError(sbb.m(th));
                            } catch (Throwable th2) {
                                u7b.e(th2);
                                OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                                sbb.m(onErrorFailedException);
                                throw onErrorFailedException;
                            }
                        }
                        return icb.c();
                    }
                }
                throw new IllegalStateException("onSubscribe function can not be null.");
            }
            throw new IllegalArgumentException("subscriber can not be null");
        }
        return (p7b) invokeLL.objValue;
    }

    public final i7b<T> C(long j, TimeUnit timeUnit, i7b<? extends T> i7bVar, l7b l7bVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), timeUnit, i7bVar, l7bVar})) == null) {
            return (i7b<T>) i(new w8b(j, timeUnit, i7bVar, l7bVar));
        }
        return (i7b) invokeCommon.objValue;
    }

    public final jbb<T> s(int i, long j, TimeUnit timeUnit, l7b l7bVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), timeUnit, l7bVar})) == null) {
            if (i >= 0) {
                return OperatorReplay.K(this, j, timeUnit, l7bVar, i);
            }
            throw new IllegalArgumentException("bufferSize < 0");
        }
        return (jbb) invokeCommon.objValue;
    }

    public final p7b F(o7b<? super T> o7bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, o7bVar)) == null) {
            try {
                o7bVar.d();
                sbb.p(this, this.a).call(o7bVar);
                return sbb.o(o7bVar);
            } catch (Throwable th) {
                u7b.e(th);
                try {
                    o7bVar.onError(sbb.m(th));
                    return icb.c();
                } catch (Throwable th2) {
                    u7b.e(th2);
                    OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                    sbb.m(onErrorFailedException);
                    throw onErrorFailedException;
                }
            }
        }
        return (p7b) invokeL.objValue;
    }

    public final i7b<T> o(l7b l7bVar, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{l7bVar, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).K(l7bVar);
            }
            return (i7b<T>) i(new r8b(l7bVar, z, i));
        }
        return (i7b) invokeCommon.objValue;
    }

    public final p7b z(w7b<? super T> w7bVar, w7b<Throwable> w7bVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048598, this, w7bVar, w7bVar2)) == null) {
            if (w7bVar != null) {
                if (w7bVar2 != null) {
                    return w(new q9b(w7bVar, w7bVar2, Actions.a()));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (p7b) invokeLL.objValue;
    }
}
