package com.baidu.tieba.enterForum.recommend.b;

import tbclient.RecommendForumInfo;
/* loaded from: classes9.dex */
public class b {
    public String authen;
    public String avatar;
    public boolean dKM;
    public String extra;
    public long forumId;
    public String forumName;
    public int hfW;
    public String hfX;
    public boolean hfY;
    public String hfZ;
    public String hga;
    public int hgb;
    public int memberCount;
    public String slogan;
    public String source;
    public int threadCount;

    public void b(RecommendForumInfo recommendForumInfo) {
        this.avatar = recommendForumInfo.avatar;
        this.forumId = recommendForumInfo.forum_id.longValue();
        this.forumName = recommendForumInfo.forum_name;
        this.dKM = recommendForumInfo.is_like.intValue() == 1;
        this.memberCount = recommendForumInfo.member_count.intValue();
        this.threadCount = recommendForumInfo.thread_count.intValue();
        this.slogan = recommendForumInfo.slogan;
        this.hfW = recommendForumInfo.forum_type.intValue();
        this.authen = recommendForumInfo.authen;
        this.hfX = recommendForumInfo.recom_reason;
        this.hfY = recommendForumInfo.is_brand_forum.intValue() == 1;
        this.hfZ = recommendForumInfo.hot_text;
        this.hga = recommendForumInfo.abtest_tag;
        this.source = recommendForumInfo.source;
        this.extra = recommendForumInfo.extra;
        this.hgb = 1;
    }
}
