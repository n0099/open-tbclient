package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class cr9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile br9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized br9 a() {
        InterceptResult invokeV;
        br9 br9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (cr9.class) {
                if (a == null) {
                    a = new br9();
                }
                br9Var = a;
            }
            return br9Var;
        }
        return (br9) invokeV.objValue;
    }
}
