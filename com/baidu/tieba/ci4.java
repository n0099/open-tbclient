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
public class ci4 extends oh4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ci4() {
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

    @Override // com.baidu.tieba.oh4, com.baidu.tieba.rh4
    public void b(JSONObject jSONObject, be4 be4Var, @Nullable be4 be4Var2, @Nullable be4 be4Var3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(1048576, this, jSONObject, be4Var, be4Var2, be4Var3) != null) || jSONObject == null) {
            return;
        }
        ei4.b().e(jSONObject.optJSONObject("tipmsgs"));
        ii4.f().k(jSONObject.optJSONObject("page_tips"));
        ai4.b().d(jSONObject.optJSONObject("pkg_clean_strategy"));
        ki4.a().d(jSONObject.optJSONObject("pkg_preload"));
        si4.f(jSONObject.optJSONObject("app_inner_preload"));
        di4.a().c(jSONObject.optJSONObject("getpkg_retry_switch"));
        pi4.b().d(jSONObject.optJSONObject("tts"));
        li4.a().e(jSONObject.optJSONObject("simple_control_item"));
        qi4.e(jSONObject.optJSONObject("update_expire_time"));
        if (mi4.a) {
            c(jSONObject);
        }
        oi4.b().f(jSONObject.optJSONObject("web_degrade_strategy"));
        fi4.a().c(jSONObject.optJSONObject("local_debug"));
        rd4.a().b(jSONObject.optJSONObject(rd4.a().c()));
        if (ni4.b()) {
            hi4.a().b(jSONObject.optJSONObject("api_description"));
        }
        gi4.a().e(jSONObject.optJSONObject("no_history_apps"));
    }

    public final void c(@NonNull JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) != null) || (optJSONObject = jSONObject.optJSONObject("heartbeat")) == null || optJSONObject.optLong("errno") != 0) {
            return;
        }
        pd4 b = rd4.b();
        hm4 hm4Var = null;
        if (b != null) {
            hm4Var = b.i();
        }
        String optString = optJSONObject.optString("version");
        if (!TextUtils.isEmpty(optString)) {
            mi4.b = optString;
            if (hm4Var != null) {
                hm4Var.putString("key_h2_heart_beat_version", optString);
            }
        }
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("data");
        if (optJSONObject2 != null) {
            if (optJSONObject2.optInt("switch") > 0) {
                int optInt = optJSONObject2.optInt("timespan");
                int optInt2 = optJSONObject2.optInt("timeout");
                if (hm4Var != null) {
                    if (optInt > 0) {
                        hm4Var.putInt("key_h2_heart_beat_timespan", optInt);
                    }
                    if (optInt2 > 0) {
                        hm4Var.putInt("key_h2_heart_beat_timeout", optInt2);
                        return;
                    }
                    return;
                }
                return;
            }
            mi4.a = false;
        }
    }
}
