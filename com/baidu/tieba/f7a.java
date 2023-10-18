package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class f7a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile e7a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized e7a a() {
        InterceptResult invokeV;
        e7a e7aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (f7a.class) {
                if (a == null) {
                    a = new e7a();
                }
                e7aVar = a;
            }
            return e7aVar;
        }
        return (e7a) invokeV.objValue;
    }
}
