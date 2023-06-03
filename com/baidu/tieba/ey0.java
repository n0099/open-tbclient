package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ey0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile dy0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized dy0 a() {
        InterceptResult invokeV;
        dy0 dy0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ey0.class) {
                if (a == null) {
                    a = new dy0();
                }
                dy0Var = a;
            }
            return dy0Var;
        }
        return (dy0) invokeV.objValue;
    }
}
