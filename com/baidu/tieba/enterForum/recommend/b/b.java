package com.baidu.tieba.enterForum.recommend.b;

import tbclient.RecommendForumInfo;
/* loaded from: classes9.dex */
public class b {
    public String authen;
    public String avatar;
    public boolean cQN;
    public String extra;
    public int fWP;
    public String fWQ;
    public boolean fWR;
    public String fWS;
    public String fWT;
    public int fWU;
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
        this.cQN = recommendForumInfo.is_like.intValue() == 1;
        this.memberCount = recommendForumInfo.member_count.intValue();
        this.threadCount = recommendForumInfo.thread_count.intValue();
        this.slogan = recommendForumInfo.slogan;
        this.fWP = recommendForumInfo.forum_type.intValue();
        this.authen = recommendForumInfo.authen;
        this.fWQ = recommendForumInfo.recom_reason;
        this.fWR = recommendForumInfo.is_brand_forum.intValue() == 1;
        this.fWS = recommendForumInfo.hot_text;
        this.fWT = recommendForumInfo.abtest_tag;
        this.source = recommendForumInfo.source;
        this.extra = recommendForumInfo.extra;
        this.fWU = 1;
    }
}
