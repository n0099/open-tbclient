package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
/* loaded from: classes5.dex */
public class gp3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            zb3 M = zb3.M();
            if (M != null) {
                return String.format(str, M.O(), M.V());
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            String a = a("https://smartapps.cn/%s/%s/page-frame.html");
            if (js1.a) {
                Log.d("SwanAppRefererUtils", "getFixedReferer: " + a);
            }
            return a;
        }
        return (String) invokeV.objValue;
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            String b = b();
            if (!TextUtils.isEmpty(b)) {
                if (js1.a) {
                    Log.d("SwanAppRefererUtils", "call setRefererPattern for Slave Webview; referer is " + b);
                }
                WebSettingsGlobalBlink.setRefererPattern(b, vu2.i());
            }
        }
    }

    public static boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (!TextUtils.isEmpty(str) && str.startsWith("https://")) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
