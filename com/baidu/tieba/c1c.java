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
public class c1c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c<T> a;

    /* loaded from: classes5.dex */
    public interface c<T> extends m1c<d1c<? super T>> {
        @Override // com.baidu.tieba.m1c
        /* synthetic */ void call(T t);
    }

    /* loaded from: classes5.dex */
    public class a extends d1c<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m1c b;
        public final /* synthetic */ m1c c;

        public a(c1c c1cVar, m1c m1cVar, m1c m1cVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c1cVar, m1cVar, m1cVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = m1cVar;
            this.c = m1cVar2;
        }

        @Override // com.baidu.tieba.d1c
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

        @Override // com.baidu.tieba.d1c
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
    public class b implements m1c<Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m1c a;

        public b(c1c c1cVar, m1c m1cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c1cVar, m1cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m1cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.m1c
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                this.a.call(th);
            }
        }
    }

    public c1c(c<T> cVar) {
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
        this.a = l5c.i(cVar);
    }

    public final c1c<T> h(b1c b1cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, b1cVar)) == null) {
            if (this instanceof o3c) {
                return ((o3c) this).n(b1cVar);
            }
            if (b1cVar != null) {
                return b(new v2c(this.a, b1cVar));
            }
            throw new NullPointerException("scheduler is null");
        }
        return (c1c) invokeL.objValue;
    }

    public static <T> y0c<T> a(c1c<T> c1cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, c1cVar)) == null) {
            return y0c.d(new w2c(c1cVar.a));
        }
        return (y0c) invokeL.objValue;
    }

    public static <T> c1c<T> b(c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, cVar)) == null) {
            return new c1c<>(cVar);
        }
        return (c1c) invokeL.objValue;
    }

    public static <T> c1c<T> g(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, t)) == null) {
            return o3c.m(t);
        }
        return (c1c) invokeL.objValue;
    }

    public final c1c<T> e(m1c<Throwable> m1cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, m1cVar)) == null) {
            if (m1cVar != null) {
                return b(new s2c(this, Actions.a(), new b(this, m1cVar)));
            }
            throw new IllegalArgumentException("onError is null");
        }
        return (c1c) invokeL.objValue;
    }

    public final c1c<T> f(m1c<? super T> m1cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, m1cVar)) == null) {
            if (m1cVar != null) {
                return b(new s2c(this, m1cVar, Actions.a()));
            }
            throw new IllegalArgumentException("onSuccess is null");
        }
        return (c1c) invokeL.objValue;
    }

    public final c1c<T> c(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, timeUnit)) == null) {
            return d(j, timeUnit, Schedulers.computation());
        }
        return (c1c) invokeJL.objValue;
    }

    public final f1c k(m1c<? super T> m1cVar, m1c<Throwable> m1cVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, m1cVar, m1cVar2)) == null) {
            if (m1cVar != null) {
                if (m1cVar2 != null) {
                    return j(new a(this, m1cVar2, m1cVar));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onSuccess can not be null");
        }
        return (f1c) invokeLL.objValue;
    }

    public final c1c<T> d(long j, TimeUnit timeUnit, b1c b1cVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), timeUnit, b1cVar})) == null) {
            return b(new r2c(this.a, j, timeUnit, b1cVar));
        }
        return (c1c) invokeCommon.objValue;
    }

    public final f1c i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return k(Actions.a(), Actions.b());
        }
        return (f1c) invokeV.objValue;
    }

    public final y0c<T> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return a(this);
        }
        return (y0c) invokeV.objValue;
    }

    public final f1c j(d1c<? super T> d1cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, d1cVar)) == null) {
            if (d1cVar != null) {
                try {
                    l5c.t(this, this.a).call(d1cVar);
                    return l5c.s(d1cVar);
                } catch (Throwable th) {
                    k1c.e(th);
                    try {
                        d1cVar.b(l5c.r(th));
                        return b6c.b();
                    } catch (Throwable th2) {
                        k1c.e(th2);
                        RuntimeException runtimeException = new RuntimeException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                        l5c.r(runtimeException);
                        throw runtimeException;
                    }
                }
            }
            throw new IllegalArgumentException("te is null");
        }
        return (f1c) invokeL.objValue;
    }
}
