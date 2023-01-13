package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class i04 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile h04 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized h04 a() {
        InterceptResult invokeV;
        h04 h04Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (i04.class) {
                if (a == null) {
                    a = new h04();
                }
                h04Var = a;
            }
            return h04Var;
        }
        return (h04) invokeV.objValue;
    }
}
