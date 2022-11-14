package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class ak3 {
    public static /* synthetic */ Interceptable $ic;
    public static ck3 a;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static ck3 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (a == null) {
                a = new ck3("0");
            }
            return a;
        }
        return (ck3) invokeV.objValue;
    }

    public static void b(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            ck3 ck3Var = a;
            if (ck3Var == null) {
                a = new ck3(str);
            } else {
                ck3Var.n(str);
            }
        }
    }
}
