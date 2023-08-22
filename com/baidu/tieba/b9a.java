package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class b9a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile a9a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized a9a a() {
        InterceptResult invokeV;
        a9a a9aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (b9a.class) {
                if (a == null) {
                    a = new a9a();
                }
                a9aVar = a;
            }
            return a9aVar;
        }
        return (a9a) invokeV.objValue;
    }
}
