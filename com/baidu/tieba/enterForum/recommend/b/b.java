package com.baidu.tieba.enterForum.recommend.b;

import tbclient.RecommendForumInfo;
/* loaded from: classes4.dex */
public class b {
    public String authen;
    public String avatar;
    public boolean bIU;
    public String eZA;
    public boolean eZB;
    public String eZC;
    public String eZD;
    public int eZE;
    public int eZz;
    public String extra;
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
        this.bIU = recommendForumInfo.is_like.intValue() == 1;
        this.memberCount = recommendForumInfo.member_count.intValue();
        this.threadCount = recommendForumInfo.thread_count.intValue();
        this.slogan = recommendForumInfo.slogan;
        this.eZz = recommendForumInfo.forum_type.intValue();
        this.authen = recommendForumInfo.authen;
        this.eZA = recommendForumInfo.recom_reason;
        this.eZB = recommendForumInfo.is_brand_forum.intValue() == 1;
        this.eZC = recommendForumInfo.hot_text;
        this.eZD = recommendForumInfo.abtest_tag;
        this.source = recommendForumInfo.source;
        this.extra = recommendForumInfo.extra;
        this.eZE = 1;
    }
}
