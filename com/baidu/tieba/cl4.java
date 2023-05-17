package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class cl4 extends ok4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public cl4() {
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

    @Override // com.baidu.tieba.ok4, com.baidu.tieba.rk4
    public void b(JSONObject jSONObject, bh4 bh4Var, @Nullable bh4 bh4Var2, @Nullable bh4 bh4Var3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(1048576, this, jSONObject, bh4Var, bh4Var2, bh4Var3) != null) || jSONObject == null) {
            return;
        }
        el4.b().e(jSONObject.optJSONObject("tipmsgs"));
        il4.f().k(jSONObject.optJSONObject("page_tips"));
        al4.b().d(jSONObject.optJSONObject("pkg_clean_strategy"));
        kl4.a().d(jSONObject.optJSONObject("pkg_preload"));
        sl4.f(jSONObject.optJSONObject("app_inner_preload"));
        dl4.a().c(jSONObject.optJSONObject("getpkg_retry_switch"));
        pl4.b().d(jSONObject.optJSONObject("tts"));
        ll4.a().e(jSONObject.optJSONObject("simple_control_item"));
        ql4.e(jSONObject.optJSONObject("update_expire_time"));
        if (ml4.a) {
            c(jSONObject);
        }
        ol4.b().f(jSONObject.optJSONObject("web_degrade_strategy"));
        fl4.a().c(jSONObject.optJSONObject("local_debug"));
        rg4.a().b(jSONObject.optJSONObject(rg4.a().c()));
        if (nl4.b()) {
            hl4.a().b(jSONObject.optJSONObject("api_description"));
        }
        gl4.a().e(jSONObject.optJSONObject("no_history_apps"));
    }

    public final void c(@NonNull JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) != null) || (optJSONObject = jSONObject.optJSONObject("heartbeat")) == null || optJSONObject.optLong("errno") != 0) {
            return;
        }
        pg4 b = rg4.b();
        ip4 ip4Var = null;
        if (b != null) {
            ip4Var = b.i();
        }
        String optString = optJSONObject.optString("version");
        if (!TextUtils.isEmpty(optString)) {
            ml4.b = optString;
            if (ip4Var != null) {
                ip4Var.putString("key_h2_heart_beat_version", optString);
            }
        }
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("data");
        if (optJSONObject2 != null) {
            if (optJSONObject2.optInt(SetImageWatermarkTypeReqMsg.SWITCH) > 0) {
                int optInt = optJSONObject2.optInt("timespan");
                int optInt2 = optJSONObject2.optInt("timeout");
                if (ip4Var != null) {
                    if (optInt > 0) {
                        ip4Var.putInt("key_h2_heart_beat_timespan", optInt);
                    }
                    if (optInt2 > 0) {
                        ip4Var.putInt("key_h2_heart_beat_timeout", optInt2);
                        return;
                    }
                    return;
                }
                return;
            }
            ml4.a = false;
        }
    }
}
