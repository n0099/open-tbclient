package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.MatchPlayerInfo;
import tbclient.Post;
/* loaded from: classes5.dex */
public class a1d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull MatchPlayerInfo matchPlayerInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, matchPlayerInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "name", matchPlayerInfo.name);
            ltc.a(jSONObject, "avatar", matchPlayerInfo.avatar);
            ltc.a(jSONObject, "score", matchPlayerInfo.score);
            ltc.a(jSONObject, "score_cnt", matchPlayerInfo.score_cnt);
            Post post = matchPlayerInfo.hot_post;
            if (post != null) {
                ltc.a(jSONObject, "hot_post", t6d.b(post));
            }
            ltc.a(jSONObject, "sub_avatar", matchPlayerInfo.sub_avatar);
            ltc.a(jSONObject, "sub_text", matchPlayerInfo.sub_text);
            ltc.a(jSONObject, "score_self", matchPlayerInfo.score_self);
            ltc.a(jSONObject, "score_link", matchPlayerInfo.score_link);
            ltc.a(jSONObject, "match_id", matchPlayerInfo.match_id);
            ltc.a(jSONObject, "match_index", matchPlayerInfo.match_index);
            ltc.a(jSONObject, "player_id", matchPlayerInfo.player_id);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
