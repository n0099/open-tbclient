package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class h7a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile g7a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized g7a a() {
        InterceptResult invokeV;
        g7a g7aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (h7a.class) {
                if (a == null) {
                    a = new g7a();
                }
                g7aVar = a;
            }
            return g7aVar;
        }
        return (g7a) invokeV.objValue;
    }
}
