package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tieba.ew2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class f93 extends ji3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void onEvent(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            ew2.a W = gb3.K().q().W();
            ki3 ki3Var = new ki3();
            ki3Var.b = str;
            ki3Var.a = ai3.n(W.G());
            ki3Var.f = W.H();
            ki3Var.c = W.T();
            ai3.x("1088", ki3Var);
        }
    }
}
