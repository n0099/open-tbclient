package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class hb4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile gb4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized gb4 a() {
        InterceptResult invokeV;
        gb4 gb4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (hb4.class) {
                if (a == null) {
                    a = new gb4();
                }
                gb4Var = a;
            }
            return gb4Var;
        }
        return (gb4) invokeV.objValue;
    }
}
