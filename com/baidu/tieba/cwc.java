package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.searchbox.live.interfaces.defaultimpl.utils.MultiRatePlayUrlHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.FrsPage.NebulaHotThread;
import tbclient.PbContent;
/* loaded from: classes5.dex */
public class cwc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull NebulaHotThread nebulaHotThread) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, nebulaHotThread)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "thread_id", nebulaHotThread.thread_id);
            poc.a(jSONObject, "group_name", nebulaHotThread.group_name);
            poc.a(jSONObject, "comment_number", nebulaHotThread.comment_number);
            poc.a(jSONObject, MultiRatePlayUrlHelper.RANK, nebulaHotThread.rank);
            poc.a(jSONObject, "url", nebulaHotThread.url);
            poc.a(jSONObject, "thread_thumbnail_type", nebulaHotThread.thread_thumbnail_type);
            poc.a(jSONObject, "thread_thumbnail", nebulaHotThread.thread_thumbnail);
            if (nebulaHotThread.content != null) {
                JSONArray jSONArray = new JSONArray();
                for (PbContent pbContent : nebulaHotThread.content) {
                    jSONArray.put(w0d.b(pbContent));
                }
                poc.a(jSONObject, "content", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
