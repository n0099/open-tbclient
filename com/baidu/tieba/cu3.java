package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class cu3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile bu3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized bu3 a() {
        InterceptResult invokeV;
        bu3 bu3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (cu3.class) {
                if (a == null) {
                    a = new bu3();
                }
                bu3Var = a;
            }
            return bu3Var;
        }
        return (bu3) invokeV.objValue;
    }
}
