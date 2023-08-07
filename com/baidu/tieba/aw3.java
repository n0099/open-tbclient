package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class aw3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile zv3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized zv3 a() {
        InterceptResult invokeV;
        zv3 zv3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (aw3.class) {
                if (a == null) {
                    a = new zv3();
                }
                zv3Var = a;
            }
            return zv3Var;
        }
        return (zv3) invokeV.objValue;
    }
}
