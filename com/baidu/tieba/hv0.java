package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class hv0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile gv0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized gv0 a() {
        InterceptResult invokeV;
        gv0 gv0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (hv0.class) {
                if (a == null) {
                    a = new gv0();
                }
                gv0Var = a;
            }
            return gv0Var;
        }
        return (gv0) invokeV.objValue;
    }
}
