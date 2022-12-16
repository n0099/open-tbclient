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
public class f3a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c<T> a;

    /* loaded from: classes4.dex */
    public interface c<T> extends p3a<g3a<? super T>> {
        @Override // com.baidu.tieba.p3a
        /* synthetic */ void call(T t);
    }

    /* loaded from: classes4.dex */
    public class a extends g3a<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p3a b;
        public final /* synthetic */ p3a c;

        public a(f3a f3aVar, p3a p3aVar, p3a p3aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f3aVar, p3aVar, p3aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = p3aVar;
            this.c = p3aVar2;
        }

        @Override // com.baidu.tieba.g3a
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

        @Override // com.baidu.tieba.g3a
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
    public class b implements p3a<Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p3a a;

        public b(f3a f3aVar, p3a p3aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f3aVar, p3aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p3aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.p3a
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                this.a.call(th);
            }
        }
    }

    public f3a(c<T> cVar) {
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
        this.a = i7a.i(cVar);
    }

    public final f3a<T> h(e3a e3aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, e3aVar)) == null) {
            if (this instanceof l5a) {
                return ((l5a) this).n(e3aVar);
            }
            if (e3aVar != null) {
                return b(new s4a(this.a, e3aVar));
            }
            throw new NullPointerException("scheduler is null");
        }
        return (f3a) invokeL.objValue;
    }

    public static <T> b3a<T> a(f3a<T> f3aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, f3aVar)) == null) {
            return b3a.a(new t4a(f3aVar.a));
        }
        return (b3a) invokeL.objValue;
    }

    public static <T> f3a<T> b(c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, cVar)) == null) {
            return new f3a<>(cVar);
        }
        return (f3a) invokeL.objValue;
    }

    public static <T> f3a<T> g(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, t)) == null) {
            return l5a.m(t);
        }
        return (f3a) invokeL.objValue;
    }

    public final f3a<T> e(p3a<Throwable> p3aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, p3aVar)) == null) {
            if (p3aVar != null) {
                return b(new p4a(this, Actions.a(), new b(this, p3aVar)));
            }
            throw new IllegalArgumentException("onError is null");
        }
        return (f3a) invokeL.objValue;
    }

    public final f3a<T> f(p3a<? super T> p3aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, p3aVar)) == null) {
            if (p3aVar != null) {
                return b(new p4a(this, p3aVar, Actions.a()));
            }
            throw new IllegalArgumentException("onSuccess is null");
        }
        return (f3a) invokeL.objValue;
    }

    public final f3a<T> c(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, timeUnit)) == null) {
            return d(j, timeUnit, Schedulers.computation());
        }
        return (f3a) invokeJL.objValue;
    }

    public final i3a k(p3a<? super T> p3aVar, p3a<Throwable> p3aVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, p3aVar, p3aVar2)) == null) {
            if (p3aVar != null) {
                if (p3aVar2 != null) {
                    return j(new a(this, p3aVar2, p3aVar));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onSuccess can not be null");
        }
        return (i3a) invokeLL.objValue;
    }

    public final f3a<T> d(long j, TimeUnit timeUnit, e3a e3aVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), timeUnit, e3aVar})) == null) {
            return b(new o4a(this.a, j, timeUnit, e3aVar));
        }
        return (f3a) invokeCommon.objValue;
    }

    public final i3a i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return k(Actions.a(), Actions.b());
        }
        return (i3a) invokeV.objValue;
    }

    public final b3a<T> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return a(this);
        }
        return (b3a) invokeV.objValue;
    }

    public final i3a j(g3a<? super T> g3aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, g3aVar)) == null) {
            if (g3aVar != null) {
                try {
                    i7a.t(this, this.a).call(g3aVar);
                    return i7a.s(g3aVar);
                } catch (Throwable th) {
                    n3a.e(th);
                    try {
                        g3aVar.b(i7a.r(th));
                        return y7a.b();
                    } catch (Throwable th2) {
                        n3a.e(th2);
                        RuntimeException runtimeException = new RuntimeException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                        i7a.r(runtimeException);
                        throw runtimeException;
                    }
                }
            }
            throw new IllegalArgumentException("te is null");
        }
        return (i3a) invokeL.objValue;
    }
}
