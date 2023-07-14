package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class dx3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile cx3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized cx3 a() {
        InterceptResult invokeV;
        cx3 cx3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (dx3.class) {
                if (a == null) {
                    a = new cx3();
                }
                cx3Var = a;
            }
            return cx3Var;
        }
        return (cx3) invokeV.objValue;
    }
}
