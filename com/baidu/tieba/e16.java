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
public class e16 {
    public static /* synthetic */ Interceptable $ic;
    public static e16 b;
    public transient /* synthetic */ FieldHolder $fh;
    public r16 a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947681535, "Lcom/baidu/tieba/e16;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947681535, "Lcom/baidu/tieba/e16;");
        }
    }

    public e16() {
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

    public static e16 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b == null) {
                b = new e16();
            }
            return b;
        }
        return (e16) invokeV.objValue;
    }

    public void a() {
        r16 r16Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (r16Var = this.a) != null && r16Var.b() != null) {
            this.a.b().dismiss();
        }
    }

    public boolean c(j16 j16Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j16Var)) == null) {
            r16 r16Var = this.a;
            if (r16Var != null && r16Var.b() != null) {
                return this.a.b().c(j16Var);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void d(int i) {
        r16 r16Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && (r16Var = this.a) != null && r16Var.b() != null) {
            this.a.b().b(i);
        }
    }

    public boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            r16 r16Var = this.a;
            if (r16Var != null && r16Var.b() != null) {
                return this.a.b().a(str);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void e(TbPageContext tbPageContext, ViewGroup viewGroup, h16 h16Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, tbPageContext, viewGroup, h16Var) == null) {
            r16 r16Var = this.a;
            if (r16Var == null || !r16Var.a) {
                this.a = new s16(tbPageContext, viewGroup, h16Var);
            }
            if (this.a.b() != null) {
                this.a.b().show();
            }
        }
    }
}
