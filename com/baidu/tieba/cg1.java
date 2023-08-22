package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class cg1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile bg1 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized bg1 a() {
        InterceptResult invokeV;
        bg1 bg1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (cg1.class) {
                if (a == null) {
                    a = new bg1();
                }
                bg1Var = a;
            }
            return bg1Var;
        }
        return (bg1) invokeV.objValue;
    }
}
