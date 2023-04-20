package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class c36 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile b36 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized b36 a() {
        InterceptResult invokeV;
        b36 b36Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (c36.class) {
                if (a == null) {
                    a = new b36();
                }
                b36Var = a;
            }
            return b36Var;
        }
        return (b36) invokeV.objValue;
    }
}
