package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class a5a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile z4a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized z4a a() {
        InterceptResult invokeV;
        z4a z4aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (a5a.class) {
                if (a == null) {
                    a = new z4a();
                }
                z4aVar = a;
            }
            return z4aVar;
        }
        return (z4a) invokeV.objValue;
    }
}
