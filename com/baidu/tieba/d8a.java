package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class d8a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile c8a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized c8a a() {
        InterceptResult invokeV;
        c8a c8aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (d8a.class) {
                if (a == null) {
                    a = new c8a();
                }
                c8aVar = a;
            }
            return c8aVar;
        }
        return (c8a) invokeV.objValue;
    }
}
