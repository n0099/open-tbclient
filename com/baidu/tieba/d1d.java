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
public class d1d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull NebulaHotThread nebulaHotThread) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, nebulaHotThread)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "thread_id", nebulaHotThread.thread_id);
            ktc.a(jSONObject, "group_name", nebulaHotThread.group_name);
            ktc.a(jSONObject, "comment_number", nebulaHotThread.comment_number);
            ktc.a(jSONObject, MultiRatePlayUrlHelper.RANK, nebulaHotThread.rank);
            ktc.a(jSONObject, "url", nebulaHotThread.url);
            ktc.a(jSONObject, "thread_thumbnail_type", nebulaHotThread.thread_thumbnail_type);
            ktc.a(jSONObject, "thread_thumbnail", nebulaHotThread.thread_thumbnail);
            if (nebulaHotThread.content != null) {
                JSONArray jSONArray = new JSONArray();
                for (PbContent pbContent : nebulaHotThread.content) {
                    jSONArray.put(z5d.b(pbContent));
                }
                ktc.a(jSONObject, "content", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
