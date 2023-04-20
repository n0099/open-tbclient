package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class f36 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile e36 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized e36 a() {
        InterceptResult invokeV;
        e36 e36Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (f36.class) {
                if (a == null) {
                    a = new e36();
                }
                e36Var = a;
            }
            return e36Var;
        }
        return (e36) invokeV.objValue;
    }
}
