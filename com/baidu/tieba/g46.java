package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class g46 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile f46 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized f46 a() {
        InterceptResult invokeV;
        f46 f46Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (g46.class) {
                if (a == null) {
                    a = new f46();
                }
                f46Var = a;
            }
            return f46Var;
        }
        return (f46) invokeV.objValue;
    }
}
