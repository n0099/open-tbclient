package com.baidu.tieba.enterForum.recommend.b;

import tbclient.RecommendForumInfo;
/* loaded from: classes9.dex */
public class b {
    public String authen;
    public String avatar;
    public boolean cRb;
    public String extra;
    public int fXK;
    public String fXL;
    public boolean fXM;
    public String fXN;
    public String fXO;
    public int fXP;
    public long forumId;
    public String forumName;
    public int memberCount;
    public String slogan;
    public String source;
    public int threadCount;

    public void b(RecommendForumInfo recommendForumInfo) {
        this.avatar = recommendForumInfo.avatar;
        this.forumId = recommendForumInfo.forum_id.longValue();
        this.forumName = recommendForumInfo.forum_name;
        this.cRb = recommendForumInfo.is_like.intValue() == 1;
        this.memberCount = recommendForumInfo.member_count.intValue();
        this.threadCount = recommendForumInfo.thread_count.intValue();
        this.slogan = recommendForumInfo.slogan;
        this.fXK = recommendForumInfo.forum_type.intValue();
        this.authen = recommendForumInfo.authen;
        this.fXL = recommendForumInfo.recom_reason;
        this.fXM = recommendForumInfo.is_brand_forum.intValue() == 1;
        this.fXN = recommendForumInfo.hot_text;
        this.fXO = recommendForumInfo.abtest_tag;
        this.source = recommendForumInfo.source;
        this.extra = recommendForumInfo.extra;
        this.fXP = 1;
    }
}
