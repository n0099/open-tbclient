package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class hl4 {
    public static /* synthetic */ Interceptable $ic;
    public static hl4 b;
    public transient /* synthetic */ FieldHolder $fh;
    public xk4 a;

    public hl4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new xk4();
    }

    public static hl4 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            hl4 hl4Var = b;
            if (hl4Var != null) {
                return hl4Var;
            }
            synchronized (hl4.class) {
                if (b == null) {
                    b = new hl4();
                }
            }
            return b;
        }
        return (hl4) invokeV.objValue;
    }

    public tk4 a(jl4 jl4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jl4Var)) == null) {
            if (jl4Var == null) {
                return null;
            }
            return new ol4(jl4Var, false);
        }
        return (tk4) invokeL.objValue;
    }

    public synchronized boolean c(String str) {
        InterceptResult invokeL;
        boolean e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            synchronized (this) {
                e = this.a.e(str);
            }
            return e;
        }
        return invokeL.booleanValue;
    }

    public synchronized boolean d(String str) {
        InterceptResult invokeL;
        boolean f;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            synchronized (this) {
                f = this.a.f(str);
            }
            return f;
        }
        return invokeL.booleanValue;
    }

    public synchronized void e(fl4 fl4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fl4Var) == null) {
            synchronized (this) {
                this.a.c(fl4Var);
            }
        }
    }

    public synchronized <T> void f(jl4<T> jl4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jl4Var) == null) {
            synchronized (this) {
                jl4Var.s(false);
                this.a.h(jl4Var);
            }
        }
    }

    public synchronized void g(fl4 fl4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fl4Var) == null) {
            synchronized (this) {
                this.a.i(fl4Var);
            }
        }
    }
}
