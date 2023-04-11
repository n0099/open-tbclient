package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class cg9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile bg9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized bg9 a() {
        InterceptResult invokeV;
        bg9 bg9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (cg9.class) {
                if (a == null) {
                    a = new bg9();
                }
                bg9Var = a;
            }
            return bg9Var;
        }
        return (bg9) invokeV.objValue;
    }
}
