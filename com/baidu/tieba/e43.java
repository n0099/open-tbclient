package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tieba.er2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class e43 extends jd3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void onEvent(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            er2.a X = g63.K().q().X();
            kd3 kd3Var = new kd3();
            kd3Var.b = str;
            kd3Var.a = ad3.n(X.H());
            kd3Var.f = X.I();
            kd3Var.c = X.U();
            ad3.x("1045", kd3Var);
        }
    }
}
