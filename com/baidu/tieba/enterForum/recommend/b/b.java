package com.baidu.tieba.enterForum.recommend.b;

import tbclient.RecommendForumInfo;
/* loaded from: classes6.dex */
public class b {
    public String authen;
    public String avatar;
    public boolean cMz;
    public String extra;
    public int fRC;
    public String fRD;
    public boolean fRE;
    public String fRF;
    public String fRG;
    public int fRH;
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
        this.cMz = recommendForumInfo.is_like.intValue() == 1;
        this.memberCount = recommendForumInfo.member_count.intValue();
        this.threadCount = recommendForumInfo.thread_count.intValue();
        this.slogan = recommendForumInfo.slogan;
        this.fRC = recommendForumInfo.forum_type.intValue();
        this.authen = recommendForumInfo.authen;
        this.fRD = recommendForumInfo.recom_reason;
        this.fRE = recommendForumInfo.is_brand_forum.intValue() == 1;
        this.fRF = recommendForumInfo.hot_text;
        this.fRG = recommendForumInfo.abtest_tag;
        this.source = recommendForumInfo.source;
        this.extra = recommendForumInfo.extra;
        this.fRH = 1;
    }
}
