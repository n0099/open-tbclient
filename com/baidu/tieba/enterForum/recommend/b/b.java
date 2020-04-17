package com.baidu.tieba.enterForum.recommend.b;

import tbclient.RecommendForumInfo;
/* loaded from: classes9.dex */
public class b {
    public String authen;
    public String avatar;
    public boolean dqh;
    public String extra;
    public long forumId;
    public String forumName;
    public int gEo;
    public String gEp;
    public boolean gEq;
    public String gEr;
    public String gEs;
    public int gEt;
    public int memberCount;
    public String slogan;
    public String source;
    public int threadCount;

    public void b(RecommendForumInfo recommendForumInfo) {
        this.avatar = recommendForumInfo.avatar;
        this.forumId = recommendForumInfo.forum_id.longValue();
        this.forumName = recommendForumInfo.forum_name;
        this.dqh = recommendForumInfo.is_like.intValue() == 1;
        this.memberCount = recommendForumInfo.member_count.intValue();
        this.threadCount = recommendForumInfo.thread_count.intValue();
        this.slogan = recommendForumInfo.slogan;
        this.gEo = recommendForumInfo.forum_type.intValue();
        this.authen = recommendForumInfo.authen;
        this.gEp = recommendForumInfo.recom_reason;
        this.gEq = recommendForumInfo.is_brand_forum.intValue() == 1;
        this.gEr = recommendForumInfo.hot_text;
        this.gEs = recommendForumInfo.abtest_tag;
        this.source = recommendForumInfo.source;
        this.extra = recommendForumInfo.extra;
        this.gEt = 1;
    }
}
