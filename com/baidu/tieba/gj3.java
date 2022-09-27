package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class gj3 {
    public static /* synthetic */ Interceptable $ic;
    public static ij3 a;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static ij3 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (a == null) {
                a = new ij3("0");
            }
            return a;
        }
        return (ij3) invokeV.objValue;
    }

    public static void b(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            ij3 ij3Var = a;
            if (ij3Var == null) {
                a = new ij3(str);
            } else {
                ij3Var.n(str);
            }
        }
    }
}
