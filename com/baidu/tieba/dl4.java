package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class dl4 {
    public static /* synthetic */ Interceptable $ic;
    public static dl4 b;
    public transient /* synthetic */ FieldHolder $fh;
    public tk4 a;

    public dl4() {
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
        this.a = new tk4();
    }

    public static dl4 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            dl4 dl4Var = b;
            if (dl4Var != null) {
                return dl4Var;
            }
            synchronized (dl4.class) {
                if (b == null) {
                    b = new dl4();
                }
            }
            return b;
        }
        return (dl4) invokeV.objValue;
    }

    public pk4 a(fl4 fl4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fl4Var)) == null) {
            if (fl4Var == null) {
                return null;
            }
            return new kl4(fl4Var, false);
        }
        return (pk4) invokeL.objValue;
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

    public synchronized void e(bl4 bl4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bl4Var) == null) {
            synchronized (this) {
                this.a.c(bl4Var);
            }
        }
    }

    public synchronized <T> void f(fl4<T> fl4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fl4Var) == null) {
            synchronized (this) {
                fl4Var.s(false);
                this.a.h(fl4Var);
            }
        }
    }

    public synchronized void g(bl4 bl4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bl4Var) == null) {
            synchronized (this) {
                this.a.i(bl4Var);
            }
        }
    }
}
