package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class eu5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile du5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized du5 a() {
        InterceptResult invokeV;
        du5 du5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (eu5.class) {
                if (a == null) {
                    a = new du5();
                }
                du5Var = a;
            }
            return du5Var;
        }
        return (du5) invokeV.objValue;
    }
}
