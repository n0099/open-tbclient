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
public class c6d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull VirtualImageInfo virtualImageInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, virtualImageInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "isset_virtual_image", virtualImageInfo.isset_virtual_image);
            poc.a(jSONObject, "virtual_image_url", virtualImageInfo.virtual_image_url);
            poc.a(jSONObject, "image_agree_count", virtualImageInfo.image_agree_count);
            poc.a(jSONObject, "is_allow_agree", virtualImageInfo.is_allow_agree);
            poc.a(jSONObject, "virtual_background_type", virtualImageInfo.virtual_background_type);
            poc.a(jSONObject, "virtual_background", virtualImageInfo.virtual_background);
            poc.a(jSONObject, "recent_incr_agree", virtualImageInfo.recent_incr_agree);
            poc.a(jSONObject, "snapshoot_id", virtualImageInfo.snapshoot_id);
            StateInfo stateInfo = virtualImageInfo.personal_state;
            if (stateInfo != null) {
                poc.a(jSONObject, "personal_state", s3d.b(stateInfo));
            }
            if (virtualImageInfo.state_list != null) {
                JSONArray jSONArray = new JSONArray();
                for (StateInfo stateInfo2 : virtualImageInfo.state_list) {
                    jSONArray.put(s3d.b(stateInfo2));
                }
                poc.a(jSONObject, "state_list", jSONArray);
            }
            poc.a(jSONObject, "allow_customize", virtualImageInfo.allow_customize);
            poc.a(jSONObject, "is_display", virtualImageInfo.is_display);
            poc.a(jSONObject, "is_background_firstly", virtualImageInfo.is_background_firstly);
            poc.a(jSONObject, "dynamic_virtual_image_url", virtualImageInfo.dynamic_virtual_image_url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
