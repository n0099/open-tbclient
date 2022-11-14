package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class aw0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile zv0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized zv0 a() {
        InterceptResult invokeV;
        zv0 zv0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (aw0.class) {
                if (a == null) {
                    a = new zv0();
                }
                zv0Var = a;
            }
            return zv0Var;
        }
        return (zv0) invokeV.objValue;
    }
}
