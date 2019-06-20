package com.baidu.tieba.enterForum.recommend.b;

import tbclient.RecommendForumInfo;
/* loaded from: classes4.dex */
public class b {
    public String authen;
    public String avatar;
    public boolean bHP;
    public int eUk;
    public String eUl;
    public boolean eUm;
    public String eUn;
    public String eUo;
    public int eUp;
    public String extra;
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
        this.bHP = recommendForumInfo.is_like.intValue() == 1;
        this.memberCount = recommendForumInfo.member_count.intValue();
        this.threadCount = recommendForumInfo.thread_count.intValue();
        this.slogan = recommendForumInfo.slogan;
        this.eUk = recommendForumInfo.forum_type.intValue();
        this.authen = recommendForumInfo.authen;
        this.eUl = recommendForumInfo.recom_reason;
        this.eUm = recommendForumInfo.is_brand_forum.intValue() == 1;
        this.eUn = recommendForumInfo.hot_text;
        this.eUo = recommendForumInfo.abtest_tag;
        this.source = recommendForumInfo.source;
        this.extra = recommendForumInfo.extra;
        this.eUp = 1;
    }
}
