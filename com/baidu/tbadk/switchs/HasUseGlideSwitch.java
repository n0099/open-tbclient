package com.baidu.tbadk.switchs;

import com.baidu.tieba.ox4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class HasUseGlideSwitch extends BaseNormalSwitch {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String HAS_USE_GLIDE = "12_29_glide";
    public transient /* synthetic */ FieldHolder $fh;

    public HasUseGlideSwitch() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static boolean isSwitchOn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? ox4.k().l("key_use_glide_switch", 0) == 1 : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.switchs.BaseNormalSwitch, com.baidu.tieba.qf
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? HAS_USE_GLIDE : (String) invokeV.objValue;
    }
}
