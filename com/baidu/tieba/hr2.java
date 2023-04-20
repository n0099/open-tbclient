package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class hr2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile gr2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized gr2 a() {
        InterceptResult invokeV;
        gr2 gr2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (hr2.class) {
                if (a == null) {
                    a = new gr2();
                }
                gr2Var = a;
            }
            return gr2Var;
        }
        return (gr2) invokeV.objValue;
    }
}
