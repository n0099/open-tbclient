package com.baidu.tieba;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
@Autowired
/* loaded from: classes5.dex */
public class acb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Inject
    public static fbb a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            return yaa.a();
        }
        return (fbb) invokeV.objValue;
    }

    @Inject
    public static ebb b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return waa.a();
        }
        return (ebb) invokeV.objValue;
    }

    @Inject
    public static ibb c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return wab.a();
        }
        return (ibb) invokeV.objValue;
    }
}
