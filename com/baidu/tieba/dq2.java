package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class dq2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile cq2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized cq2 a() {
        InterceptResult invokeV;
        cq2 cq2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (dq2.class) {
                if (a == null) {
                    a = new cq2();
                }
                cq2Var = a;
            }
            return cq2Var;
        }
        return (cq2) invokeV.objValue;
    }
}
