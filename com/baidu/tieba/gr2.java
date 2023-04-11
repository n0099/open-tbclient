package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class gr2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile fr2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized fr2 a() {
        InterceptResult invokeV;
        fr2 fr2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (gr2.class) {
                if (a == null) {
                    a = new fr2();
                }
                fr2Var = a;
            }
            return fr2Var;
        }
        return (fr2) invokeV.objValue;
    }
}
