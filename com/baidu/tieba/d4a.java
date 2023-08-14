package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class d4a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile c4a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized c4a a() {
        InterceptResult invokeV;
        c4a c4aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (d4a.class) {
                if (a == null) {
                    a = new c4a();
                }
                c4aVar = a;
            }
            return c4aVar;
        }
        return (c4a) invokeV.objValue;
    }
}
