package com.baidu.tbadk.switchs;

import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tieba.m35;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class WindowGreySwitch extends BaseNormalSwitch {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_SWITCH = "tb_window_grey_switch";
    public static final int TYPE_CLOSE = 0;
    public static final int TYPE_OPEN = 1;
    public static int mCachedSwitchValue = -1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(2021748741, "Lcom/baidu/tbadk/switchs/WindowGreySwitch;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(2021748741, "Lcom/baidu/tbadk/switchs/WindowGreySwitch;");
        }
    }

    public static boolean getIsOn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.switchs.BaseNormalSwitch, com.baidu.tieba.te
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? KEY_SWITCH : (String) invokeV.objValue;
    }

    public WindowGreySwitch() {
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

    public static boolean getIsOnNew() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (!PermissionUtil.isAgreePrivacyPolicy()) {
                return false;
            }
            if (mCachedSwitchValue < 0) {
                mCachedSwitchValue = m35.m().n(KEY_SWITCH, 0);
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
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i) == null) {
            mCachedSwitchValue = i;
            m35.m().z(KEY_SWITCH, i);
        }
    }
}
