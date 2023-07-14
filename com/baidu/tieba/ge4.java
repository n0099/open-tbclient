package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ge4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile fe4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized fe4 a() {
        InterceptResult invokeV;
        fe4 fe4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ge4.class) {
                if (a == null) {
                    a = new fe4();
                }
                fe4Var = a;
            }
            return fe4Var;
        }
        return (fe4) invokeV.objValue;
    }
}
