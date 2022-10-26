package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class ej8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile dj8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized dj8 a() {
        InterceptResult invokeV;
        dj8 dj8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ej8.class) {
                if (a == null) {
                    a = new dj8();
                }
                dj8Var = a;
            }
            return dj8Var;
        }
        return (dj8) invokeV.objValue;
    }
}
