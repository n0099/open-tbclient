package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class as5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile zr5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized zr5 a() {
        InterceptResult invokeV;
        zr5 zr5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (as5.class) {
                if (a == null) {
                    a = new zr5();
                }
                zr5Var = a;
            }
            return zr5Var;
        }
        return (zr5) invokeV.objValue;
    }
}
