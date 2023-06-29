package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class fe4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ee4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ee4 a() {
        InterceptResult invokeV;
        ee4 ee4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (fe4.class) {
                if (a == null) {
                    a = new ee4();
                }
                ee4Var = a;
            }
            return ee4Var;
        }
        return (ee4) invokeV.objValue;
    }
}
