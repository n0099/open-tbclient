package com.baidu.tieba.enterForum.recommend.b;

import tbclient.RecommendForumInfo;
/* loaded from: classes9.dex */
public class b {
    public String authen;
    public String avatar;
    public boolean cQO;
    public String extra;
    public int fXc;
    public String fXd;
    public boolean fXe;
    public String fXf;
    public String fXg;
    public int fXh;
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
        this.cQO = recommendForumInfo.is_like.intValue() == 1;
        this.memberCount = recommendForumInfo.member_count.intValue();
        this.threadCount = recommendForumInfo.thread_count.intValue();
        this.slogan = recommendForumInfo.slogan;
        this.fXc = recommendForumInfo.forum_type.intValue();
        this.authen = recommendForumInfo.authen;
        this.fXd = recommendForumInfo.recom_reason;
        this.fXe = recommendForumInfo.is_brand_forum.intValue() == 1;
        this.fXf = recommendForumInfo.hot_text;
        this.fXg = recommendForumInfo.abtest_tag;
        this.source = recommendForumInfo.source;
        this.extra = recommendForumInfo.extra;
        this.fXh = 1;
    }
}
