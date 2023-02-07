package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class cd4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile bd4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized bd4 a() {
        InterceptResult invokeV;
        bd4 bd4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (cd4.class) {
                if (a == null) {
                    a = new bd4();
                }
                bd4Var = a;
            }
            return bd4Var;
        }
        return (bd4) invokeV.objValue;
    }
}
