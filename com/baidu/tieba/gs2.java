package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class gs2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile fs2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized fs2 a() {
        InterceptResult invokeV;
        fs2 fs2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (gs2.class) {
                if (a == null) {
                    a = new fs2();
                }
                fs2Var = a;
            }
            return fs2Var;
        }
        return (fs2) invokeV.objValue;
    }
}
