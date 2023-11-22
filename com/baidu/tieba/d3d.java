package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.SignActivityInfo;
/* loaded from: classes5.dex */
public class d3d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull SignActivityInfo signActivityInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, signActivityInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "activity_id", signActivityInfo.activity_id);
            qoc.a(jSONObject, "activity_time", signActivityInfo.activity_time);
            qoc.a(jSONObject, "countdown_time", signActivityInfo.countdown_time);
            qoc.a(jSONObject, "activity_duration", signActivityInfo.activity_duration);
            qoc.a(jSONObject, "countdown_msg", signActivityInfo.countdown_msg);
            qoc.a(jSONObject, "activity_msg", signActivityInfo.activity_msg);
            qoc.a(jSONObject, "activity_suc_msg", signActivityInfo.activity_suc_msg);
            qoc.a(jSONObject, "activity_fail_msg", signActivityInfo.activity_fail_msg);
            qoc.a(jSONObject, "gift_type", signActivityInfo.gift_type);
            qoc.a(jSONObject, "gift_url", signActivityInfo.gift_url);
            qoc.a(jSONObject, "gift_name", signActivityInfo.gift_name);
            qoc.a(jSONObject, "icon_name", signActivityInfo.icon_name);
            qoc.a(jSONObject, "icon_lifecycle", signActivityInfo.icon_lifecycle);
            qoc.a(jSONObject, "activity_name", signActivityInfo.activity_name);
            qoc.a(jSONObject, EditHeadActivityConfig.IMAGE_URL, signActivityInfo.image_url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
