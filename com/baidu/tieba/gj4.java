package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class gj4 {
    public static /* synthetic */ Interceptable $ic;
    public static gj4 b;
    public transient /* synthetic */ FieldHolder $fh;
    public wi4 a;

    public gj4() {
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
        this.a = new wi4();
    }

    public static gj4 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            gj4 gj4Var = b;
            if (gj4Var != null) {
                return gj4Var;
            }
            synchronized (gj4.class) {
                if (b == null) {
                    b = new gj4();
                }
            }
            return b;
        }
        return (gj4) invokeV.objValue;
    }

    public si4 a(ij4 ij4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ij4Var)) == null) {
            if (ij4Var == null) {
                return null;
            }
            return new nj4(ij4Var, false);
        }
        return (si4) invokeL.objValue;
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

    public synchronized void e(ej4 ej4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ej4Var) == null) {
            synchronized (this) {
                this.a.c(ej4Var);
            }
        }
    }

    public synchronized <T> void f(ij4<T> ij4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ij4Var) == null) {
            synchronized (this) {
                ij4Var.s(false);
                this.a.h(ij4Var);
            }
        }
    }

    public synchronized void g(ej4 ej4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, ej4Var) == null) {
            synchronized (this) {
                this.a.i(ej4Var);
            }
        }
    }
}
