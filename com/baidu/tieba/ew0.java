package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class ew0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile dw0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized dw0 a() {
        InterceptResult invokeV;
        dw0 dw0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ew0.class) {
                if (a == null) {
                    a = new dw0();
                }
                dw0Var = a;
            }
            return dw0Var;
        }
        return (dw0) invokeV.objValue;
    }
}
