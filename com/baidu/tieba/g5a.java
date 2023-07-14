package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class g5a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile f5a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized f5a a() {
        InterceptResult invokeV;
        f5a f5aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (g5a.class) {
                if (a == null) {
                    a = new f5a();
                }
                f5aVar = a;
            }
            return f5aVar;
        }
        return (f5a) invokeV.objValue;
    }
}
