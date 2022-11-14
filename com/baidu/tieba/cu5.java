package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class cu5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile bu5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized bu5 a() {
        InterceptResult invokeV;
        bu5 bu5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (cu5.class) {
                if (a == null) {
                    a = new bu5();
                }
                bu5Var = a;
            }
            return bu5Var;
        }
        return (bu5) invokeV.objValue;
    }
}
