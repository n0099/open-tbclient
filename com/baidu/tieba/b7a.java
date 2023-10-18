package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class b7a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile a7a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized a7a a() {
        InterceptResult invokeV;
        a7a a7aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (b7a.class) {
                if (a == null) {
                    a = new a7a();
                }
                a7aVar = a;
            }
            return a7aVar;
        }
        return (a7a) invokeV.objValue;
    }
}
