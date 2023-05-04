package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class hj9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile gj9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized gj9 a() {
        InterceptResult invokeV;
        gj9 gj9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (hj9.class) {
                if (a == null) {
                    a = new gj9();
                }
                gj9Var = a;
            }
            return gj9Var;
        }
        return (gj9) invokeV.objValue;
    }
}
