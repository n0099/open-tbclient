package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class e20 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile j20 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static j20 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (a == null) {
                a = new k20();
            }
            return a;
        }
        return (j20) invokeV.objValue;
    }
}
