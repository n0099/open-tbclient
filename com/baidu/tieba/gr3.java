package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class gr3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile fr3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized fr3 a() {
        InterceptResult invokeV;
        fr3 fr3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (gr3.class) {
                if (a == null) {
                    a = new fr3();
                }
                fr3Var = a;
            }
            return fr3Var;
        }
        return (fr3) invokeV.objValue;
    }
}
