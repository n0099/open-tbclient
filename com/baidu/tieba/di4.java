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
public class di4 extends ph4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public di4() {
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

    @Override // com.baidu.tieba.ph4, com.baidu.tieba.sh4
    public void b(JSONObject jSONObject, ce4 ce4Var, @Nullable ce4 ce4Var2, @Nullable ce4 ce4Var3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(1048576, this, jSONObject, ce4Var, ce4Var2, ce4Var3) != null) || jSONObject == null) {
            return;
        }
        fi4.b().e(jSONObject.optJSONObject("tipmsgs"));
        ji4.f().k(jSONObject.optJSONObject("page_tips"));
        bi4.b().d(jSONObject.optJSONObject("pkg_clean_strategy"));
        li4.a().d(jSONObject.optJSONObject("pkg_preload"));
        ti4.f(jSONObject.optJSONObject("app_inner_preload"));
        ei4.a().c(jSONObject.optJSONObject("getpkg_retry_switch"));
        qi4.b().d(jSONObject.optJSONObject("tts"));
        mi4.a().e(jSONObject.optJSONObject("simple_control_item"));
        ri4.e(jSONObject.optJSONObject("update_expire_time"));
        if (ni4.a) {
            c(jSONObject);
        }
        pi4.b().f(jSONObject.optJSONObject("web_degrade_strategy"));
        gi4.a().c(jSONObject.optJSONObject("local_debug"));
        sd4.a().b(jSONObject.optJSONObject(sd4.a().c()));
        if (oi4.b()) {
            ii4.a().b(jSONObject.optJSONObject("api_description"));
        }
        hi4.a().e(jSONObject.optJSONObject("no_history_apps"));
    }

    public final void c(@NonNull JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) != null) || (optJSONObject = jSONObject.optJSONObject("heartbeat")) == null || optJSONObject.optLong("errno") != 0) {
            return;
        }
        qd4 b = sd4.b();
        im4 im4Var = null;
        if (b != null) {
            im4Var = b.i();
        }
        String optString = optJSONObject.optString("version");
        if (!TextUtils.isEmpty(optString)) {
            ni4.b = optString;
            if (im4Var != null) {
                im4Var.putString("key_h2_heart_beat_version", optString);
            }
        }
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("data");
        if (optJSONObject2 != null) {
            if (optJSONObject2.optInt("switch") > 0) {
                int optInt = optJSONObject2.optInt("timespan");
                int optInt2 = optJSONObject2.optInt("timeout");
                if (im4Var != null) {
                    if (optInt > 0) {
                        im4Var.putInt("key_h2_heart_beat_timespan", optInt);
                    }
                    if (optInt2 > 0) {
                        im4Var.putInt("key_h2_heart_beat_timeout", optInt2);
                        return;
                    }
                    return;
                }
                return;
            }
            ni4.a = false;
        }
    }
}
