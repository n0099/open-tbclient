package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes6.dex */
public class huc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Banner banner) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, banner)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "banner_url", banner.banner_url);
            qoc.a(jSONObject, "banner_type", banner.banner_type);
            qoc.a(jSONObject, "value", banner.value);
            qoc.a(jSONObject, "type", banner.type);
            qoc.a(jSONObject, "desc", banner.desc);
            qoc.a(jSONObject, "template_id", banner.template_id);
            qoc.a(jSONObject, "obj_id", banner.obj_id);
            qoc.a(jSONObject, PushConstants.SUB_TAGS_STATUS_NAME, banner.tag_name);
            qoc.a(jSONObject, "tag_name_url", banner.tag_name_url);
            qoc.a(jSONObject, "tag_name_wh", banner.tag_name_wh);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
