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
/* loaded from: classes4.dex */
public class il4 extends uk4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public il4() {
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

    @Override // com.baidu.tieba.uk4, com.baidu.tieba.xk4
    public void b(JSONObject jSONObject, hh4 hh4Var, @Nullable hh4 hh4Var2, @Nullable hh4 hh4Var3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(1048576, this, jSONObject, hh4Var, hh4Var2, hh4Var3) != null) || jSONObject == null) {
            return;
        }
        kl4.b().e(jSONObject.optJSONObject("tipmsgs"));
        ol4.f().k(jSONObject.optJSONObject("page_tips"));
        gl4.b().d(jSONObject.optJSONObject("pkg_clean_strategy"));
        ql4.a().d(jSONObject.optJSONObject("pkg_preload"));
        yl4.f(jSONObject.optJSONObject("app_inner_preload"));
        jl4.a().c(jSONObject.optJSONObject("getpkg_retry_switch"));
        vl4.b().d(jSONObject.optJSONObject("tts"));
        rl4.a().e(jSONObject.optJSONObject("simple_control_item"));
        wl4.e(jSONObject.optJSONObject("update_expire_time"));
        if (sl4.a) {
            c(jSONObject);
        }
        ul4.b().f(jSONObject.optJSONObject("web_degrade_strategy"));
        ll4.a().c(jSONObject.optJSONObject("local_debug"));
        xg4.a().b(jSONObject.optJSONObject(xg4.a().c()));
        if (tl4.b()) {
            nl4.a().b(jSONObject.optJSONObject("api_description"));
        }
        ml4.a().e(jSONObject.optJSONObject("no_history_apps"));
    }

    public final void c(@NonNull JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) != null) || (optJSONObject = jSONObject.optJSONObject("heartbeat")) == null || optJSONObject.optLong("errno") != 0) {
            return;
        }
        vg4 b = xg4.b();
        op4 op4Var = null;
        if (b != null) {
            op4Var = b.i();
        }
        String optString = optJSONObject.optString("version");
        if (!TextUtils.isEmpty(optString)) {
            sl4.b = optString;
            if (op4Var != null) {
                op4Var.putString("key_h2_heart_beat_version", optString);
            }
        }
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("data");
        if (optJSONObject2 != null) {
            if (optJSONObject2.optInt(SetImageWatermarkTypeReqMsg.SWITCH) > 0) {
                int optInt = optJSONObject2.optInt("timespan");
                int optInt2 = optJSONObject2.optInt("timeout");
                if (op4Var != null) {
                    if (optInt > 0) {
                        op4Var.putInt("key_h2_heart_beat_timespan", optInt);
                    }
                    if (optInt2 > 0) {
                        op4Var.putInt("key_h2_heart_beat_timeout", optInt2);
                        return;
                    }
                    return;
                }
                return;
            }
            sl4.a = false;
        }
    }
}
