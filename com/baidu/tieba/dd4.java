package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class dd4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile cd4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized cd4 a() {
        InterceptResult invokeV;
        cd4 cd4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (dd4.class) {
                if (a == null) {
                    a = new cd4();
                }
                cd4Var = a;
            }
            return cd4Var;
        }
        return (cd4) invokeV.objValue;
    }
}
