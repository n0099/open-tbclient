package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class cu8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static yt8<zt8> a(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            yt8<zt8> yt8Var = new yt8<>();
            yt8Var.e().j(1);
            zt8 zt8Var = new zt8();
            zt8Var.f(str);
            yt8Var.i(zt8Var);
            return yt8Var;
        }
        return (yt8) invokeL.objValue;
    }
}
