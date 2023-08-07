package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class c4a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile b4a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized b4a a() {
        InterceptResult invokeV;
        b4a b4aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (c4a.class) {
                if (a == null) {
                    a = new b4a();
                }
                b4aVar = a;
            }
            return b4aVar;
        }
        return (b4a) invokeV.objValue;
    }
}
