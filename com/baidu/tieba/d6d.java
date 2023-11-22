package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.StateInfo;
import tbclient.VirtualImageInfo;
/* loaded from: classes5.dex */
public class d6d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull VirtualImageInfo virtualImageInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, virtualImageInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "isset_virtual_image", virtualImageInfo.isset_virtual_image);
            qoc.a(jSONObject, "virtual_image_url", virtualImageInfo.virtual_image_url);
            qoc.a(jSONObject, "image_agree_count", virtualImageInfo.image_agree_count);
            qoc.a(jSONObject, "is_allow_agree", virtualImageInfo.is_allow_agree);
            qoc.a(jSONObject, "virtual_background_type", virtualImageInfo.virtual_background_type);
            qoc.a(jSONObject, "virtual_background", virtualImageInfo.virtual_background);
            qoc.a(jSONObject, "recent_incr_agree", virtualImageInfo.recent_incr_agree);
            qoc.a(jSONObject, "snapshoot_id", virtualImageInfo.snapshoot_id);
            StateInfo stateInfo = virtualImageInfo.personal_state;
            if (stateInfo != null) {
                qoc.a(jSONObject, "personal_state", t3d.b(stateInfo));
            }
            if (virtualImageInfo.state_list != null) {
                JSONArray jSONArray = new JSONArray();
                for (StateInfo stateInfo2 : virtualImageInfo.state_list) {
                    jSONArray.put(t3d.b(stateInfo2));
                }
                qoc.a(jSONObject, "state_list", jSONArray);
            }
            qoc.a(jSONObject, "allow_customize", virtualImageInfo.allow_customize);
            qoc.a(jSONObject, "is_display", virtualImageInfo.is_display);
            qoc.a(jSONObject, "is_background_firstly", virtualImageInfo.is_background_firstly);
            qoc.a(jSONObject, "dynamic_virtual_image_url", virtualImageInfo.dynamic_virtual_image_url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
