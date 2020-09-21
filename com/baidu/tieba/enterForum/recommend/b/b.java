package com.baidu.tieba.enterForum.recommend.b;

import tbclient.RecommendForumInfo;
/* loaded from: classes21.dex */
public class b {
    public String authen;
    public String avatar;
    public boolean ecG;
    public String extra;
    public long forumId;
    public String forumName;
    public int hFF;
    public String hFG;
    public boolean hFH;
    public String hFI;
    public String hFJ;
    public int hFK;
    public int memberCount;
    public String slogan;
    public String source;
    public int threadCount;

    public void b(RecommendForumInfo recommendForumInfo) {
        this.avatar = recommendForumInfo.avatar;
        this.forumId = recommendForumInfo.forum_id.longValue();
        this.forumName = recommendForumInfo.forum_name;
        this.ecG = recommendForumInfo.is_like.intValue() == 1;
        this.memberCount = recommendForumInfo.member_count.intValue();
        this.threadCount = recommendForumInfo.thread_count.intValue();
        this.slogan = recommendForumInfo.slogan;
        this.hFF = recommendForumInfo.forum_type.intValue();
        this.authen = recommendForumInfo.authen;
        this.hFG = recommendForumInfo.recom_reason;
        this.hFH = recommendForumInfo.is_brand_forum.intValue() == 1;
        this.hFI = recommendForumInfo.hot_text;
        this.hFJ = recommendForumInfo.abtest_tag;
        this.source = recommendForumInfo.source;
        this.extra = recommendForumInfo.extra;
        this.hFK = 1;
    }
}
