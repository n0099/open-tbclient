package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tieba.dw2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class e93 extends ii3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void onEvent(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            dw2.a W = fb3.K().q().W();
            ji3 ji3Var = new ji3();
            ji3Var.b = str;
            ji3Var.a = zh3.n(W.G());
            ji3Var.f = W.H();
            ji3Var.c = W.T();
            zh3.x("1088", ji3Var);
        }
    }
}
