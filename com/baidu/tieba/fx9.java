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
public class fx9<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a<T> a;

    /* loaded from: classes4.dex */
    public interface a<T> extends tx9<lx9<? super T>> {
        @Override // com.baidu.tieba.tx9
        /* synthetic */ void call(T t);
    }

    /* loaded from: classes4.dex */
    public interface b<R, T> extends xx9<lx9<? super R>, lx9<? super T>> {
        @Override // com.baidu.tieba.xx9
        /* synthetic */ R call(T t);
    }

    public fx9(a<T> aVar) {
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

    public static <T> fx9<T> a(a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, aVar)) == null) ? new fx9<>(m1a.h(aVar)) : (fx9) invokeL.objValue;
    }

    public static <T> fx9<T> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? EmptyObservableHolder.instance() : (fx9) invokeV.objValue;
    }

    public static <T> fx9<T> e(Iterable<? extends T> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, iterable)) == null) ? a(new OnSubscribeFromIterable(iterable)) : (fx9) invokeL.objValue;
    }

    public static <T> fx9<T> f(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, t)) == null) ? ScalarSynchronousObservable.C(t) : (fx9) invokeL.objValue;
    }

    public static <T> fx9<T> i(Iterable<? extends fx9<? extends T>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, iterable)) == null) ? j(e(iterable)) : (fx9) invokeL.objValue;
    }

    public static <T> fx9<T> j(fx9<? extends fx9<? extends T>> fx9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, fx9Var)) == null) {
            if (fx9Var.getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) fx9Var).F(UtilityFunctions.b());
            }
            return (fx9<T>) fx9Var.g(OperatorMerge.a(false));
        }
        return (fx9) invokeL.objValue;
    }

    public static <T> mx9 v(lx9<? super T> lx9Var, fx9<T> fx9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, lx9Var, fx9Var)) == null) {
            if (lx9Var != null) {
                if (fx9Var.a != null) {
                    lx9Var.d();
                    if (!(lx9Var instanceof g1a)) {
                        lx9Var = new g1a(lx9Var);
                    }
                    try {
                        m1a.p(fx9Var, fx9Var.a).call(lx9Var);
                        return m1a.o(lx9Var);
                    } catch (Throwable th) {
                        rx9.e(th);
                        if (lx9Var.isUnsubscribed()) {
                            m1a.j(m1a.m(th));
                        } else {
                            try {
                                lx9Var.onError(m1a.m(th));
                            } catch (Throwable th2) {
                                rx9.e(th2);
                                OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                                m1a.m(onErrorFailedException);
                                throw onErrorFailedException;
                            }
                        }
                        return c2a.c();
                    }
                }
                throw new IllegalStateException("onSubscribe function can not be null.");
            }
            throw new IllegalArgumentException("subscriber can not be null");
        }
        return (mx9) invokeLL.objValue;
    }

    public final fx9<T> A(long j, TimeUnit timeUnit, fx9<? extends T> fx9Var, ix9 ix9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), timeUnit, fx9Var, ix9Var})) == null) ? (fx9<T>) g(new qy9(j, timeUnit, fx9Var, ix9Var)) : (fx9) invokeCommon.objValue;
    }

    public final mx9 B(lx9<? super T> lx9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lx9Var)) == null) {
            try {
                lx9Var.d();
                m1a.p(this, this.a).call(lx9Var);
                return m1a.o(lx9Var);
            } catch (Throwable th) {
                rx9.e(th);
                try {
                    lx9Var.onError(m1a.m(th));
                    return c2a.c();
                } catch (Throwable th2) {
                    rx9.e(th2);
                    OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                    m1a.m(onErrorFailedException);
                    throw onErrorFailedException;
                }
            }
        }
        return (mx9) invokeL.objValue;
    }

    public final fx9<T> b(tx9<? super T> tx9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tx9Var)) == null) ? a(new ey9(this, new jz9(tx9Var, Actions.a(), Actions.a()))) : (fx9) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.baidu.tieba.xx9<? super T, ? extends com.baidu.tieba.fx9<? extends R>> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <R> fx9<R> d(xx9<? super T, ? extends fx9<? extends R>> xx9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, xx9Var)) == null) {
            if (getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) this).F(xx9Var);
            }
            return j(h(xx9Var));
        }
        return (fx9) invokeL.objValue;
    }

    public final <R> fx9<R> g(b<? extends R, ? super T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bVar)) == null) ? a(new fy9(this.a, bVar)) : (fx9) invokeL.objValue;
    }

    public final <R> fx9<R> h(xx9<? super T, ? extends R> xx9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, xx9Var)) == null) ? a(new gy9(this, xx9Var)) : (fx9) invokeL.objValue;
    }

    public final fx9<T> k(ix9 ix9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, ix9Var)) == null) ? l(ix9Var, oz9.c) : (fx9) invokeL.objValue;
    }

    public final fx9<T> l(ix9 ix9Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, ix9Var, i)) == null) ? m(ix9Var, false, i) : (fx9) invokeLI.objValue;
    }

    public final fx9<T> m(ix9 ix9Var, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{ix9Var, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).G(ix9Var);
            }
            return (fx9<T>) g(new ly9(ix9Var, z, i));
        }
        return (fx9) invokeCommon.objValue;
    }

    public final fx9<T> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? (fx9<T>) g(my9.a()) : (fx9) invokeV.objValue;
    }

    public final d1a<T> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? OperatorReplay.D(this) : (d1a) invokeV.objValue;
    }

    public final d1a<T> p(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) ? OperatorReplay.E(this, i) : (d1a) invokeI.objValue;
    }

    public final d1a<T> q(int i, long j, TimeUnit timeUnit, ix9 ix9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), timeUnit, ix9Var})) == null) {
            if (i >= 0) {
                return OperatorReplay.G(this, j, timeUnit, ix9Var, i);
            }
            throw new IllegalArgumentException("bufferSize < 0");
        }
        return (d1a) invokeCommon.objValue;
    }

    public final d1a<T> r(long j, TimeUnit timeUnit, ix9 ix9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j), timeUnit, ix9Var})) == null) ? OperatorReplay.F(this, j, timeUnit, ix9Var) : (d1a) invokeCommon.objValue;
    }

    public final fx9<T> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? hy9.a(this) : (fx9) invokeV.objValue;
    }

    public final mx9 t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? u(new kz9(Actions.a(), InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a())) : (mx9) invokeV.objValue;
    }

    public final mx9 u(lx9<? super T> lx9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, lx9Var)) == null) ? v(lx9Var, this) : (mx9) invokeL.objValue;
    }

    public final mx9 w(tx9<? super T> tx9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, tx9Var)) == null) {
            if (tx9Var != null) {
                return u(new kz9(tx9Var, InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (mx9) invokeL.objValue;
    }

    public final mx9 x(tx9<? super T> tx9Var, tx9<Throwable> tx9Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, tx9Var, tx9Var2)) == null) {
            if (tx9Var != null) {
                if (tx9Var2 != null) {
                    return u(new kz9(tx9Var, tx9Var2, Actions.a()));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (mx9) invokeLL.objValue;
    }

    public final fx9<T> y(ix9 ix9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, ix9Var)) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).G(ix9Var);
            }
            return a(new py9(this, ix9Var));
        }
        return (fx9) invokeL.objValue;
    }

    public final fx9<T> z(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048596, this, j, timeUnit)) == null) ? A(j, timeUnit, null, Schedulers.computation()) : (fx9) invokeJL.objValue;
    }
}
