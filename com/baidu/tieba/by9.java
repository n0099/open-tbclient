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
public class by9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c a;

    /* loaded from: classes3.dex */
    public interface c extends ly9 {
        @Override // com.baidu.tieba.ly9
        /* synthetic */ void call(Object obj);
    }

    /* loaded from: classes3.dex */
    public class a extends cy9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ly9 b;
        public final /* synthetic */ ly9 c;

        public a(by9 by9Var, ly9 ly9Var, ly9 ly9Var2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {by9Var, ly9Var, ly9Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ly9Var;
            this.c = ly9Var2;
        }

        @Override // com.baidu.tieba.cy9
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

        @Override // com.baidu.tieba.cy9
        public final void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                try {
                    this.c.call(obj);
                } finally {
                    unsubscribe();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ly9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ly9 a;

        public b(by9 by9Var, ly9 ly9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {by9Var, ly9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ly9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ly9
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                this.a.call(th);
            }
        }
    }

    public by9(c cVar) {
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
        this.a = e2a.i(cVar);
    }

    public final by9 h(ay9 ay9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, ay9Var)) == null) {
            if (this instanceof h0a) {
                return ((h0a) this).n(ay9Var);
            }
            if (ay9Var != null) {
                return b(new oz9(this.a, ay9Var));
            }
            throw new NullPointerException("scheduler is null");
        }
        return (by9) invokeL.objValue;
    }

    public static xx9 a(by9 by9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, by9Var)) == null) {
            return xx9.a(new pz9(by9Var.a));
        }
        return (xx9) invokeL.objValue;
    }

    public static by9 b(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, cVar)) == null) {
            return new by9(cVar);
        }
        return (by9) invokeL.objValue;
    }

    public static by9 g(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, obj)) == null) {
            return h0a.m(obj);
        }
        return (by9) invokeL.objValue;
    }

    public final by9 e(ly9 ly9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ly9Var)) == null) {
            if (ly9Var != null) {
                return b(new lz9(this, Actions.a(), new b(this, ly9Var)));
            }
            throw new IllegalArgumentException("onError is null");
        }
        return (by9) invokeL.objValue;
    }

    public final by9 f(ly9 ly9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, ly9Var)) == null) {
            if (ly9Var != null) {
                return b(new lz9(this, ly9Var, Actions.a()));
            }
            throw new IllegalArgumentException("onSuccess is null");
        }
        return (by9) invokeL.objValue;
    }

    public final by9 c(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, timeUnit)) == null) {
            return d(j, timeUnit, Schedulers.computation());
        }
        return (by9) invokeJL.objValue;
    }

    public final ey9 k(ly9 ly9Var, ly9 ly9Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, ly9Var, ly9Var2)) == null) {
            if (ly9Var != null) {
                if (ly9Var2 != null) {
                    return j(new a(this, ly9Var2, ly9Var));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onSuccess can not be null");
        }
        return (ey9) invokeLL.objValue;
    }

    public final by9 d(long j, TimeUnit timeUnit, ay9 ay9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), timeUnit, ay9Var})) == null) {
            return b(new kz9(this.a, j, timeUnit, ay9Var));
        }
        return (by9) invokeCommon.objValue;
    }

    public final ey9 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return k(Actions.a(), Actions.b());
        }
        return (ey9) invokeV.objValue;
    }

    public final xx9 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return a(this);
        }
        return (xx9) invokeV.objValue;
    }

    public final ey9 j(cy9 cy9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, cy9Var)) == null) {
            if (cy9Var != null) {
                try {
                    e2a.t(this, this.a).call(cy9Var);
                    return e2a.s(cy9Var);
                } catch (Throwable th) {
                    jy9.e(th);
                    try {
                        cy9Var.b(e2a.r(th));
                        return u2a.b();
                    } catch (Throwable th2) {
                        jy9.e(th2);
                        RuntimeException runtimeException = new RuntimeException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                        e2a.r(runtimeException);
                        throw runtimeException;
                    }
                }
            }
            throw new IllegalArgumentException("te is null");
        }
        return (ey9) invokeL.objValue;
    }
}
