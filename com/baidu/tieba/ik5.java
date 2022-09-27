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
/* loaded from: classes4.dex */
public class ik5 {
    public static /* synthetic */ Interceptable $ic;
    public static ik5 b;
    public transient /* synthetic */ FieldHolder $fh;
    public vk5 a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947856406, "Lcom/baidu/tieba/ik5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947856406, "Lcom/baidu/tieba/ik5;");
        }
    }

    public ik5() {
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

    public static ik5 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b == null) {
                b = new ik5();
            }
            return b;
        }
        return (ik5) invokeV.objValue;
    }

    public void a() {
        vk5 vk5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (vk5Var = this.a) == null || vk5Var.b() == null) {
            return;
        }
        this.a.b().dismiss();
    }

    public boolean c(nk5 nk5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nk5Var)) == null) {
            vk5 vk5Var = this.a;
            if (vk5Var == null || vk5Var.b() == null) {
                return false;
            }
            return this.a.b().c(nk5Var);
        }
        return invokeL.booleanValue;
    }

    public void d(int i) {
        vk5 vk5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) || (vk5Var = this.a) == null || vk5Var.b() == null) {
            return;
        }
        this.a.b().b(i);
    }

    public void e(TbPageContext tbPageContext, ViewGroup viewGroup, lk5 lk5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, tbPageContext, viewGroup, lk5Var) == null) {
            vk5 vk5Var = this.a;
            if (vk5Var == null || !vk5Var.a) {
                this.a = new wk5(tbPageContext, viewGroup, lk5Var);
            }
            if (this.a.b() != null) {
                this.a.b().show();
            }
        }
    }

    public boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            vk5 vk5Var = this.a;
            if (vk5Var == null || vk5Var.b() == null) {
                return false;
            }
            return this.a.b().a(str);
        }
        return invokeL.booleanValue;
    }
}
