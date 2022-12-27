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
/* loaded from: classes4.dex */
public class g3a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c<T> a;

    /* loaded from: classes4.dex */
    public interface c<T> extends q3a<h3a<? super T>> {
        @Override // com.baidu.tieba.q3a
        /* synthetic */ void call(T t);
    }

    /* loaded from: classes4.dex */
    public class a extends h3a<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q3a b;
        public final /* synthetic */ q3a c;

        public a(g3a g3aVar, q3a q3aVar, q3a q3aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g3aVar, q3aVar, q3aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = q3aVar;
            this.c = q3aVar2;
        }

        @Override // com.baidu.tieba.h3a
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

        @Override // com.baidu.tieba.h3a
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

    /* loaded from: classes4.dex */
    public class b implements q3a<Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q3a a;

        public b(g3a g3aVar, q3a q3aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g3aVar, q3aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q3aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.q3a
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                this.a.call(th);
            }
        }
    }

    public g3a(c<T> cVar) {
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
        this.a = j7a.i(cVar);
    }

    public final g3a<T> h(f3a f3aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, f3aVar)) == null) {
            if (this instanceof m5a) {
                return ((m5a) this).n(f3aVar);
            }
            if (f3aVar != null) {
                return b(new t4a(this.a, f3aVar));
            }
            throw new NullPointerException("scheduler is null");
        }
        return (g3a) invokeL.objValue;
    }

    public static <T> c3a<T> a(g3a<T> g3aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, g3aVar)) == null) {
            return c3a.a(new u4a(g3aVar.a));
        }
        return (c3a) invokeL.objValue;
    }

    public static <T> g3a<T> b(c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, cVar)) == null) {
            return new g3a<>(cVar);
        }
        return (g3a) invokeL.objValue;
    }

    public static <T> g3a<T> g(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, t)) == null) {
            return m5a.m(t);
        }
        return (g3a) invokeL.objValue;
    }

    public final g3a<T> e(q3a<Throwable> q3aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, q3aVar)) == null) {
            if (q3aVar != null) {
                return b(new q4a(this, Actions.a(), new b(this, q3aVar)));
            }
            throw new IllegalArgumentException("onError is null");
        }
        return (g3a) invokeL.objValue;
    }

    public final g3a<T> f(q3a<? super T> q3aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, q3aVar)) == null) {
            if (q3aVar != null) {
                return b(new q4a(this, q3aVar, Actions.a()));
            }
            throw new IllegalArgumentException("onSuccess is null");
        }
        return (g3a) invokeL.objValue;
    }

    public final g3a<T> c(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, timeUnit)) == null) {
            return d(j, timeUnit, Schedulers.computation());
        }
        return (g3a) invokeJL.objValue;
    }

    public final j3a k(q3a<? super T> q3aVar, q3a<Throwable> q3aVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, q3aVar, q3aVar2)) == null) {
            if (q3aVar != null) {
                if (q3aVar2 != null) {
                    return j(new a(this, q3aVar2, q3aVar));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onSuccess can not be null");
        }
        return (j3a) invokeLL.objValue;
    }

    public final g3a<T> d(long j, TimeUnit timeUnit, f3a f3aVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), timeUnit, f3aVar})) == null) {
            return b(new p4a(this.a, j, timeUnit, f3aVar));
        }
        return (g3a) invokeCommon.objValue;
    }

    public final j3a i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return k(Actions.a(), Actions.b());
        }
        return (j3a) invokeV.objValue;
    }

    public final c3a<T> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return a(this);
        }
        return (c3a) invokeV.objValue;
    }

    public final j3a j(h3a<? super T> h3aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, h3aVar)) == null) {
            if (h3aVar != null) {
                try {
                    j7a.t(this, this.a).call(h3aVar);
                    return j7a.s(h3aVar);
                } catch (Throwable th) {
                    o3a.e(th);
                    try {
                        h3aVar.b(j7a.r(th));
                        return z7a.b();
                    } catch (Throwable th2) {
                        o3a.e(th2);
                        RuntimeException runtimeException = new RuntimeException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                        j7a.r(runtimeException);
                        throw runtimeException;
                    }
                }
            }
            throw new IllegalArgumentException("te is null");
        }
        return (j3a) invokeL.objValue;
    }
}
