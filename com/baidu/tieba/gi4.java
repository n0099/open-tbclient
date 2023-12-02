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
/* loaded from: classes6.dex */
public class gi4 extends sh4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public gi4() {
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

    @Override // com.baidu.tieba.sh4, com.baidu.tieba.vh4
    public void b(JSONObject jSONObject, fe4 fe4Var, @Nullable fe4 fe4Var2, @Nullable fe4 fe4Var3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(1048576, this, jSONObject, fe4Var, fe4Var2, fe4Var3) != null) || jSONObject == null) {
            return;
        }
        ii4.b().e(jSONObject.optJSONObject("tipmsgs"));
        mi4.f().k(jSONObject.optJSONObject("page_tips"));
        ei4.b().d(jSONObject.optJSONObject("pkg_clean_strategy"));
        oi4.a().d(jSONObject.optJSONObject("pkg_preload"));
        wi4.f(jSONObject.optJSONObject("app_inner_preload"));
        hi4.a().c(jSONObject.optJSONObject("getpkg_retry_switch"));
        ti4.b().d(jSONObject.optJSONObject("tts"));
        pi4.a().e(jSONObject.optJSONObject("simple_control_item"));
        ui4.e(jSONObject.optJSONObject("update_expire_time"));
        if (qi4.a) {
            c(jSONObject);
        }
        si4.b().f(jSONObject.optJSONObject("web_degrade_strategy"));
        ji4.a().c(jSONObject.optJSONObject("local_debug"));
        vd4.a().b(jSONObject.optJSONObject(vd4.a().c()));
        if (ri4.b()) {
            li4.a().b(jSONObject.optJSONObject("api_description"));
        }
        ki4.a().e(jSONObject.optJSONObject("no_history_apps"));
    }

    public final void c(@NonNull JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) != null) || (optJSONObject = jSONObject.optJSONObject("heartbeat")) == null || optJSONObject.optLong("errno") != 0) {
            return;
        }
        td4 b = vd4.b();
        lm4 lm4Var = null;
        if (b != null) {
            lm4Var = b.i();
        }
        String optString = optJSONObject.optString("version");
        if (!TextUtils.isEmpty(optString)) {
            qi4.b = optString;
            if (lm4Var != null) {
                lm4Var.putString("key_h2_heart_beat_version", optString);
            }
        }
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("data");
        if (optJSONObject2 != null) {
            if (optJSONObject2.optInt("switch") > 0) {
                int optInt = optJSONObject2.optInt("timespan");
                int optInt2 = optJSONObject2.optInt("timeout");
                if (lm4Var != null) {
                    if (optInt > 0) {
                        lm4Var.putInt("key_h2_heart_beat_timespan", optInt);
                    }
                    if (optInt2 > 0) {
                        lm4Var.putInt("key_h2_heart_beat_timeout", optInt2);
                        return;
                    }
                    return;
                }
                return;
            }
            qi4.a = false;
        }
    }
}
