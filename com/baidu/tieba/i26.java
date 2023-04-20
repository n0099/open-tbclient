package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class i26 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile h26 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized h26 a() {
        InterceptResult invokeV;
        h26 h26Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (i26.class) {
                if (a == null) {
                    a = new h26();
                }
                h26Var = a;
            }
            return h26Var;
        }
        return (h26) invokeV.objValue;
    }
}
