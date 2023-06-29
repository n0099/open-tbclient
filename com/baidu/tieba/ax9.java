package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ax9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile zw9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized zw9 a() {
        InterceptResult invokeV;
        zw9 zw9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ax9.class) {
                if (a == null) {
                    a = new zw9();
                }
                zw9Var = a;
            }
            return zw9Var;
        }
        return (zw9) invokeV.objValue;
    }
}
