package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class aq5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile zp5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized zp5 a() {
        InterceptResult invokeV;
        zp5 zp5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (aq5.class) {
                if (a == null) {
                    a = new zp5();
                }
                zp5Var = a;
            }
            return zp5Var;
        }
        return (zp5) invokeV.objValue;
    }
}
