package com.baidu.tieba.enterForum.recommend.b;

import tbclient.RecommendForumInfo;
/* loaded from: classes7.dex */
public class b {
    public String authen;
    public String avatar;
    public boolean cMJ;
    public String extra;
    public int fUM;
    public String fUN;
    public boolean fUO;
    public String fUP;
    public String fUQ;
    public int fUR;
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
        this.cMJ = recommendForumInfo.is_like.intValue() == 1;
        this.memberCount = recommendForumInfo.member_count.intValue();
        this.threadCount = recommendForumInfo.thread_count.intValue();
        this.slogan = recommendForumInfo.slogan;
        this.fUM = recommendForumInfo.forum_type.intValue();
        this.authen = recommendForumInfo.authen;
        this.fUN = recommendForumInfo.recom_reason;
        this.fUO = recommendForumInfo.is_brand_forum.intValue() == 1;
        this.fUP = recommendForumInfo.hot_text;
        this.fUQ = recommendForumInfo.abtest_tag;
        this.source = recommendForumInfo.source;
        this.extra = recommendForumInfo.extra;
        this.fUR = 1;
    }
}
