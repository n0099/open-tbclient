package com.baidu.tieba.enterForum.recommend.b;

import tbclient.RecommendForumInfo;
/* loaded from: classes4.dex */
public class b {
    public String authen;
    public String avatar;
    public boolean bAC;
    public int eEp;
    public String eEq;
    public boolean eEr;
    public String eEs;
    public String eEt;
    public int eEu;
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
        this.bAC = recommendForumInfo.is_like.intValue() == 1;
        this.memberCount = recommendForumInfo.member_count.intValue();
        this.threadCount = recommendForumInfo.thread_count.intValue();
        this.slogan = recommendForumInfo.slogan;
        this.eEp = recommendForumInfo.forum_type.intValue();
        this.authen = recommendForumInfo.authen;
        this.eEq = recommendForumInfo.recom_reason;
        this.eEr = recommendForumInfo.is_brand_forum.intValue() == 1;
        this.eEs = recommendForumInfo.hot_text;
        this.eEt = recommendForumInfo.abtest_tag;
        this.source = recommendForumInfo.source;
        this.extra = recommendForumInfo.extra;
        this.eEu = 1;
    }
}
