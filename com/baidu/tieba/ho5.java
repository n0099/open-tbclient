package com.baidu.tieba;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* compiled from: IMSdkService.java */
/* loaded from: classes6.dex */
public final /* synthetic */ class ho5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static io5 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            return new jo5(b());
        }
        return (io5) invokeV.objValue;
    }

    public static io5 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return (io5) ServiceManager.getService(io5.a);
        }
        return (io5) invokeV.objValue;
    }
}
