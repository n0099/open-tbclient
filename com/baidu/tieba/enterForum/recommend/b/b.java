package com.baidu.tieba.enterForum.recommend.b;

import tbclient.RecommendForumInfo;
/* loaded from: classes4.dex */
public class b {
    public String authen;
    public String avatar;
    public boolean caZ;
    public String extra;
    public int fdQ;
    public String fdR;
    public boolean fdS;
    public String fdT;
    public String fdU;
    public int fdV;
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
        this.caZ = recommendForumInfo.is_like.intValue() == 1;
        this.memberCount = recommendForumInfo.member_count.intValue();
        this.threadCount = recommendForumInfo.thread_count.intValue();
        this.slogan = recommendForumInfo.slogan;
        this.fdQ = recommendForumInfo.forum_type.intValue();
        this.authen = recommendForumInfo.authen;
        this.fdR = recommendForumInfo.recom_reason;
        this.fdS = recommendForumInfo.is_brand_forum.intValue() == 1;
        this.fdT = recommendForumInfo.hot_text;
        this.fdU = recommendForumInfo.abtest_tag;
        this.source = recommendForumInfo.source;
        this.extra = recommendForumInfo.extra;
        this.fdV = 1;
    }
}
