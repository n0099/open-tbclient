package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class d20 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile i20 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static i20 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (a == null) {
                a = new j20();
            }
            return a;
        }
        return (i20) invokeV.objValue;
    }
}
