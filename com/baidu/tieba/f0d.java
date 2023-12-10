package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.ForumGroup;
import tbclient.FrsPage.GroupFeedCard;
import tbclient.FrsPage.TopbarEntrance;
/* loaded from: classes5.dex */
public class f0d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ForumGroup forumGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, forumGroup)) == null) {
            JSONObject jSONObject = new JSONObject();
            TopbarEntrance topbarEntrance = forumGroup.topbar_entrance;
            if (topbarEntrance != null) {
                ltc.a(jSONObject, "topbar_entrance", t2d.b(topbarEntrance));
            }
            GroupFeedCard groupFeedCard = forumGroup.feed_card;
            if (groupFeedCard != null) {
                ltc.a(jSONObject, "feed_card", p0d.b(groupFeedCard));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
