package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class eg4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile dg4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized dg4 a() {
        InterceptResult invokeV;
        dg4 dg4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (eg4.class) {
                if (a == null) {
                    a = new dg4();
                }
                dg4Var = a;
            }
            return dg4Var;
        }
        return (dg4) invokeV.objValue;
    }
}
