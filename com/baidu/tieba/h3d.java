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
public class h3d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull SimpleForum simpleForum) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, simpleForum)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "id", simpleForum.id);
            qoc.a(jSONObject, "name", simpleForum.name);
            qoc.a(jSONObject, "is_exists", simpleForum.is_exists);
            qoc.a(jSONObject, "avatar", simpleForum.avatar);
            qoc.a(jSONObject, "is_liked", simpleForum.is_liked);
            qoc.a(jSONObject, "is_signed", simpleForum.is_signed);
            qoc.a(jSONObject, "first_class", simpleForum.first_class);
            qoc.a(jSONObject, "second_class", simpleForum.second_class);
            qoc.a(jSONObject, "ext", simpleForum.ext);
            qoc.a(jSONObject, "level_id", simpleForum.level_id);
            MultiForumPerm multiForumPerm = simpleForum.multi_forum_perm;
            if (multiForumPerm != null) {
                qoc.a(jSONObject, "multi_forum_perm", d0d.b(multiForumPerm));
            }
            qoc.a(jSONObject, "member_num", simpleForum.member_num);
            qoc.a(jSONObject, "post_num", simpleForum.post_num);
            qoc.a(jSONObject, "is_brand_forum", simpleForum.is_brand_forum);
            if (simpleForum.tab_info != null) {
                JSONArray jSONArray = new JSONArray();
                for (FrsTabInfo frsTabInfo : simpleForum.tab_info) {
                    jSONArray.put(fyc.b(frsTabInfo));
                }
                qoc.a(jSONObject, "tab_info", jSONArray);
            }
            qoc.a(jSONObject, "forum_toutu", simpleForum.forum_toutu);
            DeletedReasonInfo deletedReasonInfo = simpleForum.deleted_reason_info;
            if (deletedReasonInfo != null) {
                qoc.a(jSONObject, "deleted_reason_info", orc.b(deletedReasonInfo));
            }
            qoc.a(jSONObject, "is_frs_mask", simpleForum.is_frs_mask);
            ThemeColorInfo themeColorInfo = simpleForum.theme_color;
            if (themeColorInfo != null) {
                qoc.a(jSONObject, "theme_color", q4d.b(themeColorInfo));
            }
            qoc.a(jSONObject, "recommend_tip", simpleForum.recommend_tip);
            if (simpleForum.pendants != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (String str : simpleForum.pendants) {
                    jSONArray2.put(str);
                }
                qoc.a(jSONObject, "pendants", jSONArray2);
            }
            ForumShowInfo forumShowInfo = simpleForum.show_info;
            if (forumShowInfo != null) {
                qoc.a(jSONObject, "show_info", ptc.b(forumShowInfo));
            }
            SpritePBGuide spritePBGuide = simpleForum.sprite_pb_guide;
            if (spritePBGuide != null) {
                qoc.a(jSONObject, "sprite_pb_guide", q3d.b(spritePBGuide));
            }
            qoc.a(jSONObject, "scheme", simpleForum.scheme);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
