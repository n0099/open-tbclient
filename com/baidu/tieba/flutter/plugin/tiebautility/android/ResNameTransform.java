package com.baidu.tieba.flutter.plugin.tiebautility.android;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes9.dex */
public class ResNameTransform {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, String> assetsImageNameMap;
    public static HashMap<String, String> platformImageNameMap;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1458949891, "Lcom/baidu/tieba/flutter/plugin/tiebautility/android/ResNameTransform;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1458949891, "Lcom/baidu/tieba/flutter/plugin/tiebautility/android/ResNameTransform;");
                return;
            }
        }
        platformImageNameMap = new HashMap<>();
        assetsImageNameMap = new HashMap<>();
        platformImageNameMap.put("full_screen_loading", "lottie_full_screen_refresh");
        platformImageNameMap.put("lottie_pull_refresh", "lottie_common_pull_refresh");
        platformImageNameMap.put("ad_refresh_load", "lottie_frs_refresh");
        platformImageNameMap.put("lottie_live_status_new", "ala_live2");
        platformImageNameMap.put("profileViewOnLivingCardNormal", "card_live_bg");
        assetsImageNameMap.put("lottie_portrait_live", "live/personcenter_live_bg.json");
    }

    public ResNameTransform() {
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

    public static String getAndroidAssetsNameFromIos(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (assetsImageNameMap.containsKey(str)) {
                return assetsImageNameMap.get(str);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String getAndroidNameFromIos(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? platformImageNameMap.containsKey(str) ? platformImageNameMap.get(str) : str : (String) invokeL.objValue;
    }
}
