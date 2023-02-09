package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class ax8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile zw8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized zw8 a() {
        InterceptResult invokeV;
        zw8 zw8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ax8.class) {
                if (a == null) {
                    a = new zw8();
                }
                zw8Var = a;
            }
            return zw8Var;
        }
        return (zw8) invokeV.objValue;
    }
}
