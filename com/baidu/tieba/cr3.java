package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class cr3 {
    public static /* synthetic */ Interceptable $ic;
    public static er3 a;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static er3 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (a == null) {
                a = new er3("0");
            }
            return a;
        }
        return (er3) invokeV.objValue;
    }

    public static void b(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            er3 er3Var = a;
            if (er3Var == null) {
                a = new er3(str);
            } else {
                er3Var.n(str);
            }
        }
    }
}
