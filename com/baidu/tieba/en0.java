package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.provider.FontsContractCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.sdk.WebChromeClient;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class en0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        double d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, str, str2, str3, str4)) == null) {
            JSONObject jSONObject = new JSONObject();
            y21.f(jSONObject, "downStatus", str);
            try {
                d = Double.parseDouble(str2) * 100.0d;
            } catch (Exception unused) {
                d = 0.0d;
            }
            y21.e(jSONObject, "process", Math.round(d));
            y21.f(jSONObject, "uri", str3);
            y21.f(jSONObject, FontsContractCompat.Columns.FILE_ID, str4);
            return jSONObject.toString();
        }
        return (String) invokeLLLL.objValue;
    }

    public static void b(@Nullable ck0 ck0Var, boolean z, @Nullable Map<String, String> map) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65537, null, new Object[]{ck0Var, Boolean.valueOf(z), map}) != null) || ck0Var == null) {
            return;
        }
        if (map == null) {
            map = new HashMap<>();
        }
        if (z) {
            str = "0";
        } else {
            str = "202";
        }
        z21.e(map, "status", str);
        if (z) {
            str2 = "调用成功";
        } else {
            str2 = "";
        }
        z21.e(map, "message", str2);
        ck0Var.a(z, map);
    }

    public static void c(@Nullable ck0 ck0Var, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLLL(65538, null, ck0Var, str, str2, str3, str4) != null) || ck0Var == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(WebChromeClient.KEY_ARG_CALLBACK, str);
        JSONObject jSONObject = new JSONObject();
        y21.f(jSONObject, "uri", str2);
        y21.f(jSONObject, FontsContractCompat.Columns.FILE_ID, str3);
        y21.f(jSONObject, "downStatus", str4);
        hashMap.put("data", jSONObject.toString());
        b(ck0Var, true, hashMap);
    }

    public static String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            return y21.c(str).optString("bt_info");
        }
        return (String) invokeL.objValue;
    }
}
