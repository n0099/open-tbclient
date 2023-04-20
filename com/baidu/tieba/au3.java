package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class au3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile zt3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized zt3 a() {
        InterceptResult invokeV;
        zt3 zt3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (au3.class) {
                if (a == null) {
                    a = new zt3();
                }
                zt3Var = a;
            }
            return zt3Var;
        }
        return (zt3) invokeV.objValue;
    }
}
