package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class hn2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile gn2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized gn2 a() {
        InterceptResult invokeV;
        gn2 gn2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (hn2.class) {
                if (a == null) {
                    a = new gn2();
                }
                gn2Var = a;
            }
            return gn2Var;
        }
        return (gn2) invokeV.objValue;
    }
}
