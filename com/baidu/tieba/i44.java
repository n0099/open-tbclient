package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class i44 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile h44 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized h44 a() {
        InterceptResult invokeV;
        h44 h44Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (i44.class) {
                if (a == null) {
                    a = new h44();
                }
                h44Var = a;
            }
            return h44Var;
        }
        return (h44) invokeV.objValue;
    }
}
