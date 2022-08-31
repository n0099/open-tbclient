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
/* loaded from: classes3.dex */
public class cv9<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c<T> a;

    /* loaded from: classes3.dex */
    public class a extends dv9<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mv9 b;
        public final /* synthetic */ mv9 c;

        public a(cv9 cv9Var, mv9 mv9Var, mv9 mv9Var2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cv9Var, mv9Var, mv9Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = mv9Var;
            this.c = mv9Var2;
        }

        @Override // com.baidu.tieba.dv9
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

        @Override // com.baidu.tieba.dv9
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

    /* loaded from: classes3.dex */
    public class b implements mv9<Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mv9 a;

        public b(cv9 cv9Var, mv9 mv9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cv9Var, mv9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mv9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mv9
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                this.a.call(th);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface c<T> extends mv9<dv9<? super T>> {
        @Override // com.baidu.tieba.mv9
        /* synthetic */ void call(T t);
    }

    public cv9(c<T> cVar) {
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
        this.a = fz9.i(cVar);
    }

    public static <T> yu9<T> a(cv9<T> cv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, cv9Var)) == null) ? yu9.a(new qw9(cv9Var.a)) : (yu9) invokeL.objValue;
    }

    public static <T> cv9<T> b(c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, cVar)) == null) ? new cv9<>(cVar) : (cv9) invokeL.objValue;
    }

    public static <T> cv9<T> g(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, t)) == null) ? ix9.m(t) : (cv9) invokeL.objValue;
    }

    public final cv9<T> c(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, timeUnit)) == null) ? d(j, timeUnit, Schedulers.computation()) : (cv9) invokeJL.objValue;
    }

    public final cv9<T> d(long j, TimeUnit timeUnit, bv9 bv9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), timeUnit, bv9Var})) == null) ? b(new lw9(this.a, j, timeUnit, bv9Var)) : (cv9) invokeCommon.objValue;
    }

    public final cv9<T> e(mv9<Throwable> mv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mv9Var)) == null) {
            if (mv9Var != null) {
                return b(new mw9(this, Actions.a(), new b(this, mv9Var)));
            }
            throw new IllegalArgumentException("onError is null");
        }
        return (cv9) invokeL.objValue;
    }

    public final cv9<T> f(mv9<? super T> mv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, mv9Var)) == null) {
            if (mv9Var != null) {
                return b(new mw9(this, mv9Var, Actions.a()));
            }
            throw new IllegalArgumentException("onSuccess is null");
        }
        return (cv9) invokeL.objValue;
    }

    public final cv9<T> h(bv9 bv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bv9Var)) == null) {
            if (this instanceof ix9) {
                return ((ix9) this).n(bv9Var);
            }
            if (bv9Var != null) {
                return b(new pw9(this.a, bv9Var));
            }
            throw new NullPointerException("scheduler is null");
        }
        return (cv9) invokeL.objValue;
    }

    public final fv9 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? k(Actions.a(), Actions.b()) : (fv9) invokeV.objValue;
    }

    public final fv9 j(dv9<? super T> dv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, dv9Var)) == null) {
            if (dv9Var != null) {
                try {
                    fz9.t(this, this.a).call(dv9Var);
                    return fz9.s(dv9Var);
                } catch (Throwable th) {
                    kv9.e(th);
                    try {
                        dv9Var.b(fz9.r(th));
                        return vz9.b();
                    } catch (Throwable th2) {
                        kv9.e(th2);
                        RuntimeException runtimeException = new RuntimeException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                        fz9.r(runtimeException);
                        throw runtimeException;
                    }
                }
            }
            throw new IllegalArgumentException("te is null");
        }
        return (fv9) invokeL.objValue;
    }

    public final fv9 k(mv9<? super T> mv9Var, mv9<Throwable> mv9Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, mv9Var, mv9Var2)) == null) {
            if (mv9Var != null) {
                if (mv9Var2 != null) {
                    return j(new a(this, mv9Var2, mv9Var));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onSuccess can not be null");
        }
        return (fv9) invokeLL.objValue;
    }

    public final yu9<T> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? a(this) : (yu9) invokeV.objValue;
    }
}
