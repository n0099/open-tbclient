package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class a69 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile z59 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized z59 a() {
        InterceptResult invokeV;
        z59 z59Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (a69.class) {
                if (a == null) {
                    a = new z59();
                }
                z59Var = a;
            }
            return z59Var;
        }
        return (z59) invokeV.objValue;
    }
}
