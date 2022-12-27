package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class co8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile bo8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized bo8 a() {
        InterceptResult invokeV;
        bo8 bo8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (co8.class) {
                if (a == null) {
                    a = new bo8();
                }
                bo8Var = a;
            }
            return bo8Var;
        }
        return (bo8) invokeV.objValue;
    }
}
