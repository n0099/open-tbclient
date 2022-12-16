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
public class b3a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a<T> a;

    /* loaded from: classes3.dex */
    public interface a<T> extends p3a<h3a<? super T>> {
        @Override // com.baidu.tieba.p3a
        /* synthetic */ void call(T t);
    }

    /* loaded from: classes3.dex */
    public interface b<R, T> extends t3a<h3a<? super R>, h3a<? super T>> {
        @Override // com.baidu.tieba.t3a
        /* synthetic */ R call(T t);
    }

    public b3a(a<T> aVar) {
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

    public static <T> b3a<T> a(a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, aVar)) == null) {
            return new b3a<>(i7a.h(aVar));
        }
        return (b3a) invokeL.objValue;
    }

    public static <T> b3a<T> e(Iterable<? extends T> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, iterable)) == null) {
            return a(new OnSubscribeFromIterable(iterable));
        }
        return (b3a) invokeL.objValue;
    }

    public static <T> b3a<T> f(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, t)) == null) {
            return ScalarSynchronousObservable.C(t);
        }
        return (b3a) invokeL.objValue;
    }

    public static <T> b3a<T> i(Iterable<? extends b3a<? extends T>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, iterable)) == null) {
            return j(e(iterable));
        }
        return (b3a) invokeL.objValue;
    }

    public static <T> b3a<T> j(b3a<? extends b3a<? extends T>> b3aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, b3aVar)) == null) {
            if (b3aVar.getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) b3aVar).F(UtilityFunctions.b());
            }
            return (b3a<T>) b3aVar.g(OperatorMerge.a(false));
        }
        return (b3a) invokeL.objValue;
    }

    public final b3a<T> b(p3a<? super T> p3aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, p3aVar)) == null) {
            return a(new a4a(this, new f5a(p3aVar, Actions.a(), Actions.a())));
        }
        return (b3a) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.baidu.tieba.t3a<? super T, ? extends com.baidu.tieba.b3a<? extends R>> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <R> b3a<R> d(t3a<? super T, ? extends b3a<? extends R>> t3aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, t3aVar)) == null) {
            if (getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) this).F(t3aVar);
            }
            return j(h(t3aVar));
        }
        return (b3a) invokeL.objValue;
    }

    public final <R> b3a<R> g(b<? extends R, ? super T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bVar)) == null) {
            return a(new b4a(this.a, bVar));
        }
        return (b3a) invokeL.objValue;
    }

    public final <R> b3a<R> h(t3a<? super T, ? extends R> t3aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, t3aVar)) == null) {
            return a(new c4a(this, t3aVar));
        }
        return (b3a) invokeL.objValue;
    }

    public final b3a<T> k(e3a e3aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, e3aVar)) == null) {
            return l(e3aVar, k5a.c);
        }
        return (b3a) invokeL.objValue;
    }

    public final z6a<T> p(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            return OperatorReplay.E(this, i);
        }
        return (z6a) invokeI.objValue;
    }

    public final i3a u(h3a<? super T> h3aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, h3aVar)) == null) {
            return v(h3aVar, this);
        }
        return (i3a) invokeL.objValue;
    }

    public final i3a w(p3a<? super T> p3aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, p3aVar)) == null) {
            if (p3aVar != null) {
                return u(new g5a(p3aVar, InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (i3a) invokeL.objValue;
    }

    public final b3a<T> y(e3a e3aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, e3aVar)) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).G(e3aVar);
            }
            return a(new l4a(this, e3aVar));
        }
        return (b3a) invokeL.objValue;
    }

    public static <T> b3a<T> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return EmptyObservableHolder.instance();
        }
        return (b3a) invokeV.objValue;
    }

    public final b3a<T> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return (b3a<T>) g(i4a.a());
        }
        return (b3a) invokeV.objValue;
    }

    public final z6a<T> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return OperatorReplay.D(this);
        }
        return (z6a) invokeV.objValue;
    }

    public final b3a<T> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return d4a.a(this);
        }
        return (b3a) invokeV.objValue;
    }

    public final i3a t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return u(new g5a(Actions.a(), InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
        }
        return (i3a) invokeV.objValue;
    }

    public static <T> i3a v(h3a<? super T> h3aVar, b3a<T> b3aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, h3aVar, b3aVar)) == null) {
            if (h3aVar != null) {
                if (b3aVar.a != null) {
                    h3aVar.d();
                    if (!(h3aVar instanceof c7a)) {
                        h3aVar = new c7a(h3aVar);
                    }
                    try {
                        i7a.p(b3aVar, b3aVar.a).call(h3aVar);
                        return i7a.o(h3aVar);
                    } catch (Throwable th) {
                        n3a.e(th);
                        if (h3aVar.isUnsubscribed()) {
                            i7a.j(i7a.m(th));
                        } else {
                            try {
                                h3aVar.onError(i7a.m(th));
                            } catch (Throwable th2) {
                                n3a.e(th2);
                                OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                                i7a.m(onErrorFailedException);
                                throw onErrorFailedException;
                            }
                        }
                        return y7a.c();
                    }
                }
                throw new IllegalStateException("onSubscribe function can not be null.");
            }
            throw new IllegalArgumentException("subscriber can not be null");
        }
        return (i3a) invokeLL.objValue;
    }

    public final b3a<T> A(long j, TimeUnit timeUnit, b3a<? extends T> b3aVar, e3a e3aVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), timeUnit, b3aVar, e3aVar})) == null) {
            return (b3a<T>) g(new m4a(j, timeUnit, b3aVar, e3aVar));
        }
        return (b3a) invokeCommon.objValue;
    }

    public final z6a<T> q(int i, long j, TimeUnit timeUnit, e3a e3aVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), timeUnit, e3aVar})) == null) {
            if (i >= 0) {
                return OperatorReplay.G(this, j, timeUnit, e3aVar, i);
            }
            throw new IllegalArgumentException("bufferSize < 0");
        }
        return (z6a) invokeCommon.objValue;
    }

    public final i3a B(h3a<? super T> h3aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, h3aVar)) == null) {
            try {
                h3aVar.d();
                i7a.p(this, this.a).call(h3aVar);
                return i7a.o(h3aVar);
            } catch (Throwable th) {
                n3a.e(th);
                try {
                    h3aVar.onError(i7a.m(th));
                    return y7a.c();
                } catch (Throwable th2) {
                    n3a.e(th2);
                    OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                    i7a.m(onErrorFailedException);
                    throw onErrorFailedException;
                }
            }
        }
        return (i3a) invokeL.objValue;
    }

    public final b3a<T> l(e3a e3aVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, e3aVar, i)) == null) {
            return m(e3aVar, false, i);
        }
        return (b3a) invokeLI.objValue;
    }

    public final b3a<T> z(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048596, this, j, timeUnit)) == null) {
            return A(j, timeUnit, null, Schedulers.computation());
        }
        return (b3a) invokeJL.objValue;
    }

    public final b3a<T> m(e3a e3aVar, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{e3aVar, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).G(e3aVar);
            }
            return (b3a<T>) g(new h4a(e3aVar, z, i));
        }
        return (b3a) invokeCommon.objValue;
    }

    public final z6a<T> r(long j, TimeUnit timeUnit, e3a e3aVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j), timeUnit, e3aVar})) == null) {
            return OperatorReplay.F(this, j, timeUnit, e3aVar);
        }
        return (z6a) invokeCommon.objValue;
    }

    public final i3a x(p3a<? super T> p3aVar, p3a<Throwable> p3aVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, p3aVar, p3aVar2)) == null) {
            if (p3aVar != null) {
                if (p3aVar2 != null) {
                    return u(new g5a(p3aVar, p3aVar2, Actions.a()));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (i3a) invokeLL.objValue;
    }
}
