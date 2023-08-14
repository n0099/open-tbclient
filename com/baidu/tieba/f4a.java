package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class f4a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile e4a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized e4a a() {
        InterceptResult invokeV;
        e4a e4aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (f4a.class) {
                if (a == null) {
                    a = new e4a();
                }
                e4aVar = a;
            }
            return e4aVar;
        }
        return (e4a) invokeV.objValue;
    }
}
