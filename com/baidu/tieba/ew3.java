package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class ew3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile dw3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized dw3 a() {
        InterceptResult invokeV;
        dw3 dw3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ew3.class) {
                if (a == null) {
                    a = new dw3();
                }
                dw3Var = a;
            }
            return dw3Var;
        }
        return (dw3) invokeV.objValue;
    }
}
