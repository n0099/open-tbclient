package com.baidu.tieba.enterForum.recommend.b;

import tbclient.RecommendForumInfo;
/* loaded from: classes4.dex */
public class b {
    public String authen;
    public String avatar;
    public boolean cai;
    public String extra;
    public int fcZ;
    public String fda;
    public boolean fdb;
    public String fdc;
    public String fdd;
    public int fde;
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
        this.cai = recommendForumInfo.is_like.intValue() == 1;
        this.memberCount = recommendForumInfo.member_count.intValue();
        this.threadCount = recommendForumInfo.thread_count.intValue();
        this.slogan = recommendForumInfo.slogan;
        this.fcZ = recommendForumInfo.forum_type.intValue();
        this.authen = recommendForumInfo.authen;
        this.fda = recommendForumInfo.recom_reason;
        this.fdb = recommendForumInfo.is_brand_forum.intValue() == 1;
        this.fdc = recommendForumInfo.hot_text;
        this.fdd = recommendForumInfo.abtest_tag;
        this.source = recommendForumInfo.source;
        this.extra = recommendForumInfo.extra;
        this.fde = 1;
    }
}
