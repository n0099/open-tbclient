package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class i4a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile h4a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized h4a a() {
        InterceptResult invokeV;
        h4a h4aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (i4a.class) {
                if (a == null) {
                    a = new h4a();
                }
                h4aVar = a;
            }
            return h4aVar;
        }
        return (h4a) invokeV.objValue;
    }
}
