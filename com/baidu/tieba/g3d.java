package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.DeletedReasonInfo;
import tbclient.ForumShowInfo;
import tbclient.FrsTabInfo;
import tbclient.MultiForumPerm;
import tbclient.SimpleForum;
import tbclient.SpritePBGuide;
import tbclient.ThemeColorInfo;
/* loaded from: classes6.dex */
public class g3d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull SimpleForum simpleForum) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, simpleForum)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "id", simpleForum.id);
            poc.a(jSONObject, "name", simpleForum.name);
            poc.a(jSONObject, "is_exists", simpleForum.is_exists);
            poc.a(jSONObject, "avatar", simpleForum.avatar);
            poc.a(jSONObject, "is_liked", simpleForum.is_liked);
            poc.a(jSONObject, "is_signed", simpleForum.is_signed);
            poc.a(jSONObject, "first_class", simpleForum.first_class);
            poc.a(jSONObject, "second_class", simpleForum.second_class);
            poc.a(jSONObject, "ext", simpleForum.ext);
            poc.a(jSONObject, "level_id", simpleForum.level_id);
            MultiForumPerm multiForumPerm = simpleForum.multi_forum_perm;
            if (multiForumPerm != null) {
                poc.a(jSONObject, "multi_forum_perm", c0d.b(multiForumPerm));
            }
            poc.a(jSONObject, "member_num", simpleForum.member_num);
            poc.a(jSONObject, "post_num", simpleForum.post_num);
            poc.a(jSONObject, "is_brand_forum", simpleForum.is_brand_forum);
            if (simpleForum.tab_info != null) {
                JSONArray jSONArray = new JSONArray();
                for (FrsTabInfo frsTabInfo : simpleForum.tab_info) {
                    jSONArray.put(eyc.b(frsTabInfo));
                }
                poc.a(jSONObject, "tab_info", jSONArray);
            }
            poc.a(jSONObject, "forum_toutu", simpleForum.forum_toutu);
            DeletedReasonInfo deletedReasonInfo = simpleForum.deleted_reason_info;
            if (deletedReasonInfo != null) {
                poc.a(jSONObject, "deleted_reason_info", nrc.b(deletedReasonInfo));
            }
            poc.a(jSONObject, "is_frs_mask", simpleForum.is_frs_mask);
            ThemeColorInfo themeColorInfo = simpleForum.theme_color;
            if (themeColorInfo != null) {
                poc.a(jSONObject, "theme_color", p4d.b(themeColorInfo));
            }
            poc.a(jSONObject, "recommend_tip", simpleForum.recommend_tip);
            if (simpleForum.pendants != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (String str : simpleForum.pendants) {
                    jSONArray2.put(str);
                }
                poc.a(jSONObject, "pendants", jSONArray2);
            }
            ForumShowInfo forumShowInfo = simpleForum.show_info;
            if (forumShowInfo != null) {
                poc.a(jSONObject, "show_info", otc.b(forumShowInfo));
            }
            SpritePBGuide spritePBGuide = simpleForum.sprite_pb_guide;
            if (spritePBGuide != null) {
                poc.a(jSONObject, "sprite_pb_guide", p3d.b(spritePBGuide));
            }
            poc.a(jSONObject, "scheme", simpleForum.scheme);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
