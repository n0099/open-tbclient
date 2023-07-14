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
/* loaded from: classes5.dex */
public class f26 {
    public static /* synthetic */ Interceptable $ic;
    public static f26 b;
    public transient /* synthetic */ FieldHolder $fh;
    public s26 a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947712287, "Lcom/baidu/tieba/f26;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947712287, "Lcom/baidu/tieba/f26;");
        }
    }

    public f26() {
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

    public static f26 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b == null) {
                b = new f26();
            }
            return b;
        }
        return (f26) invokeV.objValue;
    }

    public void a() {
        s26 s26Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (s26Var = this.a) != null && s26Var.b() != null) {
            this.a.b().dismiss();
        }
    }

    public boolean c(k26 k26Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k26Var)) == null) {
            s26 s26Var = this.a;
            if (s26Var != null && s26Var.b() != null) {
                return this.a.b().c(k26Var);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void d(int i) {
        s26 s26Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && (s26Var = this.a) != null && s26Var.b() != null) {
            this.a.b().b(i);
        }
    }

    public boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            s26 s26Var = this.a;
            if (s26Var != null && s26Var.b() != null) {
                return this.a.b().a(str);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void e(TbPageContext tbPageContext, ViewGroup viewGroup, i26 i26Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, tbPageContext, viewGroup, i26Var) == null) {
            s26 s26Var = this.a;
            if (s26Var == null || !s26Var.a) {
                this.a = new t26(tbPageContext, viewGroup, i26Var);
            }
            if (this.a.b() != null) {
                this.a.b().show();
            }
        }
    }
}
