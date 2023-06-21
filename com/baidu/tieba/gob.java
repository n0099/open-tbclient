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
public class gob<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a<T> a;

    /* loaded from: classes5.dex */
    public interface a<T> extends uob<mob<? super T>> {
        @Override // com.baidu.tieba.uob
        /* synthetic */ void call(T t);
    }

    /* loaded from: classes5.dex */
    public interface b<R, T> extends yob<mob<? super R>, mob<? super T>> {
        @Override // com.baidu.tieba.yob
        /* synthetic */ R call(T t);
    }

    public gob(a<T> aVar) {
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

    public static <T> gob<T> a(a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, aVar)) == null) {
            return new gob<>(qsb.h(aVar));
        }
        return (gob) invokeL.objValue;
    }

    public static <T> gob<T> g(Iterable<? extends T> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, iterable)) == null) {
            return a(new OnSubscribeFromIterable(iterable));
        }
        return (gob) invokeL.objValue;
    }

    public static <T> gob<T> h(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, t)) == null) {
            return ScalarSynchronousObservable.G(t);
        }
        return (gob) invokeL.objValue;
    }

    public static <T> gob<T> k(Iterable<? extends gob<? extends T>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, iterable)) == null) {
            return l(g(iterable));
        }
        return (gob) invokeL.objValue;
    }

    public static <T> gob<T> l(gob<? extends gob<? extends T>> gobVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, gobVar)) == null) {
            if (gobVar.getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) gobVar).J(UtilityFunctions.b());
            }
            return (gob<T>) gobVar.i(OperatorMerge.a(false));
        }
        return (gob) invokeL.objValue;
    }

    public final gob<T> A(job jobVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jobVar)) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).K(jobVar);
            }
            return a(new tpb(this, jobVar));
        }
        return (gob) invokeL.objValue;
    }

    public final gob<T> b(zob<? super T, ? super T, Boolean> zobVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, zobVar)) == null) {
            return (gob<T>) i(new mpb(zobVar));
        }
        return (gob) invokeL.objValue;
    }

    public final gob<T> c(uob<? super T> uobVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, uobVar)) == null) {
            return a(new fpb(this, new nqb(uobVar, Actions.a(), Actions.a())));
        }
        return (gob) invokeL.objValue;
    }

    public final gob<T> e(yob<? super T, Boolean> yobVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, yobVar)) == null) {
            return a(new gpb(this, yobVar));
        }
        return (gob) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.baidu.tieba.yob<? super T, ? extends com.baidu.tieba.gob<? extends R>> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <R> gob<R> f(yob<? super T, ? extends gob<? extends R>> yobVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, yobVar)) == null) {
            if (getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) this).J(yobVar);
            }
            return l(j(yobVar));
        }
        return (gob) invokeL.objValue;
    }

    public final <R> gob<R> i(b<? extends R, ? super T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar)) == null) {
            return a(new hpb(this.a, bVar));
        }
        return (gob) invokeL.objValue;
    }

    public final <R> gob<R> j(yob<? super T, ? extends R> yobVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, yobVar)) == null) {
            return a(new ipb(this, yobVar));
        }
        return (gob) invokeL.objValue;
    }

    public final gob<T> m(job jobVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, jobVar)) == null) {
            return n(jobVar, sqb.c);
        }
        return (gob) invokeL.objValue;
    }

    public final hsb<T> r(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i)) == null) {
            return OperatorReplay.I(this, i);
        }
        return (hsb) invokeI.objValue;
    }

    public final nob w(mob<? super T> mobVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, mobVar)) == null) {
            return x(mobVar, this);
        }
        return (nob) invokeL.objValue;
    }

    public final nob y(uob<? super T> uobVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, uobVar)) == null) {
            if (uobVar != null) {
                return w(new oqb(uobVar, InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (nob) invokeL.objValue;
    }

    public static gob<Long> D(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65537, null, j, timeUnit)) == null) {
            return E(j, timeUnit, Schedulers.computation());
        }
        return (gob) invokeJL.objValue;
    }

    public final gob<T> B(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j, timeUnit)) == null) {
            return C(j, timeUnit, null, Schedulers.computation());
        }
        return (gob) invokeJL.objValue;
    }

    public final gob<T> n(job jobVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048587, this, jobVar, i)) == null) {
            return o(jobVar, false, i);
        }
        return (gob) invokeLI.objValue;
    }

    public static gob<Long> E(long j, TimeUnit timeUnit, job jobVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Long.valueOf(j), timeUnit, jobVar})) == null) {
            return a(new kpb(j, timeUnit, jobVar));
        }
        return (gob) invokeCommon.objValue;
    }

    public final hsb<T> t(long j, TimeUnit timeUnit, job jobVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{Long.valueOf(j), timeUnit, jobVar})) == null) {
            return OperatorReplay.J(this, j, timeUnit, jobVar);
        }
        return (hsb) invokeCommon.objValue;
    }

    public static <T> gob<T> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return EmptyObservableHolder.instance();
        }
        return (gob) invokeV.objValue;
    }

    public final gob<T> p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return (gob<T>) i(qpb.a());
        }
        return (gob) invokeV.objValue;
    }

    public final hsb<T> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return OperatorReplay.H(this);
        }
        return (hsb) invokeV.objValue;
    }

    public final gob<T> u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return jpb.a(this);
        }
        return (gob) invokeV.objValue;
    }

    public final nob v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return w(new oqb(Actions.a(), InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
        }
        return (nob) invokeV.objValue;
    }

    public static <T> nob x(mob<? super T> mobVar, gob<T> gobVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, mobVar, gobVar)) == null) {
            if (mobVar != null) {
                if (gobVar.a != null) {
                    mobVar.d();
                    if (!(mobVar instanceof ksb)) {
                        mobVar = new ksb(mobVar);
                    }
                    try {
                        qsb.p(gobVar, gobVar.a).call(mobVar);
                        return qsb.o(mobVar);
                    } catch (Throwable th) {
                        sob.e(th);
                        if (mobVar.isUnsubscribed()) {
                            qsb.j(qsb.m(th));
                        } else {
                            try {
                                mobVar.onError(qsb.m(th));
                            } catch (Throwable th2) {
                                sob.e(th2);
                                OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                                qsb.m(onErrorFailedException);
                                throw onErrorFailedException;
                            }
                        }
                        return gtb.c();
                    }
                }
                throw new IllegalStateException("onSubscribe function can not be null.");
            }
            throw new IllegalArgumentException("subscriber can not be null");
        }
        return (nob) invokeLL.objValue;
    }

    public final gob<T> C(long j, TimeUnit timeUnit, gob<? extends T> gobVar, job jobVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), timeUnit, gobVar, jobVar})) == null) {
            return (gob<T>) i(new upb(j, timeUnit, gobVar, jobVar));
        }
        return (gob) invokeCommon.objValue;
    }

    public final hsb<T> s(int i, long j, TimeUnit timeUnit, job jobVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), timeUnit, jobVar})) == null) {
            if (i >= 0) {
                return OperatorReplay.K(this, j, timeUnit, jobVar, i);
            }
            throw new IllegalArgumentException("bufferSize < 0");
        }
        return (hsb) invokeCommon.objValue;
    }

    public final nob F(mob<? super T> mobVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, mobVar)) == null) {
            try {
                mobVar.d();
                qsb.p(this, this.a).call(mobVar);
                return qsb.o(mobVar);
            } catch (Throwable th) {
                sob.e(th);
                try {
                    mobVar.onError(qsb.m(th));
                    return gtb.c();
                } catch (Throwable th2) {
                    sob.e(th2);
                    OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                    qsb.m(onErrorFailedException);
                    throw onErrorFailedException;
                }
            }
        }
        return (nob) invokeL.objValue;
    }

    public final gob<T> o(job jobVar, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{jobVar, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).K(jobVar);
            }
            return (gob<T>) i(new ppb(jobVar, z, i));
        }
        return (gob) invokeCommon.objValue;
    }

    public final nob z(uob<? super T> uobVar, uob<Throwable> uobVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048598, this, uobVar, uobVar2)) == null) {
            if (uobVar != null) {
                if (uobVar2 != null) {
                    return w(new oqb(uobVar, uobVar2, Actions.a()));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (nob) invokeLL.objValue;
    }
}
