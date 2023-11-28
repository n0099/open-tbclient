package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class hg4 {
    public static /* synthetic */ Interceptable $ic;
    public static hg4 b;
    public transient /* synthetic */ FieldHolder $fh;
    public xf4 a;

    public hg4() {
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
        this.a = new xf4();
    }

    public static hg4 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            hg4 hg4Var = b;
            if (hg4Var != null) {
                return hg4Var;
            }
            synchronized (hg4.class) {
                if (b == null) {
                    b = new hg4();
                }
            }
            return b;
        }
        return (hg4) invokeV.objValue;
    }

    public tf4 a(jg4 jg4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jg4Var)) == null) {
            if (jg4Var == null) {
                return null;
            }
            return new og4(jg4Var, false);
        }
        return (tf4) invokeL.objValue;
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

    public synchronized void e(fg4 fg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fg4Var) == null) {
            synchronized (this) {
                this.a.c(fg4Var);
            }
        }
    }

    public synchronized <T> void f(jg4<T> jg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jg4Var) == null) {
            synchronized (this) {
                jg4Var.s(false);
                this.a.h(jg4Var);
            }
        }
    }

    public synchronized void g(fg4 fg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fg4Var) == null) {
            synchronized (this) {
                this.a.i(fg4Var);
            }
        }
    }
}
