package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class i76 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile h76 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized h76 a() {
        InterceptResult invokeV;
        h76 h76Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (i76.class) {
                if (a == null) {
                    a = new h76();
                }
                h76Var = a;
            }
            return h76Var;
        }
        return (h76) invokeV.objValue;
    }
}
