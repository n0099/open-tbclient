package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class bm3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile am3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized am3 a() {
        InterceptResult invokeV;
        am3 am3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (bm3.class) {
                if (a == null) {
                    a = new am3();
                }
                am3Var = a;
            }
            return am3Var;
        }
        return (am3) invokeV.objValue;
    }
}
