package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class c04 implements f04 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public zz3 a;

    public c04(zz3 zz3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zz3Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = zz3Var;
    }

    @Override // com.baidu.tieba.f04
    public void a(g04 g04Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, g04Var) == null) {
            setResult(g04Var);
        }
    }

    private void setResult(g04 g04Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, g04Var) == null) {
            this.a.d.clear();
            if (g04Var != null) {
                this.a.d.putString("functionType", g04Var.a());
                this.a.d.putString("resultData", g04Var.b());
                this.a.d.putInt("resultStatus", g04Var.c());
            }
            this.a.c();
        }
    }
}
