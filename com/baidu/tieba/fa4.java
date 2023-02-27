package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class fa4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ea4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ea4 a() {
        InterceptResult invokeV;
        ea4 ea4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (fa4.class) {
                if (a == null) {
                    a = new ea4();
                }
                ea4Var = a;
            }
            return ea4Var;
        }
        return (ea4) invokeV.objValue;
    }
}
