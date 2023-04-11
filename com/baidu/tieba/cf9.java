package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class cf9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile bf9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized bf9 a() {
        InterceptResult invokeV;
        bf9 bf9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (cf9.class) {
                if (a == null) {
                    a = new bf9();
                }
                bf9Var = a;
            }
            return bf9Var;
        }
        return (bf9) invokeV.objValue;
    }
}
