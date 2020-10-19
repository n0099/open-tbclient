package com.baidu.tieba.enterForum.recommend.b;

import tbclient.RecommendForumInfo;
/* loaded from: classes22.dex */
public class b {
    public String authen;
    public String avatar;
    public boolean eoL;
    public String extra;
    public long forumId;
    public String forumName;
    public int hUA;
    public String hUB;
    public boolean hUC;
    public String hUD;
    public String hUE;
    public int hUF;
    public int memberCount;
    public String slogan;
    public String source;
    public int threadCount;

    public void b(RecommendForumInfo recommendForumInfo) {
        this.avatar = recommendForumInfo.avatar;
        this.forumId = recommendForumInfo.forum_id.longValue();
        this.forumName = recommendForumInfo.forum_name;
        this.eoL = recommendForumInfo.is_like.intValue() == 1;
        this.memberCount = recommendForumInfo.member_count.intValue();
        this.threadCount = recommendForumInfo.thread_count.intValue();
        this.slogan = recommendForumInfo.slogan;
        this.hUA = recommendForumInfo.forum_type.intValue();
        this.authen = recommendForumInfo.authen;
        this.hUB = recommendForumInfo.recom_reason;
        this.hUC = recommendForumInfo.is_brand_forum.intValue() == 1;
        this.hUD = recommendForumInfo.hot_text;
        this.hUE = recommendForumInfo.abtest_tag;
        this.source = recommendForumInfo.source;
        this.extra = recommendForumInfo.extra;
        this.hUF = 1;
    }
}
