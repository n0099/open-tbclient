package com.baidu.tieba.enterForum.recommend.b;

import tbclient.RecommendForumInfo;
/* loaded from: classes9.dex */
public class b {
    public String authen;
    public String avatar;
    public boolean dEi;
    public String extra;
    public long forumId;
    public String forumName;
    public int gTc;
    public String gTd;
    public boolean gTe;
    public String gTf;
    public String gTg;
    public int gTh;
    public int memberCount;
    public String slogan;
    public String source;
    public int threadCount;

    public void b(RecommendForumInfo recommendForumInfo) {
        this.avatar = recommendForumInfo.avatar;
        this.forumId = recommendForumInfo.forum_id.longValue();
        this.forumName = recommendForumInfo.forum_name;
        this.dEi = recommendForumInfo.is_like.intValue() == 1;
        this.memberCount = recommendForumInfo.member_count.intValue();
        this.threadCount = recommendForumInfo.thread_count.intValue();
        this.slogan = recommendForumInfo.slogan;
        this.gTc = recommendForumInfo.forum_type.intValue();
        this.authen = recommendForumInfo.authen;
        this.gTd = recommendForumInfo.recom_reason;
        this.gTe = recommendForumInfo.is_brand_forum.intValue() == 1;
        this.gTf = recommendForumInfo.hot_text;
        this.gTg = recommendForumInfo.abtest_tag;
        this.source = recommendForumInfo.source;
        this.extra = recommendForumInfo.extra;
        this.gTh = 1;
    }
}
