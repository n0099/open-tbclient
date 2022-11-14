package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class hw0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile gw0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized gw0 a() {
        InterceptResult invokeV;
        gw0 gw0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (hw0.class) {
                if (a == null) {
                    a = new gw0();
                }
                gw0Var = a;
            }
            return gw0Var;
        }
        return (gw0) invokeV.objValue;
    }
}
