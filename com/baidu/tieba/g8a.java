package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class g8a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile f8a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized f8a a() {
        InterceptResult invokeV;
        f8a f8aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (g8a.class) {
                if (a == null) {
                    a = new f8a();
                }
                f8aVar = a;
            }
            return f8aVar;
        }
        return (f8a) invokeV.objValue;
    }
}
