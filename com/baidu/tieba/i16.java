package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class i16 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile h16 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized h16 a() {
        InterceptResult invokeV;
        h16 h16Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (i16.class) {
                if (a == null) {
                    a = new h16();
                }
                h16Var = a;
            }
            return h16Var;
        }
        return (h16) invokeV.objValue;
    }
}
