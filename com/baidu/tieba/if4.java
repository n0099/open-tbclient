package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class if4 extends ue4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public if4() {
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

    @Override // com.baidu.tieba.ue4, com.baidu.tieba.xe4
    public void b(JSONObject jSONObject, hb4 hb4Var, hb4 hb4Var2, hb4 hb4Var3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(1048576, this, jSONObject, hb4Var, hb4Var2, hb4Var3) != null) || jSONObject == null) {
            return;
        }
        kf4.b().e(jSONObject.optJSONObject("tipmsgs"));
        of4.f().k(jSONObject.optJSONObject("page_tips"));
        gf4.b().d(jSONObject.optJSONObject("pkg_clean_strategy"));
        qf4.a().d(jSONObject.optJSONObject("pkg_preload"));
        yf4.f(jSONObject.optJSONObject("app_inner_preload"));
        jf4.a().c(jSONObject.optJSONObject("getpkg_retry_switch"));
        vf4.b().d(jSONObject.optJSONObject("tts"));
        rf4.a().e(jSONObject.optJSONObject("simple_control_item"));
        wf4.e(jSONObject.optJSONObject("update_expire_time"));
        if (sf4.a) {
            c(jSONObject);
        }
        uf4.b().f(jSONObject.optJSONObject("web_degrade_strategy"));
        lf4.a().c(jSONObject.optJSONObject("local_debug"));
        xa4.a().b(jSONObject.optJSONObject(xa4.a().c()));
        if (tf4.b()) {
            nf4.a().b(jSONObject.optJSONObject("api_description"));
        }
        mf4.a().e(jSONObject.optJSONObject("no_history_apps"));
    }

    public final void c(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) != null) || (optJSONObject = jSONObject.optJSONObject("heartbeat")) == null || optJSONObject.optLong("errno") != 0) {
            return;
        }
        va4 b = xa4.b();
        oj4 oj4Var = null;
        if (b != null) {
            oj4Var = b.i();
        }
        String optString = optJSONObject.optString("version");
        if (!TextUtils.isEmpty(optString)) {
            sf4.b = optString;
            if (oj4Var != null) {
                oj4Var.putString("key_h2_heart_beat_version", optString);
            }
        }
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("data");
        if (optJSONObject2 != null) {
            if (optJSONObject2.optInt(SetImageWatermarkTypeReqMsg.SWITCH) > 0) {
                int optInt = optJSONObject2.optInt("timespan");
                int optInt2 = optJSONObject2.optInt("timeout");
                if (oj4Var != null) {
                    if (optInt > 0) {
                        oj4Var.putInt("key_h2_heart_beat_timespan", optInt);
                    }
                    if (optInt2 > 0) {
                        oj4Var.putInt("key_h2_heart_beat_timeout", optInt2);
                        return;
                    }
                    return;
                }
                return;
            }
            sf4.a = false;
        }
    }
}
