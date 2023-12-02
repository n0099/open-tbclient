package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class gpb {
    public static /* synthetic */ Interceptable $ic;
    public static volatile fpb a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized fpb a() {
        InterceptResult invokeV;
        fpb fpbVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (gpb.class) {
                if (a == null) {
                    a = new fpb();
                }
                fpbVar = a;
            }
            return fpbVar;
        }
        return (fpb) invokeV.objValue;
    }
}
