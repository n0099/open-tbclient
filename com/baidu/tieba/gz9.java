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
public class gz9<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a<T> a;

    /* loaded from: classes4.dex */
    public interface a<T> extends uz9<mz9<? super T>> {
        @Override // com.baidu.tieba.uz9
        /* synthetic */ void call(T t);
    }

    /* loaded from: classes4.dex */
    public interface b<R, T> extends yz9<mz9<? super R>, mz9<? super T>> {
        @Override // com.baidu.tieba.yz9
        /* synthetic */ R call(T t);
    }

    public gz9(a<T> aVar) {
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

    public static <T> gz9<T> a(a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, aVar)) == null) {
            return new gz9<>(n3a.h(aVar));
        }
        return (gz9) invokeL.objValue;
    }

    public static <T> gz9<T> e(Iterable<? extends T> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, iterable)) == null) {
            return a(new OnSubscribeFromIterable(iterable));
        }
        return (gz9) invokeL.objValue;
    }

    public static <T> gz9<T> f(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, t)) == null) {
            return ScalarSynchronousObservable.C(t);
        }
        return (gz9) invokeL.objValue;
    }

    public static <T> gz9<T> i(Iterable<? extends gz9<? extends T>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, iterable)) == null) {
            return j(e(iterable));
        }
        return (gz9) invokeL.objValue;
    }

    public static <T> gz9<T> j(gz9<? extends gz9<? extends T>> gz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, gz9Var)) == null) {
            if (gz9Var.getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) gz9Var).F(UtilityFunctions.b());
            }
            return (gz9<T>) gz9Var.g(OperatorMerge.a(false));
        }
        return (gz9) invokeL.objValue;
    }

    public final gz9<T> b(uz9<? super T> uz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, uz9Var)) == null) {
            return a(new f0a(this, new k1a(uz9Var, Actions.a(), Actions.a())));
        }
        return (gz9) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.baidu.tieba.yz9<? super T, ? extends com.baidu.tieba.gz9<? extends R>> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <R> gz9<R> d(yz9<? super T, ? extends gz9<? extends R>> yz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, yz9Var)) == null) {
            if (getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) this).F(yz9Var);
            }
            return j(h(yz9Var));
        }
        return (gz9) invokeL.objValue;
    }

    public final <R> gz9<R> g(b<? extends R, ? super T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bVar)) == null) {
            return a(new g0a(this.a, bVar));
        }
        return (gz9) invokeL.objValue;
    }

    public final <R> gz9<R> h(yz9<? super T, ? extends R> yz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, yz9Var)) == null) {
            return a(new h0a(this, yz9Var));
        }
        return (gz9) invokeL.objValue;
    }

    public final gz9<T> k(jz9 jz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jz9Var)) == null) {
            return l(jz9Var, p1a.c);
        }
        return (gz9) invokeL.objValue;
    }

    public final e3a<T> p(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            return OperatorReplay.E(this, i);
        }
        return (e3a) invokeI.objValue;
    }

    public final nz9 u(mz9<? super T> mz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, mz9Var)) == null) {
            return v(mz9Var, this);
        }
        return (nz9) invokeL.objValue;
    }

    public final nz9 w(uz9<? super T> uz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, uz9Var)) == null) {
            if (uz9Var != null) {
                return u(new l1a(uz9Var, InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (nz9) invokeL.objValue;
    }

    public final gz9<T> y(jz9 jz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, jz9Var)) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).G(jz9Var);
            }
            return a(new q0a(this, jz9Var));
        }
        return (gz9) invokeL.objValue;
    }

    public static <T> gz9<T> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return EmptyObservableHolder.instance();
        }
        return (gz9) invokeV.objValue;
    }

    public final gz9<T> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return (gz9<T>) g(n0a.a());
        }
        return (gz9) invokeV.objValue;
    }

    public final e3a<T> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return OperatorReplay.D(this);
        }
        return (e3a) invokeV.objValue;
    }

    public final gz9<T> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return i0a.a(this);
        }
        return (gz9) invokeV.objValue;
    }

    public final nz9 t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return u(new l1a(Actions.a(), InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
        }
        return (nz9) invokeV.objValue;
    }

    public static <T> nz9 v(mz9<? super T> mz9Var, gz9<T> gz9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, mz9Var, gz9Var)) == null) {
            if (mz9Var != null) {
                if (gz9Var.a != null) {
                    mz9Var.d();
                    if (!(mz9Var instanceof h3a)) {
                        mz9Var = new h3a(mz9Var);
                    }
                    try {
                        n3a.p(gz9Var, gz9Var.a).call(mz9Var);
                        return n3a.o(mz9Var);
                    } catch (Throwable th) {
                        sz9.e(th);
                        if (mz9Var.isUnsubscribed()) {
                            n3a.j(n3a.m(th));
                        } else {
                            try {
                                mz9Var.onError(n3a.m(th));
                            } catch (Throwable th2) {
                                sz9.e(th2);
                                OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                                n3a.m(onErrorFailedException);
                                throw onErrorFailedException;
                            }
                        }
                        return d4a.c();
                    }
                }
                throw new IllegalStateException("onSubscribe function can not be null.");
            }
            throw new IllegalArgumentException("subscriber can not be null");
        }
        return (nz9) invokeLL.objValue;
    }

    public final gz9<T> A(long j, TimeUnit timeUnit, gz9<? extends T> gz9Var, jz9 jz9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), timeUnit, gz9Var, jz9Var})) == null) {
            return (gz9<T>) g(new r0a(j, timeUnit, gz9Var, jz9Var));
        }
        return (gz9) invokeCommon.objValue;
    }

    public final e3a<T> q(int i, long j, TimeUnit timeUnit, jz9 jz9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), timeUnit, jz9Var})) == null) {
            if (i >= 0) {
                return OperatorReplay.G(this, j, timeUnit, jz9Var, i);
            }
            throw new IllegalArgumentException("bufferSize < 0");
        }
        return (e3a) invokeCommon.objValue;
    }

    public final nz9 B(mz9<? super T> mz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mz9Var)) == null) {
            try {
                mz9Var.d();
                n3a.p(this, this.a).call(mz9Var);
                return n3a.o(mz9Var);
            } catch (Throwable th) {
                sz9.e(th);
                try {
                    mz9Var.onError(n3a.m(th));
                    return d4a.c();
                } catch (Throwable th2) {
                    sz9.e(th2);
                    OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                    n3a.m(onErrorFailedException);
                    throw onErrorFailedException;
                }
            }
        }
        return (nz9) invokeL.objValue;
    }

    public final gz9<T> l(jz9 jz9Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, jz9Var, i)) == null) {
            return m(jz9Var, false, i);
        }
        return (gz9) invokeLI.objValue;
    }

    public final gz9<T> z(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048596, this, j, timeUnit)) == null) {
            return A(j, timeUnit, null, Schedulers.computation());
        }
        return (gz9) invokeJL.objValue;
    }

    public final gz9<T> m(jz9 jz9Var, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{jz9Var, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).G(jz9Var);
            }
            return (gz9<T>) g(new m0a(jz9Var, z, i));
        }
        return (gz9) invokeCommon.objValue;
    }

    public final e3a<T> r(long j, TimeUnit timeUnit, jz9 jz9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j), timeUnit, jz9Var})) == null) {
            return OperatorReplay.F(this, j, timeUnit, jz9Var);
        }
        return (e3a) invokeCommon.objValue;
    }

    public final nz9 x(uz9<? super T> uz9Var, uz9<Throwable> uz9Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, uz9Var, uz9Var2)) == null) {
            if (uz9Var != null) {
                if (uz9Var2 != null) {
                    return u(new l1a(uz9Var, uz9Var2, Actions.a()));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (nz9) invokeLL.objValue;
    }
}
