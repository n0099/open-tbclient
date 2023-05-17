package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class bp3 {
    public static /* synthetic */ Interceptable $ic;
    public static dp3 a;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static dp3 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (a == null) {
                a = new dp3("0");
            }
            return a;
        }
        return (dp3) invokeV.objValue;
    }

    public static void b(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            dp3 dp3Var = a;
            if (dp3Var == null) {
                a = new dp3(str);
            } else {
                dp3Var.n(str);
            }
        }
    }
}
