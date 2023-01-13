package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class ek3 {
    public static /* synthetic */ Interceptable $ic;
    public static gk3 a;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static gk3 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (a == null) {
                a = new gk3("0");
            }
            return a;
        }
        return (gk3) invokeV.objValue;
    }

    public static void b(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            gk3 gk3Var = a;
            if (gk3Var == null) {
                a = new gk3(str);
            } else {
                gk3Var.n(str);
            }
        }
    }
}
