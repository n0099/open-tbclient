package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ft2 extends et2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ft2(String str) {
        super(str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.it2, com.baidu.tieba.ht2
    public void a(String str, String str2) {
        String str3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) && e(str)) {
            boolean equals = TextUtils.equals(str2, "auto");
            boolean equals2 = TextUtils.equals(str2, "api");
            ct2 ct2Var = this.a;
            String str4 = "1";
            if (equals) {
                str3 = "1";
            } else {
                str3 = "0";
            }
            ct2Var.g("autoPlay", str3);
            ct2 ct2Var2 = this.a;
            if (!equals2) {
                str4 = "0";
            }
            ct2Var2.g("playMethod", str4);
        }
    }

    @Override // com.baidu.tieba.et2, com.baidu.tieba.it2, com.baidu.tieba.ht2
    public void b(boolean z, HybridUbcFlow hybridUbcFlow) {
        String str;
        long j;
        long j2;
        long j3;
        long j4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, hybridUbcFlow) == null) {
            UbcFlowEvent g = hybridUbcFlow.g("fe_slave_dispatch_start");
            UbcFlowEvent g2 = hybridUbcFlow.g("fe_master_page_oninit_start");
            UbcFlowEvent g3 = hybridUbcFlow.g("master_page_onload_start");
            UbcFlowEvent g4 = hybridUbcFlow.g("video_fe_init");
            UbcFlowEvent g5 = hybridUbcFlow.g("video_fe_init_end");
            long j5 = 0;
            if (g != null) {
                ct2 ct2Var = this.a;
                if (z) {
                    j4 = g.g();
                } else {
                    j4 = 0;
                }
                ct2Var.i("fe_slave_dispatch_start", j4);
            }
            if (g2 != null) {
                ct2 ct2Var2 = this.a;
                if (z) {
                    j3 = g2.g();
                } else {
                    j3 = 0;
                }
                ct2Var2.i("fe_master_page_oninit_start", j3);
            }
            if (g3 != null) {
                ct2 ct2Var3 = this.a;
                if (z) {
                    j2 = g3.g();
                } else {
                    j2 = 0;
                }
                ct2Var3.i("master_page_onload_start", j2);
            }
            if (g4 != null) {
                ct2 ct2Var4 = this.a;
                if (z) {
                    j = g4.g();
                } else {
                    j = 0;
                }
                ct2Var4.i("video_fe_init", j);
            }
            if (g5 != null) {
                ct2 ct2Var5 = this.a;
                if (z) {
                    j5 = g5.g();
                }
                ct2Var5.i("video_fe_init_end", j5);
            }
            ct2 ct2Var6 = this.a;
            if (z) {
                str = "1";
            } else {
                str = "0";
            }
            ct2Var6.g("fmpArrived", str);
            if (this.a.f()) {
                this.a.k();
                dt2.e();
            }
        }
    }

    @Override // com.baidu.tieba.it2, com.baidu.tieba.ht2
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.a.d("video_will_play")) {
                this.a.h("video_play_cancel");
            }
            d();
        }
    }

    public final boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            return TextUtils.equals(this.b, str);
        }
        return invokeL.booleanValue;
    }
}
