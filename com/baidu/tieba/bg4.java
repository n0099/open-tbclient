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
public class bg4 extends nf4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public bg4() {
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

    @Override // com.baidu.tieba.nf4, com.baidu.tieba.qf4
    public void b(JSONObject jSONObject, ac4 ac4Var, @Nullable ac4 ac4Var2, @Nullable ac4 ac4Var3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(1048576, this, jSONObject, ac4Var, ac4Var2, ac4Var3) != null) || jSONObject == null) {
            return;
        }
        dg4.b().e(jSONObject.optJSONObject("tipmsgs"));
        hg4.f().k(jSONObject.optJSONObject("page_tips"));
        zf4.b().d(jSONObject.optJSONObject("pkg_clean_strategy"));
        jg4.a().d(jSONObject.optJSONObject("pkg_preload"));
        rg4.f(jSONObject.optJSONObject("app_inner_preload"));
        cg4.a().c(jSONObject.optJSONObject("getpkg_retry_switch"));
        og4.b().d(jSONObject.optJSONObject("tts"));
        kg4.a().e(jSONObject.optJSONObject("simple_control_item"));
        pg4.e(jSONObject.optJSONObject("update_expire_time"));
        if (lg4.a) {
            c(jSONObject);
        }
        ng4.b().f(jSONObject.optJSONObject("web_degrade_strategy"));
        eg4.a().c(jSONObject.optJSONObject("local_debug"));
        qb4.a().b(jSONObject.optJSONObject(qb4.a().c()));
        if (mg4.b()) {
            gg4.a().b(jSONObject.optJSONObject("api_description"));
        }
        fg4.a().e(jSONObject.optJSONObject("no_history_apps"));
    }

    public final void c(@NonNull JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) != null) || (optJSONObject = jSONObject.optJSONObject("heartbeat")) == null || optJSONObject.optLong("errno") != 0) {
            return;
        }
        ob4 b = qb4.b();
        hk4 hk4Var = null;
        if (b != null) {
            hk4Var = b.i();
        }
        String optString = optJSONObject.optString("version");
        if (!TextUtils.isEmpty(optString)) {
            lg4.b = optString;
            if (hk4Var != null) {
                hk4Var.putString("key_h2_heart_beat_version", optString);
            }
        }
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("data");
        if (optJSONObject2 != null) {
            if (optJSONObject2.optInt(SetImageWatermarkTypeReqMsg.SWITCH) > 0) {
                int optInt = optJSONObject2.optInt("timespan");
                int optInt2 = optJSONObject2.optInt("timeout");
                if (hk4Var != null) {
                    if (optInt > 0) {
                        hk4Var.putInt("key_h2_heart_beat_timespan", optInt);
                    }
                    if (optInt2 > 0) {
                        hk4Var.putInt("key_h2_heart_beat_timeout", optInt2);
                        return;
                    }
                    return;
                }
                return;
            }
            lg4.a = false;
        }
    }
}
