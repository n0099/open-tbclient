package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ci9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile bi9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized bi9 a() {
        InterceptResult invokeV;
        bi9 bi9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ci9.class) {
                if (a == null) {
                    a = new bi9();
                }
                bi9Var = a;
            }
            return bi9Var;
        }
        return (bi9) invokeV.objValue;
    }
}
