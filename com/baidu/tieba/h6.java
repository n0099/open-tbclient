package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.l3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class h6 extends e6 implements f6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public k3 h;

    public h6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public h6(k3 k3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {k3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        o(k3Var);
    }

    public void o(k3 k3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, k3Var) == null) {
            this.h = k3Var;
            j(k3Var.n());
            h(k3Var.k());
        }
    }

    public h6 p(u2 u2Var) {
        InterceptResult invokeL;
        k3 k3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, u2Var)) == null) {
            k3 k3Var2 = this.h;
            if (k3Var2 instanceof l3.b) {
                k3Var = new l3.b((l3.b) k3Var2);
            } else {
                k3Var = new k3(k3Var2);
            }
            k3Var.u(u2Var);
            k3Var.z(a(), k());
            h6 h6Var = new h6(k3Var);
            h6Var.b(l());
            h6Var.c(g());
            h6Var.f(i());
            h6Var.d(e());
            return h6Var;
        }
        return (h6) invokeL.objValue;
    }
}
