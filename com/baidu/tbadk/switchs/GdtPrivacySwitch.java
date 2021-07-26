package com.baidu.tbadk.switchs;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.debugtool.annotation.Modify;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.f.a;
import d.a.p0.s.d0.b;
/* loaded from: classes3.dex */
public class GdtPrivacySwitch extends a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_SWITCH = "splash_ad_gdt_switch";
    public static final int TYPE_OFF = 0;
    public static final int TYPE_OPEN = 1;
    public transient /* synthetic */ FieldHolder $fh;

    public GdtPrivacySwitch() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Modify(description = "广点通sdk是否允许调用敏感隐私权限")
    public static boolean isOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? b.j().k("pref_key_splash_gdt_privacy_enable", 0) == 1 : invokeV.booleanValue;
    }

    @Override // d.a.d.e.f.a
    public void changeSettingByType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
        }
    }

    @Override // d.a.d.e.f.a
    public String[] getCrashKeys() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (String[]) invokeV.objValue;
    }

    @Override // d.a.d.e.f.a
    public int getDefaultType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // d.a.d.e.f.a
    public int getMaxCrashTimes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 10;
        }
        return invokeV.intValue;
    }

    @Override // d.a.d.e.f.a
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? KEY_SWITCH : (String) invokeV.objValue;
    }

    @Override // d.a.d.e.f.a
    public int getOffType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }
}
