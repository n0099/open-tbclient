package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class g66 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile f66 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized f66 a() {
        InterceptResult invokeV;
        f66 f66Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (g66.class) {
                if (a == null) {
                    a = new f66();
                }
                f66Var = a;
            }
            return f66Var;
        }
        return (f66) invokeV.objValue;
    }
}
