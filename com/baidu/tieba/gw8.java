package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class gw8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static cw8<dw8> a(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            cw8<dw8> cw8Var = new cw8<>();
            cw8Var.e().j(1);
            dw8 dw8Var = new dw8();
            dw8Var.f(str);
            cw8Var.i(dw8Var);
            return cw8Var;
        }
        return (cw8) invokeL.objValue;
    }
}
