package com.baidu.tieba.enterForum.recommend.b;

import tbclient.RecommendForumInfo;
/* loaded from: classes2.dex */
public class b {
    public String authen;
    public String avatar;
    public boolean ePK;
    public String extra;
    public long forumId;
    public String forumName;
    public int iLW;
    public String iLX;
    public boolean iLY;
    public String iLZ;
    public String iMa;
    public int iMb;
    public int memberCount;
    public String slogan;
    public String source;
    public int threadCount;

    public void b(RecommendForumInfo recommendForumInfo) {
        this.avatar = recommendForumInfo.avatar;
        this.forumId = recommendForumInfo.forum_id.longValue();
        this.forumName = recommendForumInfo.forum_name;
        this.ePK = recommendForumInfo.is_like.intValue() == 1;
        this.memberCount = recommendForumInfo.member_count.intValue();
        this.threadCount = recommendForumInfo.thread_count.intValue();
        this.slogan = recommendForumInfo.slogan;
        this.iLW = recommendForumInfo.forum_type.intValue();
        this.authen = recommendForumInfo.authen;
        this.iLX = recommendForumInfo.recom_reason;
        this.iLY = recommendForumInfo.is_brand_forum.intValue() == 1;
        this.iLZ = recommendForumInfo.hot_text;
        this.iMa = recommendForumInfo.abtest_tag;
        this.source = recommendForumInfo.source;
        this.extra = recommendForumInfo.extra;
        this.iMb = 1;
    }
}
