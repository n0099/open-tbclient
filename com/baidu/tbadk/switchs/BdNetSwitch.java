package com.baidu.tbadk.switchs;

import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tieba.debugtool.annotation.Modify;
import com.baidu.tieba.debugtool.annotation.ModifyClass;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@ModifyClass
/* loaded from: classes4.dex */
public class BdNetSwitch extends BaseNormalSwitch {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BD_NET_ENABLE = "BD_NET_12_34";
    public static final int TYPE_FORCE_ON = 2;
    public static final int TYPE_OFF = 0;
    public static final int TYPE_ON = 1;
    public static final BdNetSwitch mInstance;
    public static boolean switchOn;
    public static int type;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tbadk.switchs.BaseNormalSwitch, com.baidu.tieba.ve
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? BD_NET_ENABLE : (String) invokeV.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-224851329, "Lcom/baidu/tbadk/switchs/BdNetSwitch;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-224851329, "Lcom/baidu/tbadk/switchs/BdNetSwitch;");
                return;
            }
        }
        mInstance = new BdNetSwitch();
        type = 3;
    }

    public BdNetSwitch() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Modify(description = "12.31 使用手百网络库 的开关", type = 100)
    public static boolean getIsOn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (type > 2) {
                int i = SharedPrefHelper.getInstance().getInt("key_bd_net_switch", 2);
                type = i;
                if (i == 2) {
                    switchOn = true;
                } else if (i == 1) {
                    if (UbsABTestHelper.isUseTiebaNetABTest()) {
                        switchOn = false;
                    } else if (UbsABTestHelper.isNetABTest()) {
                        switchOn = true;
                    } else {
                        switchOn = true;
                    }
                } else {
                    switchOn = false;
                }
            }
            return switchOn;
        }
        return invokeV.booleanValue;
    }
}
