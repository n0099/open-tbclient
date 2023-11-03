package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class gg4 {
    public static /* synthetic */ Interceptable $ic;
    public static gg4 b;
    public transient /* synthetic */ FieldHolder $fh;
    public wf4 a;

    public gg4() {
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
        this.a = new wf4();
    }

    public static gg4 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            gg4 gg4Var = b;
            if (gg4Var != null) {
                return gg4Var;
            }
            synchronized (gg4.class) {
                if (b == null) {
                    b = new gg4();
                }
            }
            return b;
        }
        return (gg4) invokeV.objValue;
    }

    public sf4 a(ig4 ig4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ig4Var)) == null) {
            if (ig4Var == null) {
                return null;
            }
            return new ng4(ig4Var, false);
        }
        return (sf4) invokeL.objValue;
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

    public synchronized void e(eg4 eg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, eg4Var) == null) {
            synchronized (this) {
                this.a.c(eg4Var);
            }
        }
    }

    public synchronized <T> void f(ig4<T> ig4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ig4Var) == null) {
            synchronized (this) {
                ig4Var.s(false);
                this.a.h(ig4Var);
            }
        }
    }

    public synchronized void g(eg4 eg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, eg4Var) == null) {
            synchronized (this) {
                this.a.i(eg4Var);
            }
        }
    }
}
