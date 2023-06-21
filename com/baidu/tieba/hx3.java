package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class hx3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile gx3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized gx3 a() {
        InterceptResult invokeV;
        gx3 gx3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (hx3.class) {
                if (a == null) {
                    a = new gx3();
                }
                gx3Var = a;
            }
            return gx3Var;
        }
        return (gx3) invokeV.objValue;
    }
}
