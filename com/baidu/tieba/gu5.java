package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class gu5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile fu5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized fu5 a() {
        InterceptResult invokeV;
        fu5 fu5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (gu5.class) {
                if (a == null) {
                    a = new fu5();
                }
                fu5Var = a;
            }
            return fu5Var;
        }
        return (fu5) invokeV.objValue;
    }
}
