package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tieba.cp2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class c23 extends hb3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void onEvent(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            cp2.a W = e43.K().q().W();
            ib3 ib3Var = new ib3();
            ib3Var.b = str;
            ib3Var.a = ya3.n(W.G());
            ib3Var.f = W.H();
            ib3Var.c = W.T();
            ya3.x("1045", ib3Var);
        }
    }
}
