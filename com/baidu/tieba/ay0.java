package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class ay0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile zx0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized zx0 a() {
        InterceptResult invokeV;
        zx0 zx0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ay0.class) {
                if (a == null) {
                    a = new zx0();
                }
                zx0Var = a;
            }
            return zx0Var;
        }
        return (zx0) invokeV.objValue;
    }
}
