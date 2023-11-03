package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class bm3 {
    public static /* synthetic */ Interceptable $ic;
    public static dm3 a;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static dm3 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (a == null) {
                a = new dm3("0");
            }
            return a;
        }
        return (dm3) invokeV.objValue;
    }

    public static void b(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            dm3 dm3Var = a;
            if (dm3Var == null) {
                a = new dm3(str);
            } else {
                dm3Var.n(str);
            }
        }
    }
}
