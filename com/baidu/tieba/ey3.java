package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ey3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile dy3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized dy3 a() {
        InterceptResult invokeV;
        dy3 dy3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ey3.class) {
                if (a == null) {
                    a = new dy3();
                }
                dy3Var = a;
            }
            return dy3Var;
        }
        return (dy3) invokeV.objValue;
    }
}
