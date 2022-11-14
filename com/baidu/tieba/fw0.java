package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class fw0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ew0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ew0 a() {
        InterceptResult invokeV;
        ew0 ew0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (fw0.class) {
                if (a == null) {
                    a = new ew0();
                }
                ew0Var = a;
            }
            return ew0Var;
        }
        return (ew0) invokeV.objValue;
    }
}
