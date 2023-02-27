package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class f26 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile e26 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized e26 a() {
        InterceptResult invokeV;
        e26 e26Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (f26.class) {
                if (a == null) {
                    a = new e26();
                }
                e26Var = a;
            }
            return e26Var;
        }
        return (e26) invokeV.objValue;
    }
}
