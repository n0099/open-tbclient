package com.baidu.tieba.enterForum.recommend.b;

import tbclient.RecommendForumInfo;
/* loaded from: classes9.dex */
public class b {
    public String authen;
    public String avatar;
    public boolean dEi;
    public String extra;
    public long forumId;
    public String forumName;
    public int gTn;
    public String gTo;
    public boolean gTp;
    public String gTq;
    public String gTr;
    public int gTs;
    public int memberCount;
    public String slogan;
    public String source;
    public int threadCount;

    public void b(RecommendForumInfo recommendForumInfo) {
        this.avatar = recommendForumInfo.avatar;
        this.forumId = recommendForumInfo.forum_id.longValue();
        this.forumName = recommendForumInfo.forum_name;
        this.dEi = recommendForumInfo.is_like.intValue() == 1;
        this.memberCount = recommendForumInfo.member_count.intValue();
        this.threadCount = recommendForumInfo.thread_count.intValue();
        this.slogan = recommendForumInfo.slogan;
        this.gTn = recommendForumInfo.forum_type.intValue();
        this.authen = recommendForumInfo.authen;
        this.gTo = recommendForumInfo.recom_reason;
        this.gTp = recommendForumInfo.is_brand_forum.intValue() == 1;
        this.gTq = recommendForumInfo.hot_text;
        this.gTr = recommendForumInfo.abtest_tag;
        this.source = recommendForumInfo.source;
        this.extra = recommendForumInfo.extra;
        this.gTs = 1;
    }
}
