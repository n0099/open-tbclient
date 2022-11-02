package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tieba.bp2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class b23 extends gb3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void onEvent(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            bp2.a W = d43.K().q().W();
            hb3 hb3Var = new hb3();
            hb3Var.b = str;
            hb3Var.a = xa3.n(W.G());
            hb3Var.f = W.H();
            hb3Var.c = W.T();
            xa3.x("1045", hb3Var);
        }
    }
}
