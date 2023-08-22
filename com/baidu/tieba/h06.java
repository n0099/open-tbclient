package com.baidu.tieba;

import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class h06 {
    public static /* synthetic */ Interceptable $ic;
    public static h06 b;
    public transient /* synthetic */ FieldHolder $fh;
    public u06 a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947769947, "Lcom/baidu/tieba/h06;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947769947, "Lcom/baidu/tieba/h06;");
        }
    }

    public h06() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static h06 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b == null) {
                b = new h06();
            }
            return b;
        }
        return (h06) invokeV.objValue;
    }

    public void a() {
        u06 u06Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (u06Var = this.a) != null && u06Var.b() != null) {
            this.a.b().dismiss();
        }
    }

    public boolean c(m06 m06Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, m06Var)) == null) {
            u06 u06Var = this.a;
            if (u06Var != null && u06Var.b() != null) {
                return this.a.b().c(m06Var);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void d(int i) {
        u06 u06Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && (u06Var = this.a) != null && u06Var.b() != null) {
            this.a.b().b(i);
        }
    }

    public boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            u06 u06Var = this.a;
            if (u06Var != null && u06Var.b() != null) {
                return this.a.b().a(str);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void e(TbPageContext tbPageContext, ViewGroup viewGroup, k06 k06Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, tbPageContext, viewGroup, k06Var) == null) {
            u06 u06Var = this.a;
            if (u06Var == null || !u06Var.a) {
                this.a = new v06(tbPageContext, viewGroup, k06Var);
            }
            if (this.a.b() != null) {
                this.a.b().show();
            }
        }
    }
}
