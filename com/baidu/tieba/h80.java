package com.baidu.tieba;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
@Autowired
/* loaded from: classes6.dex */
public class h80 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Inject(force = false)
    public static g80 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            return g80.a;
        }
        return (g80) invokeV.objValue;
    }
}
