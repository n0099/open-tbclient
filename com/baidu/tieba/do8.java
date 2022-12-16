package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class do8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile co8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized co8 a() {
        InterceptResult invokeV;
        co8 co8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (do8.class) {
                if (a == null) {
                    a = new co8();
                }
                co8Var = a;
            }
            return co8Var;
        }
        return (co8) invokeV.objValue;
    }
}
