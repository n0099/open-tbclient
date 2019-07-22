package com.baidu.tieba.enterForum.recommend.b;

import tbclient.RecommendForumInfo;
/* loaded from: classes4.dex */
public class b {
    public String authen;
    public String avatar;
    public boolean bIP;
    public int eZl;
    public String eZm;
    public boolean eZn;
    public String eZo;
    public String eZp;
    public int eZq;
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
        this.bIP = recommendForumInfo.is_like.intValue() == 1;
        this.memberCount = recommendForumInfo.member_count.intValue();
        this.threadCount = recommendForumInfo.thread_count.intValue();
        this.slogan = recommendForumInfo.slogan;
        this.eZl = recommendForumInfo.forum_type.intValue();
        this.authen = recommendForumInfo.authen;
        this.eZm = recommendForumInfo.recom_reason;
        this.eZn = recommendForumInfo.is_brand_forum.intValue() == 1;
        this.eZo = recommendForumInfo.hot_text;
        this.eZp = recommendForumInfo.abtest_tag;
        this.source = recommendForumInfo.source;
        this.extra = recommendForumInfo.extra;
        this.eZq = 1;
    }
}
