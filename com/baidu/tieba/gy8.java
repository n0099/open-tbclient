package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class gy8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static cy8<dy8> a(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            cy8<dy8> cy8Var = new cy8<>();
            cy8Var.e().j(1);
            dy8 dy8Var = new dy8();
            dy8Var.f(str);
            cy8Var.i(dy8Var);
            return cy8Var;
        }
        return (cy8) invokeL.objValue;
    }
}
