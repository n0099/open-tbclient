package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class bx2 implements yw2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public pi2 a;

    public bx2() {
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

    @Override // com.baidu.tieba.yw2
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a();
            pi2 pi2Var = this.a;
            if (pi2Var != null) {
                pi2Var.suspendTimer();
            }
        }
    }

    @Override // com.baidu.tieba.yw2
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            a();
            pi2 pi2Var = this.a;
            if (pi2Var != null) {
                pi2Var.continueTimer();
            }
        }
    }

    public final void a() {
        dd2 W;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            pi2 pi2Var = this.a;
            if ((pi2Var == null || pi2Var.isDestroyed()) && (W = bi2.U().W()) != null && (W.e() instanceof pi2)) {
                this.a = (pi2) W.e();
            }
        }
    }
}
