package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.searchbox.download.center.clearcache.controller.ClearCacheUbcController;
import com.baidu.swan.apps.jsbridge.SwanAppNativeSwanJsBridge;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class fe2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(h32 h32Var, je2 je2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, h32Var, je2Var) == null) && h32Var != null && je2Var != null) {
            je2Var.g(h32Var);
        }
    }

    public static String b(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, str, str2, str3)) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                String quote = JSONObject.quote(str3);
                return str + "." + str2 + " = " + quote + ";";
            }
            return "";
        }
        return (String) invokeLLL.objValue;
    }

    public static String c(h32 h32Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, h32Var)) == null) {
            if (h32Var.isWebView()) {
                return ClearCacheUbcController.DOCUMENT;
            }
            return SwanAppNativeSwanJsBridge.JAVASCRIPT_INTERFACE_NAME;
        }
        return (String) invokeL.objValue;
    }
}
