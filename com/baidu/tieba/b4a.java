package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class b4a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile a4a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized a4a a() {
        InterceptResult invokeV;
        a4a a4aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (b4a.class) {
                if (a == null) {
                    a = new a4a();
                }
                a4aVar = a;
            }
            return a4aVar;
        }
        return (a4a) invokeV.objValue;
    }
}
