package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class e26 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile d26 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized d26 a() {
        InterceptResult invokeV;
        d26 d26Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (e26.class) {
                if (a == null) {
                    a = new d26();
                }
                d26Var = a;
            }
            return d26Var;
        }
        return (d26) invokeV.objValue;
    }
}
