package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class fs5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile es5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized es5 a() {
        InterceptResult invokeV;
        es5 es5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (fs5.class) {
                if (a == null) {
                    a = new es5();
                }
                es5Var = a;
            }
            return es5Var;
        }
        return (es5) invokeV.objValue;
    }
}
