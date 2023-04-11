package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class i36 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile h36 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized h36 a() {
        InterceptResult invokeV;
        h36 h36Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (i36.class) {
                if (a == null) {
                    a = new h36();
                }
                h36Var = a;
            }
            return h36Var;
        }
        return (h36) invokeV.objValue;
    }
}
