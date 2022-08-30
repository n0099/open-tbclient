package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class hq5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile gq5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized gq5 a() {
        InterceptResult invokeV;
        gq5 gq5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (hq5.class) {
                if (a == null) {
                    a = new gq5();
                }
                gq5Var = a;
            }
            return gq5Var;
        }
        return (gq5) invokeV.objValue;
    }
}
