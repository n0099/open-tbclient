package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class h06 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile g06 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized g06 a() {
        InterceptResult invokeV;
        g06 g06Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (h06.class) {
                if (a == null) {
                    a = new g06();
                }
                g06Var = a;
            }
            return g06Var;
        }
        return (g06) invokeV.objValue;
    }
}
