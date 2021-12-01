package com.baidu.tbadk.switchs;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.util.TriState;
/* loaded from: classes9.dex */
public class QuickWebViewSwitch extends BaseNormalSwitch {
    public static /* synthetic */ Interceptable $ic;
    public static QuickWebViewSwitch mInstance;
    public static TriState state;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(192317352, "Lcom/baidu/tbadk/switchs/QuickWebViewSwitch;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(192317352, "Lcom/baidu/tbadk/switchs/QuickWebViewSwitch;");
                return;
            }
        }
        state = TriState.UNSET;
        mInstance = new QuickWebViewSwitch();
    }

    public QuickWebViewSwitch() {
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

    public static boolean getInOn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (state == TriState.UNSET) {
                return mInstance.isOn();
            }
            return state == TriState.YES;
        }
        return invokeV.booleanValue;
    }

    public static void setState(TriState triState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, triState) == null) {
            state = triState;
        }
    }

    @Override // com.baidu.tbadk.switchs.BaseNormalSwitch, c.a.d.f.f.a
    public int getDefaultType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? super.getDefaultType() : invokeV.intValue;
    }

    @Override // com.baidu.tbadk.switchs.BaseNormalSwitch, c.a.d.f.f.a
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "android_custom_offline_web_cache" : (String) invokeV.objValue;
    }
}
