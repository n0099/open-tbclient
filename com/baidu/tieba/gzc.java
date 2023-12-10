package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes6.dex */
public class gzc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Banner banner) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, banner)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "banner_url", banner.banner_url);
            ltc.a(jSONObject, "banner_type", banner.banner_type);
            ltc.a(jSONObject, "value", banner.value);
            ltc.a(jSONObject, "type", banner.type);
            ltc.a(jSONObject, "desc", banner.desc);
            ltc.a(jSONObject, "template_id", banner.template_id);
            ltc.a(jSONObject, "obj_id", banner.obj_id);
            ltc.a(jSONObject, PushConstants.SUB_TAGS_STATUS_NAME, banner.tag_name);
            ltc.a(jSONObject, "tag_name_url", banner.tag_name_url);
            ltc.a(jSONObject, "tag_name_wh", banner.tag_name_wh);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
