package com.baidu.tieba.enterForum.recommend.b;

import tbclient.RecommendForumInfo;
/* loaded from: classes22.dex */
public class b {
    public String authen;
    public String avatar;
    public boolean eDa;
    public String extra;
    public long forumId;
    public String forumName;
    public int imY;
    public String imZ;
    public boolean ina;
    public String inb;
    public String inc;
    public int ind;
    public int memberCount;
    public String slogan;
    public String source;
    public int threadCount;

    public void b(RecommendForumInfo recommendForumInfo) {
        this.avatar = recommendForumInfo.avatar;
        this.forumId = recommendForumInfo.forum_id.longValue();
        this.forumName = recommendForumInfo.forum_name;
        this.eDa = recommendForumInfo.is_like.intValue() == 1;
        this.memberCount = recommendForumInfo.member_count.intValue();
        this.threadCount = recommendForumInfo.thread_count.intValue();
        this.slogan = recommendForumInfo.slogan;
        this.imY = recommendForumInfo.forum_type.intValue();
        this.authen = recommendForumInfo.authen;
        this.imZ = recommendForumInfo.recom_reason;
        this.ina = recommendForumInfo.is_brand_forum.intValue() == 1;
        this.inb = recommendForumInfo.hot_text;
        this.inc = recommendForumInfo.abtest_tag;
        this.source = recommendForumInfo.source;
        this.extra = recommendForumInfo.extra;
        this.ind = 1;
    }
}
