package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tieba.hr2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class i43 extends md3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void onEvent(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            hr2.a X = j63.K().q().X();
            nd3 nd3Var = new nd3();
            nd3Var.b = str;
            nd3Var.a = dd3.n(X.H());
            nd3Var.f = X.I();
            nd3Var.c = X.U();
            dd3.x("1088", nd3Var);
        }
    }
}
