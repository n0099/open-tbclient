package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class gu3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile fu3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized fu3 a() {
        InterceptResult invokeV;
        fu3 fu3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (gu3.class) {
                if (a == null) {
                    a = new fu3();
                }
                fu3Var = a;
            }
            return fu3Var;
        }
        return (fu3) invokeV.objValue;
    }
}
