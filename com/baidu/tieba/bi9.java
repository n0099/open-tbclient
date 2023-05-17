package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class bi9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ai9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ai9 a() {
        InterceptResult invokeV;
        ai9 ai9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (bi9.class) {
                if (a == null) {
                    a = new ai9();
                }
                ai9Var = a;
            }
            return ai9Var;
        }
        return (ai9) invokeV.objValue;
    }
}
