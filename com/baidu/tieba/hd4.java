package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class hd4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile gd4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized gd4 a() {
        InterceptResult invokeV;
        gd4 gd4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (hd4.class) {
                if (a == null) {
                    a = new gd4();
                }
                gd4Var = a;
            }
            return gd4Var;
        }
        return (gd4) invokeV.objValue;
    }
}
