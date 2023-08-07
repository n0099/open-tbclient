package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class i34 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile h34 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized h34 a() {
        InterceptResult invokeV;
        h34 h34Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (i34.class) {
                if (a == null) {
                    a = new h34();
                }
                h34Var = a;
            }
            return h34Var;
        }
        return (h34) invokeV.objValue;
    }
}
