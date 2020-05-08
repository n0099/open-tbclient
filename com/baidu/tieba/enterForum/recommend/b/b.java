package com.baidu.tieba.enterForum.recommend.b;

import tbclient.RecommendForumInfo;
/* loaded from: classes9.dex */
public class b {
    public String authen;
    public String avatar;
    public boolean dql;
    public String extra;
    public long forumId;
    public String forumName;
    public int gEu;
    public String gEv;
    public boolean gEw;
    public String gEx;
    public String gEy;
    public int gEz;
    public int memberCount;
    public String slogan;
    public String source;
    public int threadCount;

    public void b(RecommendForumInfo recommendForumInfo) {
        this.avatar = recommendForumInfo.avatar;
        this.forumId = recommendForumInfo.forum_id.longValue();
        this.forumName = recommendForumInfo.forum_name;
        this.dql = recommendForumInfo.is_like.intValue() == 1;
        this.memberCount = recommendForumInfo.member_count.intValue();
        this.threadCount = recommendForumInfo.thread_count.intValue();
        this.slogan = recommendForumInfo.slogan;
        this.gEu = recommendForumInfo.forum_type.intValue();
        this.authen = recommendForumInfo.authen;
        this.gEv = recommendForumInfo.recom_reason;
        this.gEw = recommendForumInfo.is_brand_forum.intValue() == 1;
        this.gEx = recommendForumInfo.hot_text;
        this.gEy = recommendForumInfo.abtest_tag;
        this.source = recommendForumInfo.source;
        this.extra = recommendForumInfo.extra;
        this.gEz = 1;
    }
}
