package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class hr3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile gr3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized gr3 a() {
        InterceptResult invokeV;
        gr3 gr3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (hr3.class) {
                if (a == null) {
                    a = new gr3();
                }
                gr3Var = a;
            }
            return gr3Var;
        }
        return (gr3) invokeV.objValue;
    }
}
