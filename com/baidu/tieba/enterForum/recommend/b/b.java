package com.baidu.tieba.enterForum.recommend.b;

import tbclient.RecommendForumInfo;
/* loaded from: classes22.dex */
public class b {
    public String authen;
    public String avatar;
    public boolean exi;
    public String extra;
    public long forumId;
    public String forumName;
    public int iha;
    public String ihb;
    public boolean ihc;
    public String ihd;
    public String ihe;
    public int ihf;
    public int memberCount;
    public String slogan;
    public String source;
    public int threadCount;

    public void b(RecommendForumInfo recommendForumInfo) {
        this.avatar = recommendForumInfo.avatar;
        this.forumId = recommendForumInfo.forum_id.longValue();
        this.forumName = recommendForumInfo.forum_name;
        this.exi = recommendForumInfo.is_like.intValue() == 1;
        this.memberCount = recommendForumInfo.member_count.intValue();
        this.threadCount = recommendForumInfo.thread_count.intValue();
        this.slogan = recommendForumInfo.slogan;
        this.iha = recommendForumInfo.forum_type.intValue();
        this.authen = recommendForumInfo.authen;
        this.ihb = recommendForumInfo.recom_reason;
        this.ihc = recommendForumInfo.is_brand_forum.intValue() == 1;
        this.ihd = recommendForumInfo.hot_text;
        this.ihe = recommendForumInfo.abtest_tag;
        this.source = recommendForumInfo.source;
        this.extra = recommendForumInfo.extra;
        this.ihf = 1;
    }
}
