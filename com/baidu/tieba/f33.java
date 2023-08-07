package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class f33 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile e33 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized e33 a() {
        InterceptResult invokeV;
        e33 e33Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (f33.class) {
                if (a == null) {
                    a = new e33();
                }
                e33Var = a;
            }
            return e33Var;
        }
        return (e33) invokeV.objValue;
    }
}
