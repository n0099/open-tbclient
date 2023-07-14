package com.baidu.tbadk.switchs;

import com.baidu.tieba.da5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class UnReadRedPotMessage extends BaseNormalSwitch {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_SWITCH = "chatroom_frs_redpoint_switch";
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tbadk.switchs.BaseNormalSwitch, com.baidu.tieba.ff
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? KEY_SWITCH : (String) invokeV.objValue;
    }

    public UnReadRedPotMessage() {
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

    public static boolean getIsOn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (da5.p().q(KEY_SWITCH, 1) == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
