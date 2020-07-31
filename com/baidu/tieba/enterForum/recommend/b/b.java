package com.baidu.tieba.enterForum.recommend.b;

import tbclient.RecommendForumInfo;
/* loaded from: classes16.dex */
public class b {
    public String authen;
    public String avatar;
    public boolean dQY;
    public String extra;
    public long forumId;
    public String forumName;
    public int hlG;
    public String hlH;
    public boolean hlI;
    public String hlJ;
    public String hlK;
    public int hlL;
    public int memberCount;
    public String slogan;
    public String source;
    public int threadCount;

    public void b(RecommendForumInfo recommendForumInfo) {
        this.avatar = recommendForumInfo.avatar;
        this.forumId = recommendForumInfo.forum_id.longValue();
        this.forumName = recommendForumInfo.forum_name;
        this.dQY = recommendForumInfo.is_like.intValue() == 1;
        this.memberCount = recommendForumInfo.member_count.intValue();
        this.threadCount = recommendForumInfo.thread_count.intValue();
        this.slogan = recommendForumInfo.slogan;
        this.hlG = recommendForumInfo.forum_type.intValue();
        this.authen = recommendForumInfo.authen;
        this.hlH = recommendForumInfo.recom_reason;
        this.hlI = recommendForumInfo.is_brand_forum.intValue() == 1;
        this.hlJ = recommendForumInfo.hot_text;
        this.hlK = recommendForumInfo.abtest_tag;
        this.source = recommendForumInfo.source;
        this.extra = recommendForumInfo.extra;
        this.hlL = 1;
    }
}
