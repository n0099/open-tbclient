package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class er2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile dr2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized dr2 a() {
        InterceptResult invokeV;
        dr2 dr2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (er2.class) {
                if (a == null) {
                    a = new dr2();
                }
                dr2Var = a;
            }
            return dr2Var;
        }
        return (dr2) invokeV.objValue;
    }
}
