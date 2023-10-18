package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ax {
    public static /* synthetic */ Interceptable $ic;
    public static volatile fx a;
    public transient /* synthetic */ FieldHolder $fh;

    public static fx a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (a == null) {
                a = new gx();
            }
            return a;
        }
        return (fx) invokeV.objValue;
    }
}
