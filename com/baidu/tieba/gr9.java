package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class gr9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile fr9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized fr9 a() {
        InterceptResult invokeV;
        fr9 fr9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (gr9.class) {
                if (a == null) {
                    a = new fr9();
                }
                fr9Var = a;
            }
            return fr9Var;
        }
        return (fr9) invokeV.objValue;
    }
}
