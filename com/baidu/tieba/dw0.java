package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class dw0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile cw0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized cw0 a() {
        InterceptResult invokeV;
        cw0 cw0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (dw0.class) {
                if (a == null) {
                    a = new cw0();
                }
                cw0Var = a;
            }
            return cw0Var;
        }
        return (cw0) invokeV.objValue;
    }
}
