package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class hp3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile gp3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized gp3 a() {
        InterceptResult invokeV;
        gp3 gp3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (hp3.class) {
                if (a == null) {
                    a = new gp3();
                }
                gp3Var = a;
            }
            return gp3Var;
        }
        return (gp3) invokeV.objValue;
    }
}
