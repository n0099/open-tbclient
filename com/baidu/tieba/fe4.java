package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class fe4 {
    public static /* synthetic */ Interceptable $ic;
    public static fe4 b;
    public transient /* synthetic */ FieldHolder $fh;
    public vd4 a;

    public fe4() {
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
        this.a = new vd4();
    }

    public static fe4 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            fe4 fe4Var = b;
            if (fe4Var != null) {
                return fe4Var;
            }
            synchronized (fe4.class) {
                if (b == null) {
                    b = new fe4();
                }
            }
            return b;
        }
        return (fe4) invokeV.objValue;
    }

    public rd4 a(he4 he4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, he4Var)) == null) {
            if (he4Var == null) {
                return null;
            }
            return new me4(he4Var, false);
        }
        return (rd4) invokeL.objValue;
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

    public synchronized void e(de4 de4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, de4Var) == null) {
            synchronized (this) {
                this.a.c(de4Var);
            }
        }
    }

    public synchronized <T> void f(he4<T> he4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, he4Var) == null) {
            synchronized (this) {
                he4Var.s(false);
                this.a.h(he4Var);
            }
        }
    }

    public synchronized void g(de4 de4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, de4Var) == null) {
            synchronized (this) {
                this.a.i(de4Var);
            }
        }
    }
}
