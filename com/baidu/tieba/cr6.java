package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class cr6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile br6 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized br6 a() {
        InterceptResult invokeV;
        br6 br6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (cr6.class) {
                if (a == null) {
                    a = new br6();
                }
                br6Var = a;
            }
            return br6Var;
        }
        return (br6) invokeV.objValue;
    }
}
