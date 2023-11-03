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
public class evc extends poc {
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
                poc.a(jSONObject, "topbar_entrance", pxc.b(topbarEntrance));
            }
            GroupFeedCard groupFeedCard = forumGroup.feed_card;
            if (groupFeedCard != null) {
                poc.a(jSONObject, "feed_card", ovc.b(groupFeedCard));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
