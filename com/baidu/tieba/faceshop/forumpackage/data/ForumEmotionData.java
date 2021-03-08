package com.baidu.tieba.faceshop.forumpackage.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tieba.faceshop.emotioncenter.data.EmotionCenterData;
import java.util.List;
/* loaded from: classes8.dex */
public class ForumEmotionData extends OrmObject {
    public String activity_url;
    public List<EmotionCenterData.BannerData> banner;
    public List<String> forum_avatar;
    public int has_more;
    public List<ForumEmotionPackageData> rank_pkg_list;
}
