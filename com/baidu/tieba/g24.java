package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class g24 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile f24 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized f24 a() {
        InterceptResult invokeV;
        f24 f24Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (g24.class) {
                if (a == null) {
                    a = new f24();
                }
                f24Var = a;
            }
            return f24Var;
        }
        return (f24) invokeV.objValue;
    }
}
