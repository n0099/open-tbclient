package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class i46 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile h46 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized h46 a() {
        InterceptResult invokeV;
        h46 h46Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (i46.class) {
                if (a == null) {
                    a = new h46();
                }
                h46Var = a;
            }
            return h46Var;
        }
        return (h46) invokeV.objValue;
    }
}
