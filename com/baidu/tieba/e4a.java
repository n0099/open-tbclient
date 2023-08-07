package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class e4a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile d4a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized d4a a() {
        InterceptResult invokeV;
        d4a d4aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (e4a.class) {
                if (a == null) {
                    a = new d4a();
                }
                d4aVar = a;
            }
            return d4aVar;
        }
        return (d4a) invokeV.objValue;
    }
}
