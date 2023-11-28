package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.McnAdInfo;
/* loaded from: classes5.dex */
public class b5d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull McnAdInfo mcnAdInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, mcnAdInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "ad_start_time", mcnAdInfo.ad_start_time);
            ltc.a(jSONObject, "ad_end_time", mcnAdInfo.ad_end_time);
            ltc.a(jSONObject, "pic_url", mcnAdInfo.pic_url);
            ltc.a(jSONObject, BigdayActivityConfig.JUMP_URL, mcnAdInfo.jump_url);
            ltc.a(jSONObject, "card_title", mcnAdInfo.card_title);
            ltc.a(jSONObject, "button_title", mcnAdInfo.button_title);
            ltc.a(jSONObject, "effect_time", mcnAdInfo.effect_time);
            ltc.a(jSONObject, "expire_time", mcnAdInfo.expire_time);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
