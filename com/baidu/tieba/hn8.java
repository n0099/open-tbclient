package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class hn8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile gn8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized gn8 a() {
        InterceptResult invokeV;
        gn8 gn8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (hn8.class) {
                if (a == null) {
                    a = new gn8();
                }
                gn8Var = a;
            }
            return gn8Var;
        }
        return (gn8) invokeV.objValue;
    }
}
