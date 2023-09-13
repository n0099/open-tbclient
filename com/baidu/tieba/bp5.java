package com.baidu.tieba;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* compiled from: SecondFloorService.java */
/* loaded from: classes5.dex */
public final /* synthetic */ class bp5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static cp5 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            return (cp5) ServiceManager.getService(cp5.a);
        }
        return (cp5) invokeV.objValue;
    }
}
