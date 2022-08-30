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
public class av9<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a<T> a;

    /* loaded from: classes3.dex */
    public interface a<T> extends ov9<gv9<? super T>> {
        @Override // com.baidu.tieba.ov9
        /* synthetic */ void call(T t);
    }

    /* loaded from: classes3.dex */
    public interface b<R, T> extends sv9<gv9<? super R>, gv9<? super T>> {
        @Override // com.baidu.tieba.sv9
        /* synthetic */ R call(T t);
    }

    public av9(a<T> aVar) {
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

    public static <T> av9<T> a(a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, aVar)) == null) ? new av9<>(hz9.h(aVar)) : (av9) invokeL.objValue;
    }

    public static <T> av9<T> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? EmptyObservableHolder.instance() : (av9) invokeV.objValue;
    }

    public static <T> av9<T> e(Iterable<? extends T> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, iterable)) == null) ? a(new OnSubscribeFromIterable(iterable)) : (av9) invokeL.objValue;
    }

    public static <T> av9<T> f(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, t)) == null) ? ScalarSynchronousObservable.C(t) : (av9) invokeL.objValue;
    }

    public static <T> av9<T> i(Iterable<? extends av9<? extends T>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, iterable)) == null) ? j(e(iterable)) : (av9) invokeL.objValue;
    }

    public static <T> av9<T> j(av9<? extends av9<? extends T>> av9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, av9Var)) == null) {
            if (av9Var.getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) av9Var).F(UtilityFunctions.b());
            }
            return (av9<T>) av9Var.g(OperatorMerge.a(false));
        }
        return (av9) invokeL.objValue;
    }

    public static <T> hv9 v(gv9<? super T> gv9Var, av9<T> av9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, gv9Var, av9Var)) == null) {
            if (gv9Var != null) {
                if (av9Var.a != null) {
                    gv9Var.d();
                    if (!(gv9Var instanceof bz9)) {
                        gv9Var = new bz9(gv9Var);
                    }
                    try {
                        hz9.p(av9Var, av9Var.a).call(gv9Var);
                        return hz9.o(gv9Var);
                    } catch (Throwable th) {
                        mv9.e(th);
                        if (gv9Var.isUnsubscribed()) {
                            hz9.j(hz9.m(th));
                        } else {
                            try {
                                gv9Var.onError(hz9.m(th));
                            } catch (Throwable th2) {
                                mv9.e(th2);
                                OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                                hz9.m(onErrorFailedException);
                                throw onErrorFailedException;
                            }
                        }
                        return xz9.c();
                    }
                }
                throw new IllegalStateException("onSubscribe function can not be null.");
            }
            throw new IllegalArgumentException("subscriber can not be null");
        }
        return (hv9) invokeLL.objValue;
    }

    public final av9<T> A(long j, TimeUnit timeUnit, av9<? extends T> av9Var, dv9 dv9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), timeUnit, av9Var, dv9Var})) == null) ? (av9<T>) g(new lw9(j, timeUnit, av9Var, dv9Var)) : (av9) invokeCommon.objValue;
    }

    public final hv9 B(gv9<? super T> gv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gv9Var)) == null) {
            try {
                gv9Var.d();
                hz9.p(this, this.a).call(gv9Var);
                return hz9.o(gv9Var);
            } catch (Throwable th) {
                mv9.e(th);
                try {
                    gv9Var.onError(hz9.m(th));
                    return xz9.c();
                } catch (Throwable th2) {
                    mv9.e(th2);
                    OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                    hz9.m(onErrorFailedException);
                    throw onErrorFailedException;
                }
            }
        }
        return (hv9) invokeL.objValue;
    }

    public final av9<T> b(ov9<? super T> ov9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ov9Var)) == null) ? a(new zv9(this, new ex9(ov9Var, Actions.a(), Actions.a()))) : (av9) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.baidu.tieba.sv9<? super T, ? extends com.baidu.tieba.av9<? extends R>> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <R> av9<R> d(sv9<? super T, ? extends av9<? extends R>> sv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, sv9Var)) == null) {
            if (getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) this).F(sv9Var);
            }
            return j(h(sv9Var));
        }
        return (av9) invokeL.objValue;
    }

    public final <R> av9<R> g(b<? extends R, ? super T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bVar)) == null) ? a(new aw9(this.a, bVar)) : (av9) invokeL.objValue;
    }

    public final <R> av9<R> h(sv9<? super T, ? extends R> sv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, sv9Var)) == null) ? a(new bw9(this, sv9Var)) : (av9) invokeL.objValue;
    }

    public final av9<T> k(dv9 dv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, dv9Var)) == null) ? l(dv9Var, jx9.c) : (av9) invokeL.objValue;
    }

    public final av9<T> l(dv9 dv9Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, dv9Var, i)) == null) ? m(dv9Var, false, i) : (av9) invokeLI.objValue;
    }

    public final av9<T> m(dv9 dv9Var, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{dv9Var, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).G(dv9Var);
            }
            return (av9<T>) g(new gw9(dv9Var, z, i));
        }
        return (av9) invokeCommon.objValue;
    }

    public final av9<T> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? (av9<T>) g(hw9.a()) : (av9) invokeV.objValue;
    }

    public final yy9<T> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? OperatorReplay.D(this) : (yy9) invokeV.objValue;
    }

    public final yy9<T> p(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) ? OperatorReplay.E(this, i) : (yy9) invokeI.objValue;
    }

    public final yy9<T> q(int i, long j, TimeUnit timeUnit, dv9 dv9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), timeUnit, dv9Var})) == null) {
            if (i >= 0) {
                return OperatorReplay.G(this, j, timeUnit, dv9Var, i);
            }
            throw new IllegalArgumentException("bufferSize < 0");
        }
        return (yy9) invokeCommon.objValue;
    }

    public final yy9<T> r(long j, TimeUnit timeUnit, dv9 dv9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j), timeUnit, dv9Var})) == null) ? OperatorReplay.F(this, j, timeUnit, dv9Var) : (yy9) invokeCommon.objValue;
    }

    public final av9<T> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? cw9.a(this) : (av9) invokeV.objValue;
    }

    public final hv9 t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? u(new fx9(Actions.a(), InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a())) : (hv9) invokeV.objValue;
    }

    public final hv9 u(gv9<? super T> gv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, gv9Var)) == null) ? v(gv9Var, this) : (hv9) invokeL.objValue;
    }

    public final hv9 w(ov9<? super T> ov9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, ov9Var)) == null) {
            if (ov9Var != null) {
                return u(new fx9(ov9Var, InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (hv9) invokeL.objValue;
    }

    public final hv9 x(ov9<? super T> ov9Var, ov9<Throwable> ov9Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, ov9Var, ov9Var2)) == null) {
            if (ov9Var != null) {
                if (ov9Var2 != null) {
                    return u(new fx9(ov9Var, ov9Var2, Actions.a()));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (hv9) invokeLL.objValue;
    }

    public final av9<T> y(dv9 dv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, dv9Var)) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).G(dv9Var);
            }
            return a(new kw9(this, dv9Var));
        }
        return (av9) invokeL.objValue;
    }

    public final av9<T> z(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048596, this, j, timeUnit)) == null) ? A(j, timeUnit, null, Schedulers.computation()) : (av9) invokeJL.objValue;
    }
}
