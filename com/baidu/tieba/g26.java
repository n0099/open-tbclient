package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class g26 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile f26 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized f26 a() {
        InterceptResult invokeV;
        f26 f26Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (g26.class) {
                if (a == null) {
                    a = new f26();
                }
                f26Var = a;
            }
            return f26Var;
        }
        return (f26) invokeV.objValue;
    }
}
