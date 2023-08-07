package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.TimeUnit;
import rx.functions.Actions;
import rx.schedulers.Schedulers;
/* loaded from: classes5.dex */
public class b1c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c<T> a;

    /* loaded from: classes5.dex */
    public interface c<T> extends l1c<c1c<? super T>> {
        @Override // com.baidu.tieba.l1c
        /* synthetic */ void call(T t);
    }

    /* loaded from: classes5.dex */
    public class a extends c1c<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l1c b;
        public final /* synthetic */ l1c c;

        public a(b1c b1cVar, l1c l1cVar, l1c l1cVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b1cVar, l1cVar, l1cVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = l1cVar;
            this.c = l1cVar2;
        }

        @Override // com.baidu.tieba.c1c
        public final void b(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                try {
                    this.b.call(th);
                } finally {
                    unsubscribe();
                }
            }
        }

        @Override // com.baidu.tieba.c1c
        public final void c(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
                try {
                    this.c.call(t);
                } finally {
                    unsubscribe();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements l1c<Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l1c a;

        public b(b1c b1cVar, l1c l1cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b1cVar, l1cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l1cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.l1c
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                this.a.call(th);
            }
        }
    }

    public b1c(c<T> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = k5c.i(cVar);
    }

    public final b1c<T> h(a1c a1cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, a1cVar)) == null) {
            if (this instanceof n3c) {
                return ((n3c) this).n(a1cVar);
            }
            if (a1cVar != null) {
                return b(new u2c(this.a, a1cVar));
            }
            throw new NullPointerException("scheduler is null");
        }
        return (b1c) invokeL.objValue;
    }

    public static <T> x0c<T> a(b1c<T> b1cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, b1cVar)) == null) {
            return x0c.d(new v2c(b1cVar.a));
        }
        return (x0c) invokeL.objValue;
    }

    public static <T> b1c<T> b(c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, cVar)) == null) {
            return new b1c<>(cVar);
        }
        return (b1c) invokeL.objValue;
    }

    public static <T> b1c<T> g(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, t)) == null) {
            return n3c.m(t);
        }
        return (b1c) invokeL.objValue;
    }

    public final b1c<T> e(l1c<Throwable> l1cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, l1cVar)) == null) {
            if (l1cVar != null) {
                return b(new r2c(this, Actions.a(), new b(this, l1cVar)));
            }
            throw new IllegalArgumentException("onError is null");
        }
        return (b1c) invokeL.objValue;
    }

    public final b1c<T> f(l1c<? super T> l1cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, l1cVar)) == null) {
            if (l1cVar != null) {
                return b(new r2c(this, l1cVar, Actions.a()));
            }
            throw new IllegalArgumentException("onSuccess is null");
        }
        return (b1c) invokeL.objValue;
    }

    public final b1c<T> c(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, timeUnit)) == null) {
            return d(j, timeUnit, Schedulers.computation());
        }
        return (b1c) invokeJL.objValue;
    }

    public final e1c k(l1c<? super T> l1cVar, l1c<Throwable> l1cVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, l1cVar, l1cVar2)) == null) {
            if (l1cVar != null) {
                if (l1cVar2 != null) {
                    return j(new a(this, l1cVar2, l1cVar));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onSuccess can not be null");
        }
        return (e1c) invokeLL.objValue;
    }

    public final b1c<T> d(long j, TimeUnit timeUnit, a1c a1cVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), timeUnit, a1cVar})) == null) {
            return b(new q2c(this.a, j, timeUnit, a1cVar));
        }
        return (b1c) invokeCommon.objValue;
    }

    public final e1c i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return k(Actions.a(), Actions.b());
        }
        return (e1c) invokeV.objValue;
    }

    public final x0c<T> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return a(this);
        }
        return (x0c) invokeV.objValue;
    }

    public final e1c j(c1c<? super T> c1cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, c1cVar)) == null) {
            if (c1cVar != null) {
                try {
                    k5c.t(this, this.a).call(c1cVar);
                    return k5c.s(c1cVar);
                } catch (Throwable th) {
                    j1c.e(th);
                    try {
                        c1cVar.b(k5c.r(th));
                        return a6c.b();
                    } catch (Throwable th2) {
                        j1c.e(th2);
                        RuntimeException runtimeException = new RuntimeException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                        k5c.r(runtimeException);
                        throw runtimeException;
                    }
                }
            }
            throw new IllegalArgumentException("te is null");
        }
        return (e1c) invokeL.objValue;
    }
}
