package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class i84 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile h84 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized h84 a() {
        InterceptResult invokeV;
        h84 h84Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (i84.class) {
                if (a == null) {
                    a = new h84();
                }
                h84Var = a;
            }
            return h84Var;
        }
        return (h84) invokeV.objValue;
    }
}
