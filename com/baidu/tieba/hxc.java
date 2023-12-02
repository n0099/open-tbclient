package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FeedForumInfo;
/* loaded from: classes6.dex */
public class hxc extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FeedForumInfo feedForumInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, feedForumInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "forum_id", feedForumInfo.forum_id);
            ktc.a(jSONObject, "forum_name", feedForumInfo.forum_name);
            ktc.a(jSONObject, "member_count", feedForumInfo.member_count);
            ktc.a(jSONObject, "post_num", feedForumInfo.post_num);
            ktc.a(jSONObject, "avatar", feedForumInfo.avatar);
            ktc.a(jSONObject, "reason", feedForumInfo.reason);
            ktc.a(jSONObject, "pos", feedForumInfo.pos);
            ktc.a(jSONObject, "is_like", feedForumInfo.is_like);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
