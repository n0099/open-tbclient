package com.baidu.tbadk.switchs;

import com.baidu.tieba.debugtool.annotation.Modify;
import com.baidu.tieba.debugtool.annotation.ModifyClass;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.xt4;
@ModifyClass
/* loaded from: classes3.dex */
public class LaunchUpApplicationSwitch extends BaseNormalSwitch {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String LAUNCH_UP_APPLICATION_ENABLE = "launch_up_application_24";
    public static final int TYPE_FORCE_ON = 2;
    public static final int TYPE_OFF = 0;
    public static final int TYPE_ON = 1;
    public static boolean switchOn = false;
    public static int type = 3;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(478717592, "Lcom/baidu/tbadk/switchs/LaunchUpApplicationSwitch;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(478717592, "Lcom/baidu/tbadk/switchs/LaunchUpApplicationSwitch;");
        }
    }

    public LaunchUpApplicationSwitch() {
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

    @Modify(description = "12.24 启动优化应用阶段细粒度优化", type = 100)
    public static boolean getIsOn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (type > 2) {
                int l = xt4.k().l("key_launch_up_application_init", 0);
                type = l;
                if (l == 2) {
                    switchOn = true;
                } else if (l == 1) {
                    switchOn = true;
                } else {
                    switchOn = false;
                }
            }
            return switchOn;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.switchs.BaseNormalSwitch, com.repackage.af
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? LAUNCH_UP_APPLICATION_ENABLE : (String) invokeV.objValue;
    }
}
