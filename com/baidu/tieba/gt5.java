package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class gt5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ft5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ft5 a() {
        InterceptResult invokeV;
        ft5 ft5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (gt5.class) {
                if (a == null) {
                    a = new ft5();
                }
                ft5Var = a;
            }
            return ft5Var;
        }
        return (ft5) invokeV.objValue;
    }
}
