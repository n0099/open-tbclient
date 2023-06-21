package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class az3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile zy3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized zy3 a() {
        InterceptResult invokeV;
        zy3 zy3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (az3.class) {
                if (a == null) {
                    a = new zy3();
                }
                zy3Var = a;
            }
            return zy3Var;
        }
        return (zy3) invokeV.objValue;
    }
}
