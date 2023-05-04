package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class dd8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static zc8<ad8> a(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            zc8<ad8> zc8Var = new zc8<>();
            zc8Var.e().j(1);
            ad8 ad8Var = new ad8();
            ad8Var.f(str);
            zc8Var.i(ad8Var);
            return zc8Var;
        }
        return (zc8) invokeL.objValue;
    }
}
