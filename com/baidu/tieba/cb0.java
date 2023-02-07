package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class cb0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile bb0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized bb0 a() {
        InterceptResult invokeV;
        bb0 bb0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (cb0.class) {
                if (a == null) {
                    a = new bb0();
                }
                bb0Var = a;
            }
            return bb0Var;
        }
        return (bb0) invokeV.objValue;
    }
}
