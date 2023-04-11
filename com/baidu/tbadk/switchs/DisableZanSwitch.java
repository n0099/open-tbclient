package com.baidu.tbadk.switchs;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tieba.aj5;
import com.baidu.tieba.p45;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class DisableZanSwitch extends BaseNormalSwitch {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_SWITCH = "tb_disable_zan_switch";
    public static final int TYPE_CLOSE = 0;
    public static final int TYPE_OPEN = 1;
    public static int mCachedSwitchValue = -1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-361239851, "Lcom/baidu/tbadk/switchs/DisableZanSwitch;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-361239851, "Lcom/baidu/tbadk/switchs/DisableZanSwitch;");
        }
    }

    @Override // com.baidu.tbadk.switchs.BaseNormalSwitch, com.baidu.tieba.te
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? KEY_SWITCH : (String) invokeV.objValue;
    }

    public DisableZanSwitch() {
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

    public static boolean getIsOn() {
        InterceptResult invokeV;
        int c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (!PermissionUtil.isAgreePrivacyPolicy()) {
                return false;
            }
            if (mCachedSwitchValue < 0) {
                mCachedSwitchValue = p45.m().n(KEY_SWITCH, 0);
                if (!TbadkCoreApplication.getInst().isMainProcess(false) && (c = aj5.c(KEY_SWITCH, -1)) >= 0) {
                    mCachedSwitchValue = c;
                    p45.m().z(KEY_SWITCH, c);
                }
            }
            if (mCachedSwitchValue != 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static void setNewValue(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, null, i) == null) {
            mCachedSwitchValue = i;
            p45.m().z(KEY_SWITCH, i);
            aj5.i(KEY_SWITCH, i);
        }
    }
}
