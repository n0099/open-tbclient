package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class b6a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile a6a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized a6a a() {
        InterceptResult invokeV;
        a6a a6aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (b6a.class) {
                if (a == null) {
                    a = new a6a();
                }
                a6aVar = a;
            }
            return a6aVar;
        }
        return (a6a) invokeV.objValue;
    }
}
