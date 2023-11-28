package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.SignActivityInfo;
/* loaded from: classes6.dex */
public class g8d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull SignActivityInfo signActivityInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, signActivityInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "activity_id", signActivityInfo.activity_id);
            ltc.a(jSONObject, "activity_time", signActivityInfo.activity_time);
            ltc.a(jSONObject, "countdown_time", signActivityInfo.countdown_time);
            ltc.a(jSONObject, "activity_duration", signActivityInfo.activity_duration);
            ltc.a(jSONObject, "countdown_msg", signActivityInfo.countdown_msg);
            ltc.a(jSONObject, "activity_msg", signActivityInfo.activity_msg);
            ltc.a(jSONObject, "activity_suc_msg", signActivityInfo.activity_suc_msg);
            ltc.a(jSONObject, "activity_fail_msg", signActivityInfo.activity_fail_msg);
            ltc.a(jSONObject, "gift_type", signActivityInfo.gift_type);
            ltc.a(jSONObject, "gift_url", signActivityInfo.gift_url);
            ltc.a(jSONObject, "gift_name", signActivityInfo.gift_name);
            ltc.a(jSONObject, "icon_name", signActivityInfo.icon_name);
            ltc.a(jSONObject, "icon_lifecycle", signActivityInfo.icon_lifecycle);
            ltc.a(jSONObject, "activity_name", signActivityInfo.activity_name);
            ltc.a(jSONObject, EditHeadActivityConfig.IMAGE_URL, signActivityInfo.image_url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
