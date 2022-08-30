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
public class ev9<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c<T> a;

    /* loaded from: classes4.dex */
    public class a extends fv9<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ov9 b;
        public final /* synthetic */ ov9 c;

        public a(ev9 ev9Var, ov9 ov9Var, ov9 ov9Var2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ev9Var, ov9Var, ov9Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ov9Var;
            this.c = ov9Var2;
        }

        @Override // com.baidu.tieba.fv9
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

        @Override // com.baidu.tieba.fv9
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
    public class b implements ov9<Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ov9 a;

        public b(ev9 ev9Var, ov9 ov9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ev9Var, ov9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ov9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ov9
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                this.a.call(th);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface c<T> extends ov9<fv9<? super T>> {
        @Override // com.baidu.tieba.ov9
        /* synthetic */ void call(T t);
    }

    public ev9(c<T> cVar) {
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
        this.a = hz9.i(cVar);
    }

    public static <T> av9<T> a(ev9<T> ev9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, ev9Var)) == null) ? av9.a(new sw9(ev9Var.a)) : (av9) invokeL.objValue;
    }

    public static <T> ev9<T> b(c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, cVar)) == null) ? new ev9<>(cVar) : (ev9) invokeL.objValue;
    }

    public static <T> ev9<T> g(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, t)) == null) ? kx9.m(t) : (ev9) invokeL.objValue;
    }

    public final ev9<T> c(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, timeUnit)) == null) ? d(j, timeUnit, Schedulers.computation()) : (ev9) invokeJL.objValue;
    }

    public final ev9<T> d(long j, TimeUnit timeUnit, dv9 dv9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), timeUnit, dv9Var})) == null) ? b(new nw9(this.a, j, timeUnit, dv9Var)) : (ev9) invokeCommon.objValue;
    }

    public final ev9<T> e(ov9<Throwable> ov9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ov9Var)) == null) {
            if (ov9Var != null) {
                return b(new ow9(this, Actions.a(), new b(this, ov9Var)));
            }
            throw new IllegalArgumentException("onError is null");
        }
        return (ev9) invokeL.objValue;
    }

    public final ev9<T> f(ov9<? super T> ov9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, ov9Var)) == null) {
            if (ov9Var != null) {
                return b(new ow9(this, ov9Var, Actions.a()));
            }
            throw new IllegalArgumentException("onSuccess is null");
        }
        return (ev9) invokeL.objValue;
    }

    public final ev9<T> h(dv9 dv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, dv9Var)) == null) {
            if (this instanceof kx9) {
                return ((kx9) this).n(dv9Var);
            }
            if (dv9Var != null) {
                return b(new rw9(this.a, dv9Var));
            }
            throw new NullPointerException("scheduler is null");
        }
        return (ev9) invokeL.objValue;
    }

    public final hv9 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? k(Actions.a(), Actions.b()) : (hv9) invokeV.objValue;
    }

    public final hv9 j(fv9<? super T> fv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, fv9Var)) == null) {
            if (fv9Var != null) {
                try {
                    hz9.t(this, this.a).call(fv9Var);
                    return hz9.s(fv9Var);
                } catch (Throwable th) {
                    mv9.e(th);
                    try {
                        fv9Var.b(hz9.r(th));
                        return xz9.b();
                    } catch (Throwable th2) {
                        mv9.e(th2);
                        RuntimeException runtimeException = new RuntimeException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                        hz9.r(runtimeException);
                        throw runtimeException;
                    }
                }
            }
            throw new IllegalArgumentException("te is null");
        }
        return (hv9) invokeL.objValue;
    }

    public final hv9 k(ov9<? super T> ov9Var, ov9<Throwable> ov9Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, ov9Var, ov9Var2)) == null) {
            if (ov9Var != null) {
                if (ov9Var2 != null) {
                    return j(new a(this, ov9Var2, ov9Var));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onSuccess can not be null");
        }
        return (hv9) invokeLL.objValue;
    }

    public final av9<T> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? a(this) : (av9) invokeV.objValue;
    }
}
