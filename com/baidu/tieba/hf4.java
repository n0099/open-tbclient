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
public class hf4 extends te4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public hf4() {
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

    @Override // com.baidu.tieba.te4, com.baidu.tieba.we4
    public void b(JSONObject jSONObject, gb4 gb4Var, @Nullable gb4 gb4Var2, @Nullable gb4 gb4Var3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048576, this, jSONObject, gb4Var, gb4Var2, gb4Var3) == null) || jSONObject == null) {
            return;
        }
        jf4.b().e(jSONObject.optJSONObject("tipmsgs"));
        nf4.f().k(jSONObject.optJSONObject("page_tips"));
        ff4.b().d(jSONObject.optJSONObject("pkg_clean_strategy"));
        pf4.a().d(jSONObject.optJSONObject("pkg_preload"));
        xf4.f(jSONObject.optJSONObject("app_inner_preload"));
        if4.a().c(jSONObject.optJSONObject("getpkg_retry_switch"));
        uf4.b().d(jSONObject.optJSONObject("tts"));
        qf4.a().e(jSONObject.optJSONObject("simple_control_item"));
        vf4.e(jSONObject.optJSONObject("update_expire_time"));
        if (rf4.a) {
            c(jSONObject);
        }
        tf4.b().f(jSONObject.optJSONObject("web_degrade_strategy"));
        kf4.a().c(jSONObject.optJSONObject("local_debug"));
        wa4.a().b(jSONObject.optJSONObject(wa4.a().c()));
        if (sf4.b()) {
            mf4.a().b(jSONObject.optJSONObject("api_description"));
        }
        lf4.a().e(jSONObject.optJSONObject("no_history_apps"));
    }

    public final void c(@NonNull JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) && (optJSONObject = jSONObject.optJSONObject("heartbeat")) != null && optJSONObject.optLong("errno") == 0) {
            ua4 b = wa4.b();
            nj4 i = b != null ? b.i() : null;
            String optString = optJSONObject.optString("version");
            if (!TextUtils.isEmpty(optString)) {
                rf4.b = optString;
                if (i != null) {
                    i.putString("key_h2_heart_beat_version", optString);
                }
            }
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("data");
            if (optJSONObject2 != null) {
                if (optJSONObject2.optInt(SetImageWatermarkTypeReqMsg.SWITCH) > 0) {
                    int optInt = optJSONObject2.optInt("timespan");
                    int optInt2 = optJSONObject2.optInt("timeout");
                    if (i != null) {
                        if (optInt > 0) {
                            i.putInt("key_h2_heart_beat_timespan", optInt);
                        }
                        if (optInt2 > 0) {
                            i.putInt("key_h2_heart_beat_timeout", optInt2);
                            return;
                        }
                        return;
                    }
                    return;
                }
                rf4.a = false;
            }
        }
    }
}
