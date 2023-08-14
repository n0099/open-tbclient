package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class h4a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile g4a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized g4a a() {
        InterceptResult invokeV;
        g4a g4aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (h4a.class) {
                if (a == null) {
                    a = new g4a();
                }
                g4aVar = a;
            }
            return g4aVar;
        }
        return (g4a) invokeV.objValue;
    }
}
