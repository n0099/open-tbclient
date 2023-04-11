package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class d26 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile c26 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized c26 a() {
        InterceptResult invokeV;
        c26 c26Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (d26.class) {
                if (a == null) {
                    a = new c26();
                }
                c26Var = a;
            }
            return c26Var;
        }
        return (c26) invokeV.objValue;
    }
}
