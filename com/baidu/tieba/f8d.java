package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.SignActivityInfo;
/* loaded from: classes5.dex */
public class f8d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull SignActivityInfo signActivityInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, signActivityInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "activity_id", signActivityInfo.activity_id);
            ktc.a(jSONObject, "activity_time", signActivityInfo.activity_time);
            ktc.a(jSONObject, "countdown_time", signActivityInfo.countdown_time);
            ktc.a(jSONObject, "activity_duration", signActivityInfo.activity_duration);
            ktc.a(jSONObject, "countdown_msg", signActivityInfo.countdown_msg);
            ktc.a(jSONObject, "activity_msg", signActivityInfo.activity_msg);
            ktc.a(jSONObject, "activity_suc_msg", signActivityInfo.activity_suc_msg);
            ktc.a(jSONObject, "activity_fail_msg", signActivityInfo.activity_fail_msg);
            ktc.a(jSONObject, "gift_type", signActivityInfo.gift_type);
            ktc.a(jSONObject, "gift_url", signActivityInfo.gift_url);
            ktc.a(jSONObject, "gift_name", signActivityInfo.gift_name);
            ktc.a(jSONObject, "icon_name", signActivityInfo.icon_name);
            ktc.a(jSONObject, "icon_lifecycle", signActivityInfo.icon_lifecycle);
            ktc.a(jSONObject, "activity_name", signActivityInfo.activity_name);
            ktc.a(jSONObject, EditHeadActivityConfig.IMAGE_URL, signActivityInfo.image_url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
