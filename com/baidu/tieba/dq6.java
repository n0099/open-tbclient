package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class dq6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile cq6 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized cq6 a() {
        InterceptResult invokeV;
        cq6 cq6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (dq6.class) {
                if (a == null) {
                    a = new cq6();
                }
                cq6Var = a;
            }
            return cq6Var;
        }
        return (cq6) invokeV.objValue;
    }
}
