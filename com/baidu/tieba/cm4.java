package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class cm4 {
    public static /* synthetic */ Interceptable $ic;
    public static cm4 b;
    public transient /* synthetic */ FieldHolder $fh;
    public sl4 a;

    public cm4() {
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
        this.a = new sl4();
    }

    public static cm4 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            cm4 cm4Var = b;
            if (cm4Var != null) {
                return cm4Var;
            }
            synchronized (cm4.class) {
                if (b == null) {
                    b = new cm4();
                }
            }
            return b;
        }
        return (cm4) invokeV.objValue;
    }

    public ol4 a(em4 em4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, em4Var)) == null) {
            if (em4Var == null) {
                return null;
            }
            return new jm4(em4Var, false);
        }
        return (ol4) invokeL.objValue;
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

    public synchronized void e(am4 am4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, am4Var) == null) {
            synchronized (this) {
                this.a.c(am4Var);
            }
        }
    }

    public synchronized <T> void f(em4<T> em4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, em4Var) == null) {
            synchronized (this) {
                em4Var.s(false);
                this.a.h(em4Var);
            }
        }
    }

    public synchronized void g(am4 am4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, am4Var) == null) {
            synchronized (this) {
                this.a.i(am4Var);
            }
        }
    }
}
