package com.baidu.tbadk.switchs;

import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tieba.debugtool.annotation.Modify;
import com.baidu.tieba.debugtool.annotation.ModifyClass;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.vt4;
@ModifyClass
/* loaded from: classes3.dex */
public class AdToMainTabActivitySwitch extends BaseNormalSwitch {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AD_TO_MAINATABACTIVITY_ENABLE = "ad_to_maintabactivity_12_21";
    public static final int TYPE_FORCE_ON = 2;
    public static final int TYPE_OFF = 0;
    public static final int TYPE_ON = 1;
    public static final AdToMainTabActivitySwitch mInstance;
    public static boolean switchOn;
    public static int type;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1236693363, "Lcom/baidu/tbadk/switchs/AdToMainTabActivitySwitch;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1236693363, "Lcom/baidu/tbadk/switchs/AdToMainTabActivitySwitch;");
                return;
            }
        }
        mInstance = new AdToMainTabActivitySwitch();
        type = 3;
    }

    public AdToMainTabActivitySwitch() {
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

    @Modify(description = "12.21 开屏广告优化的开关", type = 100)
    public static boolean getIsOn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (type > 2) {
                int l = vt4.k().l("key_ad_to_maintabactivity", 0);
                type = l;
                if (l == 2) {
                    switchOn = true;
                } else if (l == 1) {
                    switchOn = UbsABTestHelper.isMainTabSplashABTest();
                } else {
                    switchOn = false;
                }
            }
            return switchOn;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.switchs.BaseNormalSwitch, com.repackage.xe
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? AD_TO_MAINATABACTIVITY_ENABLE : (String) invokeV.objValue;
    }
}
