package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class g43 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile f43 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized f43 a() {
        InterceptResult invokeV;
        f43 f43Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (g43.class) {
                if (a == null) {
                    a = new f43();
                }
                f43Var = a;
            }
            return f43Var;
        }
        return (f43) invokeV.objValue;
    }
}
