package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.StateInfo;
import tbclient.VirtualImageInfo;
/* loaded from: classes6.dex */
public class hbd extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull VirtualImageInfo virtualImageInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, virtualImageInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "isset_virtual_image", virtualImageInfo.isset_virtual_image);
            ltc.a(jSONObject, "virtual_image_url", virtualImageInfo.virtual_image_url);
            ltc.a(jSONObject, "image_agree_count", virtualImageInfo.image_agree_count);
            ltc.a(jSONObject, "is_allow_agree", virtualImageInfo.is_allow_agree);
            ltc.a(jSONObject, "virtual_background_type", virtualImageInfo.virtual_background_type);
            ltc.a(jSONObject, "virtual_background", virtualImageInfo.virtual_background);
            ltc.a(jSONObject, "recent_incr_agree", virtualImageInfo.recent_incr_agree);
            ltc.a(jSONObject, "snapshoot_id", virtualImageInfo.snapshoot_id);
            StateInfo stateInfo = virtualImageInfo.personal_state;
            if (stateInfo != null) {
                ltc.a(jSONObject, "personal_state", w8d.b(stateInfo));
            }
            if (virtualImageInfo.state_list != null) {
                JSONArray jSONArray = new JSONArray();
                for (StateInfo stateInfo2 : virtualImageInfo.state_list) {
                    jSONArray.put(w8d.b(stateInfo2));
                }
                ltc.a(jSONObject, "state_list", jSONArray);
            }
            ltc.a(jSONObject, "allow_customize", virtualImageInfo.allow_customize);
            ltc.a(jSONObject, "is_display", virtualImageInfo.is_display);
            ltc.a(jSONObject, "is_background_firstly", virtualImageInfo.is_background_firstly);
            ltc.a(jSONObject, "dynamic_virtual_image_url", virtualImageInfo.dynamic_virtual_image_url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
