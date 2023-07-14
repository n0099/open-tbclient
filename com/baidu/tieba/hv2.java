package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class hv2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile gv2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized gv2 a() {
        InterceptResult invokeV;
        gv2 gv2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (hv2.class) {
                if (a == null) {
                    a = new gv2();
                }
                gv2Var = a;
            }
            return gv2Var;
        }
        return (gv2) invokeV.objValue;
    }
}
