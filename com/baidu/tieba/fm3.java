package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class fm3 {
    public static /* synthetic */ Interceptable $ic;
    public static hm3 a;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static hm3 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (a == null) {
                a = new hm3("0");
            }
            return a;
        }
        return (hm3) invokeV.objValue;
    }

    public static void b(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            hm3 hm3Var = a;
            if (hm3Var == null) {
                a = new hm3(str);
            } else {
                hm3Var.n(str);
            }
        }
    }
}
