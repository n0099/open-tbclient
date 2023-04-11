package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class e36 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile d36 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized d36 a() {
        InterceptResult invokeV;
        d36 d36Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (e36.class) {
                if (a == null) {
                    a = new d36();
                }
                d36Var = a;
            }
            return d36Var;
        }
        return (d36) invokeV.objValue;
    }
}
