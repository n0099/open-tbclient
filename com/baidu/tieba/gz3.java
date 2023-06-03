package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class gz3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile fz3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized fz3 a() {
        InterceptResult invokeV;
        fz3 fz3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (gz3.class) {
                if (a == null) {
                    a = new fz3();
                }
                fz3Var = a;
            }
            return fz3Var;
        }
        return (fz3) invokeV.objValue;
    }
}
