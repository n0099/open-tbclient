package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.searchbox.cloudcontrol.utils.CloudStabilityUBCUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class fa3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(JSONObject jSONObject, @Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, jSONObject, str) == null) {
            ia3.l(true, str);
            JSONObject optJSONObject = jSONObject.optJSONObject("stability_config");
            if (optJSONObject == null) {
                return;
            }
            j12.b("SwanAppStabilityConfig", "stabilityConfigJo=" + optJSONObject);
            ia3.n(str, optJSONObject.optInt("_SwanStartupStability_"));
            ia3.k(str, optJSONObject.optInt("obtain_interval_ms", 500));
            int optInt = optJSONObject.optInt("auto_obtain_data_len", 0);
            if (optInt > 0) {
                ia3.i(str, true);
                ia3.j(str, optInt);
            }
        }
    }

    public static void b(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            ia3.m(true, str);
        }
    }

    public static void c(JSONObject jSONObject, @Nullable String str) {
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
