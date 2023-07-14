package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class i5a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile h5a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized h5a a() {
        InterceptResult invokeV;
        h5a h5aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (i5a.class) {
                if (a == null) {
                    a = new h5a();
                }
                h5aVar = a;
            }
            return h5aVar;
        }
        return (h5a) invokeV.objValue;
    }
}
