package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class gi9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile fi9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized fi9 a() {
        InterceptResult invokeV;
        fi9 fi9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (gi9.class) {
                if (a == null) {
                    a = new fi9();
                }
                fi9Var = a;
            }
            return fi9Var;
        }
        return (fi9) invokeV.objValue;
    }
}
