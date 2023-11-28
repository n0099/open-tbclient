package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class cm3 {
    public static /* synthetic */ Interceptable $ic;
    public static em3 a;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static em3 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (a == null) {
                a = new em3("0");
            }
            return a;
        }
        return (em3) invokeV.objValue;
    }

    public static void b(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            em3 em3Var = a;
            if (em3Var == null) {
                a = new em3(str);
            } else {
                em3Var.n(str);
            }
        }
    }
}
