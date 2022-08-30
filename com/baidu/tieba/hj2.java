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
/* loaded from: classes4.dex */
public class hj2 extends gj2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hj2(String str) {
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

    @Override // com.baidu.tieba.kj2, com.baidu.tieba.jj2
    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) && e(str)) {
            boolean equals = TextUtils.equals(str2, "auto");
            boolean equals2 = TextUtils.equals(str2, "api");
            this.a.g("autoPlay", equals ? "1" : "0");
            this.a.g("playMethod", equals2 ? "1" : "0");
        }
    }

    @Override // com.baidu.tieba.gj2, com.baidu.tieba.kj2, com.baidu.tieba.jj2
    public void b(boolean z, HybridUbcFlow hybridUbcFlow) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, hybridUbcFlow) == null) {
            UbcFlowEvent g = hybridUbcFlow.g("fe_slave_dispatch_start");
            UbcFlowEvent g2 = hybridUbcFlow.g("fe_master_page_oninit_start");
            UbcFlowEvent g3 = hybridUbcFlow.g("master_page_onload_start");
            UbcFlowEvent g4 = hybridUbcFlow.g("video_fe_init");
            UbcFlowEvent g5 = hybridUbcFlow.g("video_fe_init_end");
            if (g != null) {
                this.a.i("fe_slave_dispatch_start", z ? g.g() : 0L);
            }
            if (g2 != null) {
                this.a.i("fe_master_page_oninit_start", z ? g2.g() : 0L);
            }
            if (g3 != null) {
                this.a.i("master_page_onload_start", z ? g3.g() : 0L);
            }
            if (g4 != null) {
                this.a.i("video_fe_init", z ? g4.g() : 0L);
            }
            if (g5 != null) {
                this.a.i("video_fe_init_end", z ? g5.g() : 0L);
            }
            this.a.g("fmpArrived", z ? "1" : "0");
            if (this.a.f()) {
                this.a.k();
                fj2.e();
            }
        }
    }

    @Override // com.baidu.tieba.kj2, com.baidu.tieba.jj2
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
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? TextUtils.equals(this.b, str) : invokeL.booleanValue;
    }
}
