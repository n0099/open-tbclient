package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class cu3 implements fu3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public zt3 a;

    public cu3(zt3 zt3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zt3Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = zt3Var;
    }

    @Override // com.baidu.tieba.fu3
    public void a(gu3 gu3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, gu3Var) == null) {
            setResult(gu3Var);
        }
    }

    private void setResult(gu3 gu3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, gu3Var) == null) {
            this.a.d.clear();
            if (gu3Var != null) {
                this.a.d.putString("functionType", gu3Var.a());
                this.a.d.putString("resultData", gu3Var.b());
                this.a.d.putInt("resultStatus", gu3Var.c());
            }
            this.a.c();
        }
    }
}
