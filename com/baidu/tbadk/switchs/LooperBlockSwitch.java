package com.baidu.tbadk.switchs;

import com.baidu.tieba.debugtool.annotation.Modify;
import com.baidu.tieba.debugtool.annotation.ModifyClass;
import com.baidu.tieba.o95;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@ModifyClass
/* loaded from: classes4.dex */
public class LooperBlockSwitch extends BaseNormalSwitch {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String LOOPER_BLOCK_ENABLE = "looper_block_switch_1239";
    public static final int TYPE_FORCE_ON = 2;
    public static final int TYPE_OFF = 0;
    public static final int TYPE_ON = 1;
    public static final LooperBlockSwitch mInstance;
    public static boolean switchOn;
    public static int type;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tbadk.switchs.BaseNormalSwitch, com.baidu.tieba.df
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? LOOPER_BLOCK_ENABLE : (String) invokeV.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(859422302, "Lcom/baidu/tbadk/switchs/LooperBlockSwitch;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(859422302, "Lcom/baidu/tbadk/switchs/LooperBlockSwitch;");
                return;
            }
        }
        mInstance = new LooperBlockSwitch();
        type = 3;
    }

    public LooperBlockSwitch() {
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

    @Modify(description = "12.33 卡顿优化专用 的开关", type = 100)
    public static boolean getIsOn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (type > 2) {
                int q = o95.p().q("key_looper_block_opt_switch", 1);
                type = q;
                if (q == 2) {
                    switchOn = true;
                } else if (q == 1) {
                    switchOn = true;
                } else {
                    switchOn = false;
                }
            }
            return switchOn;
        }
        return invokeV.booleanValue;
    }
}
