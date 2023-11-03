package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tieba.dr2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class d43 extends id3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void onEvent(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            dr2.a X = f63.K().q().X();
            jd3 jd3Var = new jd3();
            jd3Var.b = str;
            jd3Var.a = zc3.n(X.H());
            jd3Var.f = X.I();
            jd3Var.c = X.U();
            zc3.x("1045", jd3Var);
        }
    }
}
