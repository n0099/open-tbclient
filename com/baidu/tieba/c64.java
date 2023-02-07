package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class c64 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile b64 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized b64 a() {
        InterceptResult invokeV;
        b64 b64Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (c64.class) {
                if (a == null) {
                    a = new b64();
                }
                b64Var = a;
            }
            return b64Var;
        }
        return (b64) invokeV.objValue;
    }
}
