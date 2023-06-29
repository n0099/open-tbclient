package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class aw6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile zv6 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized zv6 a() {
        InterceptResult invokeV;
        zv6 zv6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (aw6.class) {
                if (a == null) {
                    a = new zv6();
                }
                zv6Var = a;
            }
            return zv6Var;
        }
        return (zv6) invokeV.objValue;
    }
}
