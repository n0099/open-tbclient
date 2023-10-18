package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ev8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static av8<bv8> a(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            av8<bv8> av8Var = new av8<>();
            av8Var.e().k(1);
            bv8 bv8Var = new bv8();
            bv8Var.f(str);
            av8Var.i(bv8Var);
            return av8Var;
        }
        return (av8) invokeL.objValue;
    }
}
