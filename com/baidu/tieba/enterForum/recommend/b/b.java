package com.baidu.tieba.enterForum.recommend.b;

import tbclient.RecommendForumInfo;
/* loaded from: classes4.dex */
public class b {
    public String authen;
    public String avatar;
    public boolean bJs;
    public String extra;
    public int fbf;
    public String fbg;
    public boolean fbh;
    public String fbi;
    public String fbj;
    public int fbk;
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
        this.bJs = recommendForumInfo.is_like.intValue() == 1;
        this.memberCount = recommendForumInfo.member_count.intValue();
        this.threadCount = recommendForumInfo.thread_count.intValue();
        this.slogan = recommendForumInfo.slogan;
        this.fbf = recommendForumInfo.forum_type.intValue();
        this.authen = recommendForumInfo.authen;
        this.fbg = recommendForumInfo.recom_reason;
        this.fbh = recommendForumInfo.is_brand_forum.intValue() == 1;
        this.fbi = recommendForumInfo.hot_text;
        this.fbj = recommendForumInfo.abtest_tag;
        this.source = recommendForumInfo.source;
        this.extra = recommendForumInfo.extra;
        this.fbk = 1;
    }
}
