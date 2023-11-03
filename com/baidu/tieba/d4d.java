package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import org.json.JSONObject;
import tbclient.TagInfo;
/* loaded from: classes5.dex */
public class d4d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull TagInfo tagInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tagInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "rank_type", tagInfo.rank_type);
            poc.a(jSONObject, "class_id", tagInfo.class_id);
            poc.a(jSONObject, "tab_id", tagInfo.tab_id);
            poc.a(jSONObject, PushConstants.SUB_TAGS_STATUS_NAME, tagInfo.tag_name);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
