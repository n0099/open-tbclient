package com.baidu.tbadk.switchs;

import com.baidu.tieba.debugtool.annotation.Modify;
import com.baidu.tieba.debugtool.annotation.ModifyClass;
import com.baidu.tieba.ox4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@ModifyClass
/* loaded from: classes3.dex */
public class NewWritePageSwitch extends BaseNormalSwitch {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_NEW_WRITE_PAGE = "new_write_page_12_29_1";
    public static final int TYPE_OFF = 0;
    public static final int TYPE_ON = 1;
    public static boolean isSwitchLoaded = false;
    public static boolean switchOn = false;
    public static int type = 3;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1379099014, "Lcom/baidu/tbadk/switchs/NewWritePageSwitch;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1379099014, "Lcom/baidu/tbadk/switchs/NewWritePageSwitch;");
        }
    }

    public NewWritePageSwitch() {
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

    @Modify(description = "12.29 新版图文发帖页的开关")
    public static boolean getIsOn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (isSwitchLoaded) {
                return switchOn;
            }
            isSwitchLoaded = true;
            int l = ox4.k().l("key_new_write_page", 1);
            type = l;
            boolean z = l == 1;
            switchOn = z;
            return z;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.switchs.BaseNormalSwitch, com.baidu.tieba.qf
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? KEY_NEW_WRITE_PAGE : (String) invokeV.objValue;
    }
}
