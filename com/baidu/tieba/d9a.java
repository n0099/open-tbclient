package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class d9a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile c9a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized c9a a() {
        InterceptResult invokeV;
        c9a c9aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (d9a.class) {
                if (a == null) {
                    a = new c9a();
                }
                c9aVar = a;
            }
            return c9aVar;
        }
        return (c9a) invokeV.objValue;
    }
}
