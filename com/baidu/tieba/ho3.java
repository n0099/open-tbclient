package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class ho3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile go3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized go3 a() {
        InterceptResult invokeV;
        go3 go3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ho3.class) {
                if (a == null) {
                    a = new go3();
                }
                go3Var = a;
            }
            return go3Var;
        }
        return (go3) invokeV.objValue;
    }
}
