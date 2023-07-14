package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class d6a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile c6a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized c6a a() {
        InterceptResult invokeV;
        c6a c6aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (d6a.class) {
                if (a == null) {
                    a = new c6a();
                }
                c6aVar = a;
            }
            return c6aVar;
        }
        return (c6a) invokeV.objValue;
    }
}
