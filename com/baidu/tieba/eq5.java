package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class eq5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile dq5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized dq5 a() {
        InterceptResult invokeV;
        dq5 dq5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (eq5.class) {
                if (a == null) {
                    a = new dq5();
                }
                dq5Var = a;
            }
            return dq5Var;
        }
        return (dq5) invokeV.objValue;
    }
}
