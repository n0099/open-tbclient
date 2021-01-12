package com.baidu.tieba.enterForum.recommend.b;

import tbclient.RecommendForumInfo;
/* loaded from: classes2.dex */
public class b {
    public String authen;
    public String avatar;
    public boolean eNy;
    public String extra;
    public long forumId;
    public String forumName;
    public int iGn;
    public String iGo;
    public boolean iGp;
    public String iGq;
    public String iGr;
    public int iGs;
    public int memberCount;
    public String slogan;
    public String source;
    public int threadCount;

    public void b(RecommendForumInfo recommendForumInfo) {
        this.avatar = recommendForumInfo.avatar;
        this.forumId = recommendForumInfo.forum_id.longValue();
        this.forumName = recommendForumInfo.forum_name;
        this.eNy = recommendForumInfo.is_like.intValue() == 1;
        this.memberCount = recommendForumInfo.member_count.intValue();
        this.threadCount = recommendForumInfo.thread_count.intValue();
        this.slogan = recommendForumInfo.slogan;
        this.iGn = recommendForumInfo.forum_type.intValue();
        this.authen = recommendForumInfo.authen;
        this.iGo = recommendForumInfo.recom_reason;
        this.iGp = recommendForumInfo.is_brand_forum.intValue() == 1;
        this.iGq = recommendForumInfo.hot_text;
        this.iGr = recommendForumInfo.abtest_tag;
        this.source = recommendForumInfo.source;
        this.extra = recommendForumInfo.extra;
        this.iGs = 1;
    }
}
