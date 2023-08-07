package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class g4a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile f4a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized f4a a() {
        InterceptResult invokeV;
        f4a f4aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (g4a.class) {
                if (a == null) {
                    a = new f4a();
                }
                f4aVar = a;
            }
            return f4aVar;
        }
        return (f4a) invokeV.objValue;
    }
}
