package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class i8a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile h8a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized h8a a() {
        InterceptResult invokeV;
        h8a h8aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (i8a.class) {
                if (a == null) {
                    a = new h8a();
                }
                h8aVar = a;
            }
            return h8aVar;
        }
        return (h8a) invokeV.objValue;
    }
}
