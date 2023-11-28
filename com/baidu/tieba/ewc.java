package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.CreationData;
/* loaded from: classes5.dex */
public class ewc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull CreationData creationData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, creationData)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "view_count", creationData.view_count);
            ltc.a(jSONObject, "agree_count", creationData.agree_count);
            ltc.a(jSONObject, "view_count_trend", creationData.view_count_trend);
            ltc.a(jSONObject, "agree_count_trend", creationData.agree_count_trend);
            ltc.a(jSONObject, "comment_count", creationData.comment_count);
            ltc.a(jSONObject, "comment_trend", creationData.comment_trend);
            ltc.a(jSONObject, "valid_play_count", creationData.valid_play_count);
            ltc.a(jSONObject, "valid_play_count_trend", creationData.valid_play_count_trend);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
