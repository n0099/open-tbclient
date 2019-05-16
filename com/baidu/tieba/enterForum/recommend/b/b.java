package com.baidu.tieba.enterForum.recommend.b;

import tbclient.RecommendForumInfo;
/* loaded from: classes4.dex */
public class b {
    public String authen;
    public String avatar;
    public boolean bHO;
    public int eUj;
    public String eUk;
    public boolean eUl;
    public String eUm;
    public String eUn;
    public int eUo;
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
        this.bHO = recommendForumInfo.is_like.intValue() == 1;
        this.memberCount = recommendForumInfo.member_count.intValue();
        this.threadCount = recommendForumInfo.thread_count.intValue();
        this.slogan = recommendForumInfo.slogan;
        this.eUj = recommendForumInfo.forum_type.intValue();
        this.authen = recommendForumInfo.authen;
        this.eUk = recommendForumInfo.recom_reason;
        this.eUl = recommendForumInfo.is_brand_forum.intValue() == 1;
        this.eUm = recommendForumInfo.hot_text;
        this.eUn = recommendForumInfo.abtest_tag;
        this.source = recommendForumInfo.source;
        this.extra = recommendForumInfo.extra;
        this.eUo = 1;
    }
}
