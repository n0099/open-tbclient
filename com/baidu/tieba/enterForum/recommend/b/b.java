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
    public int iyH;
    public String iyI;
    public boolean iyJ;
    public String iyK;
    public String iyL;
    public int iyM;
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
        this.iyH = recommendForumInfo.forum_type.intValue();
        this.authen = recommendForumInfo.authen;
        this.iyI = recommendForumInfo.recom_reason;
        this.iyJ = recommendForumInfo.is_brand_forum.intValue() == 1;
        this.iyK = recommendForumInfo.hot_text;
        this.iyL = recommendForumInfo.abtest_tag;
        this.source = recommendForumInfo.source;
        this.extra = recommendForumInfo.extra;
        this.iyM = 1;
    }
}
