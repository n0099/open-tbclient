package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.i4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class e7 extends b7 implements c7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public h4 h;

    public e7() {
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

    public e7(h4 h4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {h4Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        o(h4Var);
    }

    public void o(h4 h4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, h4Var) == null) {
            this.h = h4Var;
            j(h4Var.n());
            h(h4Var.k());
        }
    }

    public e7 p(r3 r3Var) {
        InterceptResult invokeL;
        h4 h4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, r3Var)) == null) {
            h4 h4Var2 = this.h;
            if (h4Var2 instanceof i4.b) {
                h4Var = new i4.b((i4.b) h4Var2);
            } else {
                h4Var = new h4(h4Var2);
            }
            h4Var.u(r3Var);
            h4Var.z(a(), k());
            e7 e7Var = new e7(h4Var);
            e7Var.b(l());
            e7Var.c(g());
            e7Var.f(i());
            e7Var.d(e());
            return e7Var;
        }
        return (e7) invokeL.objValue;
    }
}
