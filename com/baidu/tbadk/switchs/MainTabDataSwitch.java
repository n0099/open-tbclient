package com.baidu.tbadk.switchs;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tieba.debugtool.annotation.ModifyClass;
import com.baidu.tieba.et4;
import com.baidu.tieba.su4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@ModifyClass
/* loaded from: classes3.dex */
public class MainTabDataSwitch extends BaseNormalSwitch {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String LAUNCH_UP_MAIN_TAB_DATA_ENABLE = "launch_up_main_tab_data_24";
    public static final int TYPE_CACHE = 2;
    public static final int TYPE_OFF = 0;
    public static final int TYPE_PREFETCH = 1;
    public static final MainTabDataSwitch mInstance;
    public static int type;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-618279180, "Lcom/baidu/tbadk/switchs/MainTabDataSwitch;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-618279180, "Lcom/baidu/tbadk/switchs/MainTabDataSwitch;");
                return;
            }
        }
        mInstance = new MainTabDataSwitch();
        type = 3;
        init();
    }

    public MainTabDataSwitch() {
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

    public static void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            if (type > 2) {
                type = su4.k().l("key_launch_up_main_tab_data", 1);
            }
            if (UbsABTestHelper.isMainTabDataCache()) {
                type = 2;
            } else if (UbsABTestHelper.isMainTabDataPrefetch()) {
                type = 1;
            } else if (UbsABTestHelper.isMainTabDataOff()) {
                type = 0;
            } else {
                BdLog.i("main tab data type: " + type);
            }
        }
    }

    public static boolean isCacheOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? type == 2 && et4.a().b : invokeV.booleanValue;
    }

    public static boolean isOff() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? type == 0 : invokeV.booleanValue;
    }

    public static boolean isPrefetchOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? type == 1 : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.switchs.BaseNormalSwitch, com.baidu.tieba.cf
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? LAUNCH_UP_MAIN_TAB_DATA_ENABLE : (String) invokeV.objValue;
    }
}
