package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class hw3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile gw3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized gw3 a() {
        InterceptResult invokeV;
        gw3 gw3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (hw3.class) {
                if (a == null) {
                    a = new gw3();
                }
                gw3Var = a;
            }
            return gw3Var;
        }
        return (gw3) invokeV.objValue;
    }
}
