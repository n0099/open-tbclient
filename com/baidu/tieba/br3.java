package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class br3 {
    public static /* synthetic */ Interceptable $ic;
    public static dr3 a;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static dr3 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (a == null) {
                a = new dr3("0");
            }
            return a;
        }
        return (dr3) invokeV.objValue;
    }

    public static void b(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            dr3 dr3Var = a;
            if (dr3Var == null) {
                a = new dr3(str);
            } else {
                dr3Var.n(str);
            }
        }
    }
}
