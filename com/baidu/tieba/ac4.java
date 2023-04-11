package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class ac4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile zb4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized zb4 a() {
        InterceptResult invokeV;
        zb4 zb4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ac4.class) {
                if (a == null) {
                    a = new zb4();
                }
                zb4Var = a;
            }
            return zb4Var;
        }
        return (zb4) invokeV.objValue;
    }
}
