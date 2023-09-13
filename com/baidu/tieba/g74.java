package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class g74 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile f74 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized f74 a() {
        InterceptResult invokeV;
        f74 f74Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (g74.class) {
                if (a == null) {
                    a = new f74();
                }
                f74Var = a;
            }
            return f74Var;
        }
        return (f74) invokeV.objValue;
    }
}
