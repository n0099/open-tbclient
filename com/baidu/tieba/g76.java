package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class g76 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile f76 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized f76 a() {
        InterceptResult invokeV;
        f76 f76Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (g76.class) {
                if (a == null) {
                    a = new f76();
                }
                f76Var = a;
            }
            return f76Var;
        }
        return (f76) invokeV.objValue;
    }
}
