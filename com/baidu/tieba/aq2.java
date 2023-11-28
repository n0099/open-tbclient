package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class aq2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile zp2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized zp2 a() {
        InterceptResult invokeV;
        zp2 zp2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (aq2.class) {
                if (a == null) {
                    a = new zp2();
                }
                zp2Var = a;
            }
            return zp2Var;
        }
        return (zp2) invokeV.objValue;
    }
}
