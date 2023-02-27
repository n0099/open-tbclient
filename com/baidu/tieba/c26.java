package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class c26 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile b26 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized b26 a() {
        InterceptResult invokeV;
        b26 b26Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (c26.class) {
                if (a == null) {
                    a = new b26();
                }
                b26Var = a;
            }
            return b26Var;
        }
        return (b26) invokeV.objValue;
    }
}
