package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class cn4 extends om4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public cn4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.om4, com.baidu.tieba.rm4
    public void b(JSONObject jSONObject, bj4 bj4Var, @Nullable bj4 bj4Var2, @Nullable bj4 bj4Var3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(1048576, this, jSONObject, bj4Var, bj4Var2, bj4Var3) != null) || jSONObject == null) {
            return;
        }
        en4.b().e(jSONObject.optJSONObject("tipmsgs"));
        in4.f().k(jSONObject.optJSONObject("page_tips"));
        an4.b().d(jSONObject.optJSONObject("pkg_clean_strategy"));
        kn4.a().d(jSONObject.optJSONObject("pkg_preload"));
        sn4.f(jSONObject.optJSONObject("app_inner_preload"));
        dn4.a().c(jSONObject.optJSONObject("getpkg_retry_switch"));
        pn4.b().d(jSONObject.optJSONObject("tts"));
        ln4.a().e(jSONObject.optJSONObject("simple_control_item"));
        qn4.e(jSONObject.optJSONObject("update_expire_time"));
        if (mn4.a) {
            c(jSONObject);
        }
        on4.b().f(jSONObject.optJSONObject("web_degrade_strategy"));
        fn4.a().c(jSONObject.optJSONObject("local_debug"));
        ri4.a().b(jSONObject.optJSONObject(ri4.a().c()));
        if (nn4.b()) {
            hn4.a().b(jSONObject.optJSONObject("api_description"));
        }
        gn4.a().e(jSONObject.optJSONObject("no_history_apps"));
    }

    public final void c(@NonNull JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) != null) || (optJSONObject = jSONObject.optJSONObject("heartbeat")) == null || optJSONObject.optLong("errno") != 0) {
            return;
        }
        pi4 b = ri4.b();
        ir4 ir4Var = null;
        if (b != null) {
            ir4Var = b.i();
        }
        String optString = optJSONObject.optString("version");
        if (!TextUtils.isEmpty(optString)) {
            mn4.b = optString;
            if (ir4Var != null) {
                ir4Var.putString("key_h2_heart_beat_version", optString);
            }
        }
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("data");
        if (optJSONObject2 != null) {
            if (optJSONObject2.optInt("switch") > 0) {
                int optInt = optJSONObject2.optInt("timespan");
                int optInt2 = optJSONObject2.optInt("timeout");
                if (ir4Var != null) {
                    if (optInt > 0) {
                        ir4Var.putInt("key_h2_heart_beat_timespan", optInt);
                    }
                    if (optInt2 > 0) {
                        ir4Var.putInt("key_h2_heart_beat_timeout", optInt2);
                        return;
                    }
                    return;
                }
                return;
            }
            mn4.a = false;
        }
    }
}
