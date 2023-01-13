package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tieba.gp2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class h23 extends lb3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void onEvent(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            gp2.a W = i43.K().q().W();
            mb3 mb3Var = new mb3();
            mb3Var.b = str;
            mb3Var.a = cb3.n(W.G());
            mb3Var.f = W.H();
            mb3Var.c = W.T();
            cb3.x("1088", mb3Var);
        }
    }
}
