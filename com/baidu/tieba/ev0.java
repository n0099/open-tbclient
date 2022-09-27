package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class ev0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile dv0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized dv0 a() {
        InterceptResult invokeV;
        dv0 dv0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ev0.class) {
                if (a == null) {
                    a = new dv0();
                }
                dv0Var = a;
            }
            return dv0Var;
        }
        return (dv0) invokeV.objValue;
    }
}
