package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class hm3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile gm3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized gm3 a() {
        InterceptResult invokeV;
        gm3 gm3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (hm3.class) {
                if (a == null) {
                    a = new gm3();
                }
                gm3Var = a;
            }
            return gm3Var;
        }
        return (gm3) invokeV.objValue;
    }
}
