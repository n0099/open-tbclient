package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class ay3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile zx3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized zx3 a() {
        InterceptResult invokeV;
        zx3 zx3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ay3.class) {
                if (a == null) {
                    a = new zx3();
                }
                zx3Var = a;
            }
            return zx3Var;
        }
        return (zx3) invokeV.objValue;
    }
}
