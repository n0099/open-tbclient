package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class as3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile zr3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized zr3 a() {
        InterceptResult invokeV;
        zr3 zr3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (as3.class) {
                if (a == null) {
                    a = new zr3();
                }
                zr3Var = a;
            }
            return zr3Var;
        }
        return (zr3) invokeV.objValue;
    }
}
