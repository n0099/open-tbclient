package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class g86 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile f86 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized f86 a() {
        InterceptResult invokeV;
        f86 f86Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (g86.class) {
                if (a == null) {
                    a = new f86();
                }
                f86Var = a;
            }
            return f86Var;
        }
        return (f86) invokeV.objValue;
    }
}
