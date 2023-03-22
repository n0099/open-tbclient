package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class bw0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile aw0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized aw0 a() {
        InterceptResult invokeV;
        aw0 aw0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (bw0.class) {
                if (a == null) {
                    a = new aw0();
                }
                aw0Var = a;
            }
            return aw0Var;
        }
        return (aw0) invokeV.objValue;
    }
}
