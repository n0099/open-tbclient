package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class dx0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile cx0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized cx0 a() {
        InterceptResult invokeV;
        cx0 cx0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (dx0.class) {
                if (a == null) {
                    a = new cx0();
                }
                cx0Var = a;
            }
            return cx0Var;
        }
        return (cx0) invokeV.objValue;
    }
}
