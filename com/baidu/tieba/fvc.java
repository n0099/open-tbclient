package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.ForumGroup;
import tbclient.FrsPage.GroupFeedCard;
import tbclient.FrsPage.TopbarEntrance;
/* loaded from: classes6.dex */
public class fvc extends qoc {
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
                qoc.a(jSONObject, "topbar_entrance", qxc.b(topbarEntrance));
            }
            GroupFeedCard groupFeedCard = forumGroup.feed_card;
            if (groupFeedCard != null) {
                qoc.a(jSONObject, "feed_card", pvc.b(groupFeedCard));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
