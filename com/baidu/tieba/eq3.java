package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class eq3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile dq3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized dq3 a() {
        InterceptResult invokeV;
        dq3 dq3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (eq3.class) {
                if (a == null) {
                    a = new dq3();
                }
                dq3Var = a;
            }
            return dq3Var;
        }
        return (dq3) invokeV.objValue;
    }
}
