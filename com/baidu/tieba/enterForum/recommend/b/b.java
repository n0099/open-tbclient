package com.baidu.tieba.enterForum.recommend.b;

import tbclient.RecommendForumInfo;
/* loaded from: classes4.dex */
public class b {
    public String authen;
    public String avatar;
    public boolean bAy;
    public int eED;
    public String eEE;
    public boolean eEF;
    public String eEG;
    public String eEH;
    public int eEI;
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
        this.bAy = recommendForumInfo.is_like.intValue() == 1;
        this.memberCount = recommendForumInfo.member_count.intValue();
        this.threadCount = recommendForumInfo.thread_count.intValue();
        this.slogan = recommendForumInfo.slogan;
        this.eED = recommendForumInfo.forum_type.intValue();
        this.authen = recommendForumInfo.authen;
        this.eEE = recommendForumInfo.recom_reason;
        this.eEF = recommendForumInfo.is_brand_forum.intValue() == 1;
        this.eEG = recommendForumInfo.hot_text;
        this.eEH = recommendForumInfo.abtest_tag;
        this.source = recommendForumInfo.source;
        this.extra = recommendForumInfo.extra;
        this.eEI = 1;
    }
}
