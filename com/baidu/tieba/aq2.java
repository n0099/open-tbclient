package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class aq2 extends eq2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final yp2 a;

    public aq2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new yp2();
    }

    @Override // com.baidu.tieba.eq2, com.baidu.tieba.dq2
    public void b(boolean z, HybridUbcFlow hybridUbcFlow) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048576, this, z, hybridUbcFlow) == null) {
            if (this.a.f()) {
                this.a.k();
                zp2.e();
                return;
            }
            yp2 yp2Var = this.a;
            if (z) {
                str = "1";
            } else {
                str = "0";
            }
            yp2Var.g("fmpArrived", str);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a.c();
            if (this.a.e("fmpArrived")) {
                this.a.k();
                zp2.e();
            }
        }
    }
}
