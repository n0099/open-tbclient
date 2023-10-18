package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class i64 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile h64 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized h64 a() {
        InterceptResult invokeV;
        h64 h64Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (i64.class) {
                if (a == null) {
                    a = new h64();
                }
                h64Var = a;
            }
            return h64Var;
        }
        return (h64) invokeV.objValue;
    }
}
