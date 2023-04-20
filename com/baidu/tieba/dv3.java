package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class dv3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile cv3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized cv3 a() {
        InterceptResult invokeV;
        cv3 cv3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (dv3.class) {
                if (a == null) {
                    a = new cv3();
                }
                cv3Var = a;
            }
            return cv3Var;
        }
        return (cv3) invokeV.objValue;
    }
}
