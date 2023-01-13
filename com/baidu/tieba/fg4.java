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
public class fg4 extends rf4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public fg4() {
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

    @Override // com.baidu.tieba.rf4, com.baidu.tieba.uf4
    public void b(JSONObject jSONObject, ec4 ec4Var, @Nullable ec4 ec4Var2, @Nullable ec4 ec4Var3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(1048576, this, jSONObject, ec4Var, ec4Var2, ec4Var3) != null) || jSONObject == null) {
            return;
        }
        hg4.b().e(jSONObject.optJSONObject("tipmsgs"));
        lg4.f().k(jSONObject.optJSONObject("page_tips"));
        dg4.b().d(jSONObject.optJSONObject("pkg_clean_strategy"));
        ng4.a().d(jSONObject.optJSONObject("pkg_preload"));
        vg4.f(jSONObject.optJSONObject("app_inner_preload"));
        gg4.a().c(jSONObject.optJSONObject("getpkg_retry_switch"));
        sg4.b().d(jSONObject.optJSONObject("tts"));
        og4.a().e(jSONObject.optJSONObject("simple_control_item"));
        tg4.e(jSONObject.optJSONObject("update_expire_time"));
        if (pg4.a) {
            c(jSONObject);
        }
        rg4.b().f(jSONObject.optJSONObject("web_degrade_strategy"));
        ig4.a().c(jSONObject.optJSONObject("local_debug"));
        ub4.a().b(jSONObject.optJSONObject(ub4.a().c()));
        if (qg4.b()) {
            kg4.a().b(jSONObject.optJSONObject("api_description"));
        }
        jg4.a().e(jSONObject.optJSONObject("no_history_apps"));
    }

    public final void c(@NonNull JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) != null) || (optJSONObject = jSONObject.optJSONObject("heartbeat")) == null || optJSONObject.optLong("errno") != 0) {
            return;
        }
        sb4 b = ub4.b();
        lk4 lk4Var = null;
        if (b != null) {
            lk4Var = b.i();
        }
        String optString = optJSONObject.optString("version");
        if (!TextUtils.isEmpty(optString)) {
            pg4.b = optString;
            if (lk4Var != null) {
                lk4Var.putString("key_h2_heart_beat_version", optString);
            }
        }
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("data");
        if (optJSONObject2 != null) {
            if (optJSONObject2.optInt(SetImageWatermarkTypeReqMsg.SWITCH) > 0) {
                int optInt = optJSONObject2.optInt("timespan");
                int optInt2 = optJSONObject2.optInt(com.alipay.sdk.data.a.O);
                if (lk4Var != null) {
                    if (optInt > 0) {
                        lk4Var.putInt("key_h2_heart_beat_timespan", optInt);
                    }
                    if (optInt2 > 0) {
                        lk4Var.putInt("key_h2_heart_beat_timeout", optInt2);
                        return;
                    }
                    return;
                }
                return;
            }
            pg4.a = false;
        }
    }
}
