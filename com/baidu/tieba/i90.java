package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class i90 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile h90 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized h90 a() {
        InterceptResult invokeV;
        h90 h90Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (i90.class) {
                if (a == null) {
                    a = new h90();
                }
                h90Var = a;
            }
            return h90Var;
        }
        return (h90) invokeV.objValue;
    }
}
