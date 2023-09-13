package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class fs3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile es3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized es3 a() {
        InterceptResult invokeV;
        es3 es3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (fs3.class) {
                if (a == null) {
                    a = new es3();
                }
                es3Var = a;
            }
            return es3Var;
        }
        return (es3) invokeV.objValue;
    }
}
