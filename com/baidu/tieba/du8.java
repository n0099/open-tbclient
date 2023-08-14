package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class du8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static zt8<au8> a(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            zt8<au8> zt8Var = new zt8<>();
            zt8Var.e().j(1);
            au8 au8Var = new au8();
            au8Var.f(str);
            zt8Var.i(au8Var);
            return zt8Var;
        }
        return (zt8) invokeL.objValue;
    }
}
