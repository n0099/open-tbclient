package com.baidu.tieba.enterForum.recommend.b;

import tbclient.RecommendForumInfo;
/* loaded from: classes2.dex */
public class b {
    public String authen;
    public String avatar;
    public boolean eSj;
    public String extra;
    public long forumId;
    public String forumName;
    public int iKU;
    public String iKV;
    public boolean iKW;
    public String iKX;
    public String iKY;
    public int iKZ;
    public int memberCount;
    public String slogan;
    public String source;
    public int threadCount;

    public void b(RecommendForumInfo recommendForumInfo) {
        this.avatar = recommendForumInfo.avatar;
        this.forumId = recommendForumInfo.forum_id.longValue();
        this.forumName = recommendForumInfo.forum_name;
        this.eSj = recommendForumInfo.is_like.intValue() == 1;
        this.memberCount = recommendForumInfo.member_count.intValue();
        this.threadCount = recommendForumInfo.thread_count.intValue();
        this.slogan = recommendForumInfo.slogan;
        this.iKU = recommendForumInfo.forum_type.intValue();
        this.authen = recommendForumInfo.authen;
        this.iKV = recommendForumInfo.recom_reason;
        this.iKW = recommendForumInfo.is_brand_forum.intValue() == 1;
        this.iKX = recommendForumInfo.hot_text;
        this.iKY = recommendForumInfo.abtest_tag;
        this.source = recommendForumInfo.source;
        this.extra = recommendForumInfo.extra;
        this.iKZ = 1;
    }
}
