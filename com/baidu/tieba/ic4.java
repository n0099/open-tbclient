package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class ic4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile hc4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized hc4 a() {
        InterceptResult invokeV;
        hc4 hc4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ic4.class) {
                if (a == null) {
                    a = new hc4();
                }
                hc4Var = a;
            }
            return hc4Var;
        }
        return (hc4) invokeV.objValue;
    }
}
