package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tieba.aw2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class b93 extends fi3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void onEvent(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            aw2.a W = cb3.K().q().W();
            gi3 gi3Var = new gi3();
            gi3Var.b = str;
            gi3Var.a = wh3.n(W.G());
            gi3Var.f = W.H();
            gi3Var.c = W.T();
            wh3.x("1088", gi3Var);
        }
    }
}
