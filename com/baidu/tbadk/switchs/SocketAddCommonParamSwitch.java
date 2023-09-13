package com.baidu.tbadk.switchs;

import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.tieba.debugtool.annotation.Modify;
import com.baidu.tieba.debugtool.annotation.ModifyClass;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@ModifyClass
/* loaded from: classes5.dex */
public class SocketAddCommonParamSwitch extends BaseNormalSwitch {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String SOCKET_ADD_COMMON_PARAM_ENABLE = "android_lcs_common_param";
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tbadk.switchs.BaseNormalSwitch, com.baidu.tieba.ve
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? SOCKET_ADD_COMMON_PARAM_ENABLE : (String) invokeV.objValue;
    }

    public SocketAddCommonParamSwitch() {
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

    @Modify(description = "长连接默认添加公参的开关", type = 100)
    public static boolean getIsOn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (SwitchManager.getInstance().findType(SOCKET_ADD_COMMON_PARAM_ENABLE) == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
