package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ee4 {
    public static /* synthetic */ Interceptable $ic;
    public static ee4 b;
    public transient /* synthetic */ FieldHolder $fh;
    public ud4 a;

    public ee4() {
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
        this.a = new ud4();
    }

    public static ee4 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            ee4 ee4Var = b;
            if (ee4Var != null) {
                return ee4Var;
            }
            synchronized (ee4.class) {
                if (b == null) {
                    b = new ee4();
                }
            }
            return b;
        }
        return (ee4) invokeV.objValue;
    }

    public qd4 a(ge4 ge4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ge4Var)) == null) {
            if (ge4Var == null) {
                return null;
            }
            return new le4(ge4Var, false);
        }
        return (qd4) invokeL.objValue;
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

    public synchronized void e(ce4 ce4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ce4Var) == null) {
            synchronized (this) {
                this.a.c(ce4Var);
            }
        }
    }

    public synchronized <T> void f(ge4<T> ge4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ge4Var) == null) {
            synchronized (this) {
                ge4Var.s(false);
                this.a.h(ge4Var);
            }
        }
    }

    public synchronized void g(ce4 ce4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, ce4Var) == null) {
            synchronized (this) {
                this.a.i(ce4Var);
            }
        }
    }
}
