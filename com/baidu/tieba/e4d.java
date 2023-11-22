package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import org.json.JSONObject;
import tbclient.TagInfo;
/* loaded from: classes5.dex */
public class e4d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull TagInfo tagInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tagInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "rank_type", tagInfo.rank_type);
            qoc.a(jSONObject, "class_id", tagInfo.class_id);
            qoc.a(jSONObject, "tab_id", tagInfo.tab_id);
            qoc.a(jSONObject, PushConstants.SUB_TAGS_STATUS_NAME, tagInfo.tag_name);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
