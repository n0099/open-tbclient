package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tieba.du2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class e73 extends ig3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void onEvent(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            du2.a W = f93.K().q().W();
            jg3 jg3Var = new jg3();
            jg3Var.b = str;
            jg3Var.a = zf3.n(W.G());
            jg3Var.f = W.H();
            jg3Var.c = W.T();
            zf3.x("1088", jg3Var);
        }
    }
}
