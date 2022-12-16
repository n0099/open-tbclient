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
/* loaded from: classes3.dex */
public class ag4 extends mf4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ag4() {
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

    @Override // com.baidu.tieba.mf4, com.baidu.tieba.pf4
    public void b(JSONObject jSONObject, zb4 zb4Var, @Nullable zb4 zb4Var2, @Nullable zb4 zb4Var3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(1048576, this, jSONObject, zb4Var, zb4Var2, zb4Var3) != null) || jSONObject == null) {
            return;
        }
        cg4.b().e(jSONObject.optJSONObject("tipmsgs"));
        gg4.f().k(jSONObject.optJSONObject("page_tips"));
        yf4.b().d(jSONObject.optJSONObject("pkg_clean_strategy"));
        ig4.a().d(jSONObject.optJSONObject("pkg_preload"));
        qg4.f(jSONObject.optJSONObject("app_inner_preload"));
        bg4.a().c(jSONObject.optJSONObject("getpkg_retry_switch"));
        ng4.b().d(jSONObject.optJSONObject("tts"));
        jg4.a().e(jSONObject.optJSONObject("simple_control_item"));
        og4.e(jSONObject.optJSONObject("update_expire_time"));
        if (kg4.a) {
            c(jSONObject);
        }
        mg4.b().f(jSONObject.optJSONObject("web_degrade_strategy"));
        dg4.a().c(jSONObject.optJSONObject("local_debug"));
        pb4.a().b(jSONObject.optJSONObject(pb4.a().c()));
        if (lg4.b()) {
            fg4.a().b(jSONObject.optJSONObject("api_description"));
        }
        eg4.a().e(jSONObject.optJSONObject("no_history_apps"));
    }

    public final void c(@NonNull JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) != null) || (optJSONObject = jSONObject.optJSONObject("heartbeat")) == null || optJSONObject.optLong("errno") != 0) {
            return;
        }
        nb4 b = pb4.b();
        gk4 gk4Var = null;
        if (b != null) {
            gk4Var = b.i();
        }
        String optString = optJSONObject.optString("version");
        if (!TextUtils.isEmpty(optString)) {
            kg4.b = optString;
            if (gk4Var != null) {
                gk4Var.putString("key_h2_heart_beat_version", optString);
            }
        }
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("data");
        if (optJSONObject2 != null) {
            if (optJSONObject2.optInt(SetImageWatermarkTypeReqMsg.SWITCH) > 0) {
                int optInt = optJSONObject2.optInt("timespan");
                int optInt2 = optJSONObject2.optInt(com.alipay.sdk.data.a.O);
                if (gk4Var != null) {
                    if (optInt > 0) {
                        gk4Var.putInt("key_h2_heart_beat_timespan", optInt);
                    }
                    if (optInt2 > 0) {
                        gk4Var.putInt("key_h2_heart_beat_timeout", optInt2);
                        return;
                    }
                    return;
                }
                return;
            }
            kg4.a = false;
        }
    }
}
