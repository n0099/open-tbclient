package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class ew8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile dw8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized dw8 a() {
        InterceptResult invokeV;
        dw8 dw8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ew8.class) {
                if (a == null) {
                    a = new dw8();
                }
                dw8Var = a;
            }
            return dw8Var;
        }
        return (dw8) invokeV.objValue;
    }
}
