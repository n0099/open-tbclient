package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class fp3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ep3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ep3 a() {
        InterceptResult invokeV;
        ep3 ep3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (fp3.class) {
                if (a == null) {
                    a = new ep3();
                }
                ep3Var = a;
            }
            return ep3Var;
        }
        return (ep3) invokeV.objValue;
    }
}
