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
public class dn4 extends pm4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public dn4() {
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

    @Override // com.baidu.tieba.pm4, com.baidu.tieba.sm4
    public void b(JSONObject jSONObject, cj4 cj4Var, @Nullable cj4 cj4Var2, @Nullable cj4 cj4Var3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(1048576, this, jSONObject, cj4Var, cj4Var2, cj4Var3) != null) || jSONObject == null) {
            return;
        }
        fn4.b().e(jSONObject.optJSONObject("tipmsgs"));
        jn4.f().k(jSONObject.optJSONObject("page_tips"));
        bn4.b().d(jSONObject.optJSONObject("pkg_clean_strategy"));
        ln4.a().d(jSONObject.optJSONObject("pkg_preload"));
        tn4.f(jSONObject.optJSONObject("app_inner_preload"));
        en4.a().c(jSONObject.optJSONObject("getpkg_retry_switch"));
        qn4.b().d(jSONObject.optJSONObject("tts"));
        mn4.a().e(jSONObject.optJSONObject("simple_control_item"));
        rn4.e(jSONObject.optJSONObject("update_expire_time"));
        if (nn4.a) {
            c(jSONObject);
        }
        pn4.b().f(jSONObject.optJSONObject("web_degrade_strategy"));
        gn4.a().c(jSONObject.optJSONObject("local_debug"));
        si4.a().b(jSONObject.optJSONObject(si4.a().c()));
        if (on4.b()) {
            in4.a().b(jSONObject.optJSONObject("api_description"));
        }
        hn4.a().e(jSONObject.optJSONObject("no_history_apps"));
    }

    public final void c(@NonNull JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) != null) || (optJSONObject = jSONObject.optJSONObject("heartbeat")) == null || optJSONObject.optLong("errno") != 0) {
            return;
        }
        qi4 b = si4.b();
        jr4 jr4Var = null;
        if (b != null) {
            jr4Var = b.i();
        }
        String optString = optJSONObject.optString("version");
        if (!TextUtils.isEmpty(optString)) {
            nn4.b = optString;
            if (jr4Var != null) {
                jr4Var.putString("key_h2_heart_beat_version", optString);
            }
        }
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("data");
        if (optJSONObject2 != null) {
            if (optJSONObject2.optInt("switch") > 0) {
                int optInt = optJSONObject2.optInt("timespan");
                int optInt2 = optJSONObject2.optInt("timeout");
                if (jr4Var != null) {
                    if (optInt > 0) {
                        jr4Var.putInt("key_h2_heart_beat_timespan", optInt);
                    }
                    if (optInt2 > 0) {
                        jr4Var.putInt("key_h2_heart_beat_timeout", optInt2);
                        return;
                    }
                    return;
                }
                return;
            }
            nn4.a = false;
        }
    }
}
