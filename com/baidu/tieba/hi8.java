package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class hi8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile gi8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized gi8 a() {
        InterceptResult invokeV;
        gi8 gi8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (hi8.class) {
                if (a == null) {
                    a = new gi8();
                }
                gi8Var = a;
            }
            return gi8Var;
        }
        return (gi8) invokeV.objValue;
    }
}
