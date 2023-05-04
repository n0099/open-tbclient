package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class d54 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile c54 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized c54 a() {
        InterceptResult invokeV;
        c54 c54Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (d54.class) {
                if (a == null) {
                    a = new c54();
                }
                c54Var = a;
            }
            return c54Var;
        }
        return (c54) invokeV.objValue;
    }
}
