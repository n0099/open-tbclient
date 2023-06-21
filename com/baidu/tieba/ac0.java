package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class ac0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile zb0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized zb0 a() {
        InterceptResult invokeV;
        zb0 zb0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ac0.class) {
                if (a == null) {
                    a = new zb0();
                }
                zb0Var = a;
            }
            return zb0Var;
        }
        return (zb0) invokeV.objValue;
    }
}
