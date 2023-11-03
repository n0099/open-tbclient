package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class cu0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile bu0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized bu0 a() {
        InterceptResult invokeV;
        bu0 bu0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (cu0.class) {
                if (a == null) {
                    a = new bu0();
                }
                bu0Var = a;
            }
            return bu0Var;
        }
        return (bu0) invokeV.objValue;
    }
}
