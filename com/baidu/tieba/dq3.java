package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class dq3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile cq3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized cq3 a() {
        InterceptResult invokeV;
        cq3 cq3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (dq3.class) {
                if (a == null) {
                    a = new cq3();
                }
                cq3Var = a;
            }
            return cq3Var;
        }
        return (cq3) invokeV.objValue;
    }
}
