package com.baidu.tieba.flutter.plugin.tiebautility.android;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class SharePrefNameTransform {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, String> sharePrefNameMap;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1087201595, "Lcom/baidu/tieba/flutter/plugin/tiebautility/android/SharePrefNameTransform;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1087201595, "Lcom/baidu/tieba/flutter/plugin/tiebautility/android/SharePrefNameTransform;");
                return;
            }
        }
        HashMap<String, String> hashMap = new HashMap<>();
        sharePrefNameMap = hashMap;
        hashMap.put("CashLoanRedPoint", "key_has_borrow_cash_clicked");
        sharePrefNameMap.put("BaiduFinanceRedPoint", "key_baidu_financial_has_clicked");
        sharePrefNameMap.put("kPreferenceKeyRedPacketRedPoint", "key_has_my_redpacket_clicked");
        sharePrefNameMap.put("ServiceCenter", "key_feedback_tip_show");
        sharePrefNameMap.put("MyTabGuidanceAnimationHasShown", "has_shown_person_center_guide");
    }

    public SharePrefNameTransform() {
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

    public static String getAndroidNameFromIos(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? sharePrefNameMap.containsKey(str) ? sharePrefNameMap.get(str) : str : (String) invokeL.objValue;
    }
}
