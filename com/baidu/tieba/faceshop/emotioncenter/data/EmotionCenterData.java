package com.baidu.tieba.faceshop.emotioncenter.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tieba.faceshop.EmotionPackageData;
import java.util.List;
/* loaded from: classes8.dex */
public class EmotionCenterData extends OrmObject {
    public String activity_url;
    public List<BannerData> banner;
    public String bazhu_message;
    public EmotionForumData forum;
    public String has_more;
    public String is_bazhu;
    public List<EmotionPackageData> package_list;

    /* loaded from: classes8.dex */
    public static class BannerData extends OrmObject {
        public String action;
        public String url;
    }

    /* loaded from: classes8.dex */
    public static class EmotionForumData extends OrmObject {
        public String avatar;
        public String follow;
        public String forum_id;
        public String forum_name;
        public String intro;
        public String is_follow;
        public String tiezi_num;
    }
}
