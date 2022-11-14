package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class g14 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile f14 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized f14 a() {
        InterceptResult invokeV;
        f14 f14Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (g14.class) {
                if (a == null) {
                    a = new f14();
                }
                f14Var = a;
            }
            return f14Var;
        }
        return (f14) invokeV.objValue;
    }
}
