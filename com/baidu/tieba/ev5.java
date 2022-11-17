package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class ev5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile dv5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized dv5 a() {
        InterceptResult invokeV;
        dv5 dv5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ev5.class) {
                if (a == null) {
                    a = new dv5();
                }
                dv5Var = a;
            }
            return dv5Var;
        }
        return (dv5) invokeV.objValue;
    }
}
