package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class i09 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile h09 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized h09 a() {
        InterceptResult invokeV;
        h09 h09Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (i09.class) {
                if (a == null) {
                    a = new h09();
                }
                h09Var = a;
            }
            return h09Var;
        }
        return (h09) invokeV.objValue;
    }
}
