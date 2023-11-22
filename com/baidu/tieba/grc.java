package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.CreationData;
/* loaded from: classes6.dex */
public class grc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull CreationData creationData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, creationData)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "view_count", creationData.view_count);
            qoc.a(jSONObject, "agree_count", creationData.agree_count);
            qoc.a(jSONObject, "view_count_trend", creationData.view_count_trend);
            qoc.a(jSONObject, "agree_count_trend", creationData.agree_count_trend);
            qoc.a(jSONObject, "comment_count", creationData.comment_count);
            qoc.a(jSONObject, "comment_trend", creationData.comment_trend);
            qoc.a(jSONObject, "valid_play_count", creationData.valid_play_count);
            qoc.a(jSONObject, "valid_play_count_trend", creationData.valid_play_count_trend);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
