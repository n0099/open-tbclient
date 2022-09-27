package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class aq3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile zp3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized zp3 a() {
        InterceptResult invokeV;
        zp3 zp3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (aq3.class) {
                if (a == null) {
                    a = new zp3();
                }
                zp3Var = a;
            }
            return zp3Var;
        }
        return (zp3) invokeV.objValue;
    }
}
