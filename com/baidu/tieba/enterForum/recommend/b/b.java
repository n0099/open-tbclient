package com.baidu.tieba.enterForum.recommend.b;

import tbclient.RecommendForumInfo;
/* loaded from: classes4.dex */
public class b {
    public String authen;
    public String avatar;
    public boolean bAB;
    public int eEo;
    public String eEp;
    public boolean eEq;
    public String eEr;
    public String eEs;
    public int eEt;
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
        this.bAB = recommendForumInfo.is_like.intValue() == 1;
        this.memberCount = recommendForumInfo.member_count.intValue();
        this.threadCount = recommendForumInfo.thread_count.intValue();
        this.slogan = recommendForumInfo.slogan;
        this.eEo = recommendForumInfo.forum_type.intValue();
        this.authen = recommendForumInfo.authen;
        this.eEp = recommendForumInfo.recom_reason;
        this.eEq = recommendForumInfo.is_brand_forum.intValue() == 1;
        this.eEr = recommendForumInfo.hot_text;
        this.eEs = recommendForumInfo.abtest_tag;
        this.source = recommendForumInfo.source;
        this.extra = recommendForumInfo.extra;
        this.eEt = 1;
    }
}
