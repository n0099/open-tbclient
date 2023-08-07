package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ef4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile df4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized df4 a() {
        InterceptResult invokeV;
        df4 df4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ef4.class) {
                if (a == null) {
                    a = new df4();
                }
                df4Var = a;
            }
            return df4Var;
        }
        return (df4) invokeV.objValue;
    }
}
