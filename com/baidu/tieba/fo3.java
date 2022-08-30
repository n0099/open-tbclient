package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class fo3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile eo3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized eo3 a() {
        InterceptResult invokeV;
        eo3 eo3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (fo3.class) {
                if (a == null) {
                    a = new eo3();
                }
                eo3Var = a;
            }
            return eo3Var;
        }
        return (eo3) invokeV.objValue;
    }
}
