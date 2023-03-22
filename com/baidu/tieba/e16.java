package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class e16 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile d16 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized d16 a() {
        InterceptResult invokeV;
        d16 d16Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (e16.class) {
                if (a == null) {
                    a = new d16();
                }
                d16Var = a;
            }
            return d16Var;
        }
        return (d16) invokeV.objValue;
    }
}
