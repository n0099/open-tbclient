package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class g36 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile f36 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized f36 a() {
        InterceptResult invokeV;
        f36 f36Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (g36.class) {
                if (a == null) {
                    a = new f36();
                }
                f36Var = a;
            }
            return f36Var;
        }
        return (f36) invokeV.objValue;
    }
}
