package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class at3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile zs3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized zs3 a() {
        InterceptResult invokeV;
        zs3 zs3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (at3.class) {
                if (a == null) {
                    a = new zs3();
                }
                zs3Var = a;
            }
            return zs3Var;
        }
        return (zs3) invokeV.objValue;
    }
}
