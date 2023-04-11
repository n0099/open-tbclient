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
/* loaded from: classes4.dex */
public class f1b<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a<T> a;

    /* loaded from: classes4.dex */
    public interface a<T> extends t1b<l1b<? super T>> {
        @Override // com.baidu.tieba.t1b
        /* synthetic */ void call(T t);
    }

    /* loaded from: classes4.dex */
    public interface b<R, T> extends x1b<l1b<? super R>, l1b<? super T>> {
        @Override // com.baidu.tieba.x1b
        /* synthetic */ R call(T t);
    }

    public f1b(a<T> aVar) {
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

    public static <T> f1b<T> a(a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, aVar)) == null) {
            return new f1b<>(m5b.h(aVar));
        }
        return (f1b) invokeL.objValue;
    }

    public static <T> f1b<T> e(Iterable<? extends T> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, iterable)) == null) {
            return a(new OnSubscribeFromIterable(iterable));
        }
        return (f1b) invokeL.objValue;
    }

    public static <T> f1b<T> f(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, t)) == null) {
            return ScalarSynchronousObservable.C(t);
        }
        return (f1b) invokeL.objValue;
    }

    public static <T> f1b<T> i(Iterable<? extends f1b<? extends T>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, iterable)) == null) {
            return j(e(iterable));
        }
        return (f1b) invokeL.objValue;
    }

    public static <T> f1b<T> j(f1b<? extends f1b<? extends T>> f1bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, f1bVar)) == null) {
            if (f1bVar.getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) f1bVar).F(UtilityFunctions.b());
            }
            return (f1b<T>) f1bVar.g(OperatorMerge.a(false));
        }
        return (f1b) invokeL.objValue;
    }

    public final f1b<T> b(t1b<? super T> t1bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t1bVar)) == null) {
            return a(new e2b(this, new j3b(t1bVar, Actions.a(), Actions.a())));
        }
        return (f1b) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.baidu.tieba.x1b<? super T, ? extends com.baidu.tieba.f1b<? extends R>> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <R> f1b<R> d(x1b<? super T, ? extends f1b<? extends R>> x1bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, x1bVar)) == null) {
            if (getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) this).F(x1bVar);
            }
            return j(h(x1bVar));
        }
        return (f1b) invokeL.objValue;
    }

    public final <R> f1b<R> g(b<? extends R, ? super T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bVar)) == null) {
            return a(new f2b(this.a, bVar));
        }
        return (f1b) invokeL.objValue;
    }

    public final <R> f1b<R> h(x1b<? super T, ? extends R> x1bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, x1bVar)) == null) {
            return a(new g2b(this, x1bVar));
        }
        return (f1b) invokeL.objValue;
    }

    public final f1b<T> k(i1b i1bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, i1bVar)) == null) {
            return l(i1bVar, o3b.c);
        }
        return (f1b) invokeL.objValue;
    }

    public final d5b<T> p(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            return OperatorReplay.E(this, i);
        }
        return (d5b) invokeI.objValue;
    }

    public final m1b u(l1b<? super T> l1bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, l1bVar)) == null) {
            return v(l1bVar, this);
        }
        return (m1b) invokeL.objValue;
    }

    public final m1b w(t1b<? super T> t1bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, t1bVar)) == null) {
            if (t1bVar != null) {
                return u(new k3b(t1bVar, InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (m1b) invokeL.objValue;
    }

    public final f1b<T> y(i1b i1bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, i1bVar)) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).G(i1bVar);
            }
            return a(new p2b(this, i1bVar));
        }
        return (f1b) invokeL.objValue;
    }

    public static <T> f1b<T> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return EmptyObservableHolder.instance();
        }
        return (f1b) invokeV.objValue;
    }

    public final f1b<T> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return (f1b<T>) g(m2b.a());
        }
        return (f1b) invokeV.objValue;
    }

    public final d5b<T> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return OperatorReplay.D(this);
        }
        return (d5b) invokeV.objValue;
    }

    public final f1b<T> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return h2b.a(this);
        }
        return (f1b) invokeV.objValue;
    }

    public final m1b t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return u(new k3b(Actions.a(), InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
        }
        return (m1b) invokeV.objValue;
    }

    public static <T> m1b v(l1b<? super T> l1bVar, f1b<T> f1bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, l1bVar, f1bVar)) == null) {
            if (l1bVar != null) {
                if (f1bVar.a != null) {
                    l1bVar.d();
                    if (!(l1bVar instanceof g5b)) {
                        l1bVar = new g5b(l1bVar);
                    }
                    try {
                        m5b.p(f1bVar, f1bVar.a).call(l1bVar);
                        return m5b.o(l1bVar);
                    } catch (Throwable th) {
                        r1b.e(th);
                        if (l1bVar.isUnsubscribed()) {
                            m5b.j(m5b.m(th));
                        } else {
                            try {
                                l1bVar.onError(m5b.m(th));
                            } catch (Throwable th2) {
                                r1b.e(th2);
                                OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                                m5b.m(onErrorFailedException);
                                throw onErrorFailedException;
                            }
                        }
                        return c6b.c();
                    }
                }
                throw new IllegalStateException("onSubscribe function can not be null.");
            }
            throw new IllegalArgumentException("subscriber can not be null");
        }
        return (m1b) invokeLL.objValue;
    }

    public final f1b<T> A(long j, TimeUnit timeUnit, f1b<? extends T> f1bVar, i1b i1bVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), timeUnit, f1bVar, i1bVar})) == null) {
            return (f1b<T>) g(new q2b(j, timeUnit, f1bVar, i1bVar));
        }
        return (f1b) invokeCommon.objValue;
    }

    public final d5b<T> q(int i, long j, TimeUnit timeUnit, i1b i1bVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), timeUnit, i1bVar})) == null) {
            if (i >= 0) {
                return OperatorReplay.G(this, j, timeUnit, i1bVar, i);
            }
            throw new IllegalArgumentException("bufferSize < 0");
        }
        return (d5b) invokeCommon.objValue;
    }

    public final m1b B(l1b<? super T> l1bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l1bVar)) == null) {
            try {
                l1bVar.d();
                m5b.p(this, this.a).call(l1bVar);
                return m5b.o(l1bVar);
            } catch (Throwable th) {
                r1b.e(th);
                try {
                    l1bVar.onError(m5b.m(th));
                    return c6b.c();
                } catch (Throwable th2) {
                    r1b.e(th2);
                    OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                    m5b.m(onErrorFailedException);
                    throw onErrorFailedException;
                }
            }
        }
        return (m1b) invokeL.objValue;
    }

    public final f1b<T> l(i1b i1bVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, i1bVar, i)) == null) {
            return m(i1bVar, false, i);
        }
        return (f1b) invokeLI.objValue;
    }

    public final f1b<T> z(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048596, this, j, timeUnit)) == null) {
            return A(j, timeUnit, null, Schedulers.computation());
        }
        return (f1b) invokeJL.objValue;
    }

    public final f1b<T> m(i1b i1bVar, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{i1bVar, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).G(i1bVar);
            }
            return (f1b<T>) g(new l2b(i1bVar, z, i));
        }
        return (f1b) invokeCommon.objValue;
    }

    public final d5b<T> r(long j, TimeUnit timeUnit, i1b i1bVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j), timeUnit, i1bVar})) == null) {
            return OperatorReplay.F(this, j, timeUnit, i1bVar);
        }
        return (d5b) invokeCommon.objValue;
    }

    public final m1b x(t1b<? super T> t1bVar, t1b<Throwable> t1bVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, t1bVar, t1bVar2)) == null) {
            if (t1bVar != null) {
                if (t1bVar2 != null) {
                    return u(new k3b(t1bVar, t1bVar2, Actions.a()));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (m1b) invokeLL.objValue;
    }
}
