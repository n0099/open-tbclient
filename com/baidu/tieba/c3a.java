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
/* loaded from: classes3.dex */
public class c3a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a<T> a;

    /* loaded from: classes3.dex */
    public interface a<T> extends q3a<i3a<? super T>> {
        @Override // com.baidu.tieba.q3a
        /* synthetic */ void call(T t);
    }

    /* loaded from: classes3.dex */
    public interface b<R, T> extends u3a<i3a<? super R>, i3a<? super T>> {
        @Override // com.baidu.tieba.u3a
        /* synthetic */ R call(T t);
    }

    public c3a(a<T> aVar) {
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

    public static <T> c3a<T> a(a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, aVar)) == null) {
            return new c3a<>(j7a.h(aVar));
        }
        return (c3a) invokeL.objValue;
    }

    public static <T> c3a<T> e(Iterable<? extends T> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, iterable)) == null) {
            return a(new OnSubscribeFromIterable(iterable));
        }
        return (c3a) invokeL.objValue;
    }

    public static <T> c3a<T> f(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, t)) == null) {
            return ScalarSynchronousObservable.C(t);
        }
        return (c3a) invokeL.objValue;
    }

    public static <T> c3a<T> i(Iterable<? extends c3a<? extends T>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, iterable)) == null) {
            return j(e(iterable));
        }
        return (c3a) invokeL.objValue;
    }

    public static <T> c3a<T> j(c3a<? extends c3a<? extends T>> c3aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, c3aVar)) == null) {
            if (c3aVar.getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) c3aVar).F(UtilityFunctions.b());
            }
            return (c3a<T>) c3aVar.g(OperatorMerge.a(false));
        }
        return (c3a) invokeL.objValue;
    }

    public final c3a<T> b(q3a<? super T> q3aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, q3aVar)) == null) {
            return a(new b4a(this, new g5a(q3aVar, Actions.a(), Actions.a())));
        }
        return (c3a) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.baidu.tieba.u3a<? super T, ? extends com.baidu.tieba.c3a<? extends R>> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <R> c3a<R> d(u3a<? super T, ? extends c3a<? extends R>> u3aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, u3aVar)) == null) {
            if (getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) this).F(u3aVar);
            }
            return j(h(u3aVar));
        }
        return (c3a) invokeL.objValue;
    }

    public final <R> c3a<R> g(b<? extends R, ? super T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bVar)) == null) {
            return a(new c4a(this.a, bVar));
        }
        return (c3a) invokeL.objValue;
    }

    public final <R> c3a<R> h(u3a<? super T, ? extends R> u3aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, u3aVar)) == null) {
            return a(new d4a(this, u3aVar));
        }
        return (c3a) invokeL.objValue;
    }

    public final c3a<T> k(f3a f3aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, f3aVar)) == null) {
            return l(f3aVar, l5a.c);
        }
        return (c3a) invokeL.objValue;
    }

    public final a7a<T> p(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            return OperatorReplay.E(this, i);
        }
        return (a7a) invokeI.objValue;
    }

    public final j3a u(i3a<? super T> i3aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, i3aVar)) == null) {
            return v(i3aVar, this);
        }
        return (j3a) invokeL.objValue;
    }

    public final j3a w(q3a<? super T> q3aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, q3aVar)) == null) {
            if (q3aVar != null) {
                return u(new h5a(q3aVar, InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (j3a) invokeL.objValue;
    }

    public final c3a<T> y(f3a f3aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, f3aVar)) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).G(f3aVar);
            }
            return a(new m4a(this, f3aVar));
        }
        return (c3a) invokeL.objValue;
    }

    public static <T> c3a<T> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return EmptyObservableHolder.instance();
        }
        return (c3a) invokeV.objValue;
    }

    public final c3a<T> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return (c3a<T>) g(j4a.a());
        }
        return (c3a) invokeV.objValue;
    }

    public final a7a<T> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return OperatorReplay.D(this);
        }
        return (a7a) invokeV.objValue;
    }

    public final c3a<T> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return e4a.a(this);
        }
        return (c3a) invokeV.objValue;
    }

    public final j3a t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return u(new h5a(Actions.a(), InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
        }
        return (j3a) invokeV.objValue;
    }

    public static <T> j3a v(i3a<? super T> i3aVar, c3a<T> c3aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, i3aVar, c3aVar)) == null) {
            if (i3aVar != null) {
                if (c3aVar.a != null) {
                    i3aVar.d();
                    if (!(i3aVar instanceof d7a)) {
                        i3aVar = new d7a(i3aVar);
                    }
                    try {
                        j7a.p(c3aVar, c3aVar.a).call(i3aVar);
                        return j7a.o(i3aVar);
                    } catch (Throwable th) {
                        o3a.e(th);
                        if (i3aVar.isUnsubscribed()) {
                            j7a.j(j7a.m(th));
                        } else {
                            try {
                                i3aVar.onError(j7a.m(th));
                            } catch (Throwable th2) {
                                o3a.e(th2);
                                OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                                j7a.m(onErrorFailedException);
                                throw onErrorFailedException;
                            }
                        }
                        return z7a.c();
                    }
                }
                throw new IllegalStateException("onSubscribe function can not be null.");
            }
            throw new IllegalArgumentException("subscriber can not be null");
        }
        return (j3a) invokeLL.objValue;
    }

    public final c3a<T> A(long j, TimeUnit timeUnit, c3a<? extends T> c3aVar, f3a f3aVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), timeUnit, c3aVar, f3aVar})) == null) {
            return (c3a<T>) g(new n4a(j, timeUnit, c3aVar, f3aVar));
        }
        return (c3a) invokeCommon.objValue;
    }

    public final a7a<T> q(int i, long j, TimeUnit timeUnit, f3a f3aVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), timeUnit, f3aVar})) == null) {
            if (i >= 0) {
                return OperatorReplay.G(this, j, timeUnit, f3aVar, i);
            }
            throw new IllegalArgumentException("bufferSize < 0");
        }
        return (a7a) invokeCommon.objValue;
    }

    public final j3a B(i3a<? super T> i3aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i3aVar)) == null) {
            try {
                i3aVar.d();
                j7a.p(this, this.a).call(i3aVar);
                return j7a.o(i3aVar);
            } catch (Throwable th) {
                o3a.e(th);
                try {
                    i3aVar.onError(j7a.m(th));
                    return z7a.c();
                } catch (Throwable th2) {
                    o3a.e(th2);
                    OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                    j7a.m(onErrorFailedException);
                    throw onErrorFailedException;
                }
            }
        }
        return (j3a) invokeL.objValue;
    }

    public final c3a<T> l(f3a f3aVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, f3aVar, i)) == null) {
            return m(f3aVar, false, i);
        }
        return (c3a) invokeLI.objValue;
    }

    public final c3a<T> z(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048596, this, j, timeUnit)) == null) {
            return A(j, timeUnit, null, Schedulers.computation());
        }
        return (c3a) invokeJL.objValue;
    }

    public final c3a<T> m(f3a f3aVar, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{f3aVar, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).G(f3aVar);
            }
            return (c3a<T>) g(new i4a(f3aVar, z, i));
        }
        return (c3a) invokeCommon.objValue;
    }

    public final a7a<T> r(long j, TimeUnit timeUnit, f3a f3aVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j), timeUnit, f3aVar})) == null) {
            return OperatorReplay.F(this, j, timeUnit, f3aVar);
        }
        return (a7a) invokeCommon.objValue;
    }

    public final j3a x(q3a<? super T> q3aVar, q3a<Throwable> q3aVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, q3aVar, q3aVar2)) == null) {
            if (q3aVar != null) {
                if (q3aVar2 != null) {
                    return u(new h5a(q3aVar, q3aVar2, Actions.a()));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (j3a) invokeLL.objValue;
    }
}
