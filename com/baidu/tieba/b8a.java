package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class b8a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile a8a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized a8a a() {
        InterceptResult invokeV;
        a8a a8aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (b8a.class) {
                if (a == null) {
                    a = new a8a();
                }
                a8aVar = a;
            }
            return a8aVar;
        }
        return (a8a) invokeV.objValue;
    }
}
