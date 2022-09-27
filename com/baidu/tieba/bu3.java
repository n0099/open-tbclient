package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class bu3 implements eu3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public yt3 a;

    public bu3(yt3 yt3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {yt3Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = yt3Var;
    }

    private void setResult(fu3 fu3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, fu3Var) == null) {
            this.a.d.clear();
            if (fu3Var != null) {
                this.a.d.putString("functionType", fu3Var.a());
                this.a.d.putString("resultData", fu3Var.b());
                this.a.d.putInt("resultStatus", fu3Var.c());
            }
            this.a.c();
        }
    }

    @Override // com.baidu.tieba.eu3
    public void a(fu3 fu3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fu3Var) == null) {
            setResult(fu3Var);
        }
    }
}
