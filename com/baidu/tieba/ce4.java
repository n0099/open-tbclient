package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ce4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile be4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized be4 a() {
        InterceptResult invokeV;
        be4 be4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ce4.class) {
                if (a == null) {
                    a = new be4();
                }
                be4Var = a;
            }
            return be4Var;
        }
        return (be4) invokeV.objValue;
    }
}
