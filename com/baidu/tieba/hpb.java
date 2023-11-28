package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class hpb {
    public static /* synthetic */ Interceptable $ic;
    public static volatile gpb a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized gpb a() {
        InterceptResult invokeV;
        gpb gpbVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (hpb.class) {
                if (a == null) {
                    a = new gpb();
                }
                gpbVar = a;
            }
            return gpbVar;
        }
        return (gpb) invokeV.objValue;
    }
}
