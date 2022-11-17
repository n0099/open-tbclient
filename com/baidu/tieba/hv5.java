package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class hv5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile gv5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized gv5 a() {
        InterceptResult invokeV;
        gv5 gv5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (hv5.class) {
                if (a == null) {
                    a = new gv5();
                }
                gv5Var = a;
            }
            return gv5Var;
        }
        return (gv5) invokeV.objValue;
    }
}
