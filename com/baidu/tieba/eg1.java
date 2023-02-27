package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class eg1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile dg1 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized dg1 a() {
        InterceptResult invokeV;
        dg1 dg1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (eg1.class) {
                if (a == null) {
                    a = new dg1();
                }
                dg1Var = a;
            }
            return dg1Var;
        }
        return (dg1) invokeV.objValue;
    }
}
