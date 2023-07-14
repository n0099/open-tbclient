package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class d5a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile c5a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized c5a a() {
        InterceptResult invokeV;
        c5a c5aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (d5a.class) {
                if (a == null) {
                    a = new c5a();
                }
                c5aVar = a;
            }
            return c5aVar;
        }
        return (c5a) invokeV.objValue;
    }
}
