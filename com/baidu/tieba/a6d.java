package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.mobstat.Config;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.gson.internal.bind.TypeAdapters;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.VideoTags;
/* loaded from: classes5.dex */
public class a6d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull VideoTags videoTags) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, videoTags)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, Config.TRACE_VISIT_FIRST, videoTags.first);
            qoc.a(jSONObject, TypeAdapters.AnonymousClass27.SECOND, videoTags.second);
            if (videoTags.tags != null) {
                JSONArray jSONArray = new JSONArray();
                for (String str : videoTags.tags) {
                    jSONArray.put(str);
                }
                qoc.a(jSONObject, "tags", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
