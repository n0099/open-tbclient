package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class g20 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile k20 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static k20 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (a == null) {
                a = new l20();
            }
            return a;
        }
        return (k20) invokeV.objValue;
    }
}
