package com.baidu.tieba.enterForum.recommend.b;

import tbclient.RecommendForumInfo;
/* loaded from: classes2.dex */
public class b {
    public String authen;
    public String avatar;
    public boolean eRl;
    public String extra;
    public long forumId;
    public String forumName;
    public int iNT;
    public String iNU;
    public boolean iNV;
    public String iNW;
    public String iNX;
    public int iNY;
    public int memberCount;
    public String slogan;
    public String source;
    public int threadCount;

    public void b(RecommendForumInfo recommendForumInfo) {
        this.avatar = recommendForumInfo.avatar;
        this.forumId = recommendForumInfo.forum_id.longValue();
        this.forumName = recommendForumInfo.forum_name;
        this.eRl = recommendForumInfo.is_like.intValue() == 1;
        this.memberCount = recommendForumInfo.member_count.intValue();
        this.threadCount = recommendForumInfo.thread_count.intValue();
        this.slogan = recommendForumInfo.slogan;
        this.iNT = recommendForumInfo.forum_type.intValue();
        this.authen = recommendForumInfo.authen;
        this.iNU = recommendForumInfo.recom_reason;
        this.iNV = recommendForumInfo.is_brand_forum.intValue() == 1;
        this.iNW = recommendForumInfo.hot_text;
        this.iNX = recommendForumInfo.abtest_tag;
        this.source = recommendForumInfo.source;
        this.extra = recommendForumInfo.extra;
        this.iNY = 1;
    }
}
