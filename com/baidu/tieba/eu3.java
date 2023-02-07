package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class eu3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile du3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized du3 a() {
        InterceptResult invokeV;
        du3 du3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (eu3.class) {
                if (a == null) {
                    a = new du3();
                }
                du3Var = a;
            }
            return du3Var;
        }
        return (du3) invokeV.objValue;
    }
}
