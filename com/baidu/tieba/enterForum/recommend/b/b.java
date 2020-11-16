package com.baidu.tieba.enterForum.recommend.b;

import tbclient.RecommendForumInfo;
/* loaded from: classes21.dex */
public class b {
    public String authen;
    public String avatar;
    public boolean eBr;
    public String extra;
    public long forumId;
    public String forumName;
    public int inN;
    public String inO;
    public boolean inP;
    public String inQ;
    public String inR;
    public int inS;
    public int memberCount;
    public String slogan;
    public String source;
    public int threadCount;

    public void b(RecommendForumInfo recommendForumInfo) {
        this.avatar = recommendForumInfo.avatar;
        this.forumId = recommendForumInfo.forum_id.longValue();
        this.forumName = recommendForumInfo.forum_name;
        this.eBr = recommendForumInfo.is_like.intValue() == 1;
        this.memberCount = recommendForumInfo.member_count.intValue();
        this.threadCount = recommendForumInfo.thread_count.intValue();
        this.slogan = recommendForumInfo.slogan;
        this.inN = recommendForumInfo.forum_type.intValue();
        this.authen = recommendForumInfo.authen;
        this.inO = recommendForumInfo.recom_reason;
        this.inP = recommendForumInfo.is_brand_forum.intValue() == 1;
        this.inQ = recommendForumInfo.hot_text;
        this.inR = recommendForumInfo.abtest_tag;
        this.source = recommendForumInfo.source;
        this.extra = recommendForumInfo.extra;
        this.inS = 1;
    }
}
