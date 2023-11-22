package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.ForumActiveInfo;
/* loaded from: classes5.dex */
public class bvc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ForumActiveInfo forumActiveInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, forumActiveInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "forum_brief", forumActiveInfo.forum_brief);
            qoc.a(jSONObject, "forum_share_url", forumActiveInfo.forum_share_url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
