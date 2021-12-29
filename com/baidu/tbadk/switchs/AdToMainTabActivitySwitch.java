package com.baidu.tbadk.switchs;

import c.a.s0.b.d;
import c.a.s0.s.g0.b;
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
/* loaded from: classes11.dex */
public class AdToMainTabActivitySwitch extends BaseNormalSwitch {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AD_TO_MAINATABACTIVITY_ENABLE = "ad_to_maintabactivity_grey";
    public static final int TYPE_OFF = 0;
    public static final int TYPE_ON = 1;
    public static final AdToMainTabActivitySwitch mInstance;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Modify(description = "开屏广告优化的开关")
    public static boolean getIsOn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (type > 1) {
                if (d.G()) {
                    type = 0;
                } else {
                    int k2 = b.j().k("key_ad_to_maintabactivity", 1);
                    type = k2;
                    if (k2 == 1) {
                        if (d.I()) {
                            type = 1;
                        } else {
                            type = 0;
                        }
                    }
                }
            }
            return type == 1;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.switchs.BaseNormalSwitch, c.a.d.f.f.a
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? AD_TO_MAINATABACTIVITY_ENABLE : (String) invokeV.objValue;
    }
}
