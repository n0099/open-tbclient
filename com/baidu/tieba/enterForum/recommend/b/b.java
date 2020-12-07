package com.baidu.tieba.enterForum.recommend.b;

import tbclient.RecommendForumInfo;
/* loaded from: classes22.dex */
public class b {
    public String authen;
    public String avatar;
    public boolean eIr;
    public String extra;
    public long forumId;
    public String forumName;
    public int iyF;
    public String iyG;
    public boolean iyH;
    public String iyI;
    public String iyJ;
    public int iyK;
    public int memberCount;
    public String slogan;
    public String source;
    public int threadCount;

    public void b(RecommendForumInfo recommendForumInfo) {
        this.avatar = recommendForumInfo.avatar;
        this.forumId = recommendForumInfo.forum_id.longValue();
        this.forumName = recommendForumInfo.forum_name;
        this.eIr = recommendForumInfo.is_like.intValue() == 1;
        this.memberCount = recommendForumInfo.member_count.intValue();
        this.threadCount = recommendForumInfo.thread_count.intValue();
        this.slogan = recommendForumInfo.slogan;
        this.iyF = recommendForumInfo.forum_type.intValue();
        this.authen = recommendForumInfo.authen;
        this.iyG = recommendForumInfo.recom_reason;
        this.iyH = recommendForumInfo.is_brand_forum.intValue() == 1;
        this.iyI = recommendForumInfo.hot_text;
        this.iyJ = recommendForumInfo.abtest_tag;
        this.source = recommendForumInfo.source;
        this.extra = recommendForumInfo.extra;
        this.iyK = 1;
    }
}
