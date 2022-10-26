package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.searchbox.cloudcontrol.utils.CloudStabilityUBCUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class i93 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(JSONObject jSONObject, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, jSONObject, str) == null) {
            l93.l(true, str);
            JSONObject optJSONObject = jSONObject.optJSONObject("stability_config");
            if (optJSONObject == null) {
                return;
            }
            m02.b("SwanAppStabilityConfig", "stabilityConfigJo=" + optJSONObject);
            l93.n(str, optJSONObject.optInt("_SwanStartupStability_"));
            l93.k(str, optJSONObject.optInt("obtain_interval_ms", 500));
            int optInt = optJSONObject.optInt("auto_obtain_data_len", 0);
            if (optInt > 0) {
                l93.i(str, true);
                l93.j(str, optInt);
            }
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            l93.m(true, str);
        }
    }

    public static void c(JSONObject jSONObject, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65538, null, jSONObject, str) != null) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("performance_type");
        if (TextUtils.equals(optString, CloudStabilityUBCUtils.VALUE_TYPE)) {
            a(jSONObject, str);
        } else if (TextUtils.equals(optString, "stabilityProfile")) {
            b(str);
        }
    }
}
