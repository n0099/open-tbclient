package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class h84 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile g84 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized g84 a() {
        InterceptResult invokeV;
        g84 g84Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (h84.class) {
                if (a == null) {
                    a = new g84();
                }
                g84Var = a;
            }
            return g84Var;
        }
        return (g84) invokeV.objValue;
    }
}
