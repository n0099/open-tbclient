package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class h04 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile g04 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized g04 a() {
        InterceptResult invokeV;
        g04 g04Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (h04.class) {
                if (a == null) {
                    a = new g04();
                }
                g04Var = a;
            }
            return g04Var;
        }
        return (g04) invokeV.objValue;
    }
}
