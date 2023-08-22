package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class f9a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile e9a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized e9a a() {
        InterceptResult invokeV;
        e9a e9aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (f9a.class) {
                if (a == null) {
                    a = new e9a();
                }
                e9aVar = a;
            }
            return e9aVar;
        }
        return (e9a) invokeV.objValue;
    }
}
