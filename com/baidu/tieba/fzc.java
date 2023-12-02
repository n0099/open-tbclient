package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes6.dex */
public class fzc extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Banner banner) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, banner)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "banner_url", banner.banner_url);
            ktc.a(jSONObject, "banner_type", banner.banner_type);
            ktc.a(jSONObject, "value", banner.value);
            ktc.a(jSONObject, "type", banner.type);
            ktc.a(jSONObject, "desc", banner.desc);
            ktc.a(jSONObject, "template_id", banner.template_id);
            ktc.a(jSONObject, "obj_id", banner.obj_id);
            ktc.a(jSONObject, PushConstants.SUB_TAGS_STATUS_NAME, banner.tag_name);
            ktc.a(jSONObject, "tag_name_url", banner.tag_name_url);
            ktc.a(jSONObject, "tag_name_wh", banner.tag_name_wh);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
