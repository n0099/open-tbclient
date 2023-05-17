package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class hx0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile gx0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized gx0 a() {
        InterceptResult invokeV;
        gx0 gx0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (hx0.class) {
                if (a == null) {
                    a = new gx0();
                }
                gx0Var = a;
            }
            return gx0Var;
        }
        return (gx0) invokeV.objValue;
    }
}
