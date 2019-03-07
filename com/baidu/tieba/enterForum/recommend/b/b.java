package com.baidu.tieba.enterForum.recommend.b;

import tbclient.RecommendForumInfo;
/* loaded from: classes4.dex */
public class b {
    public String authen;
    public String avatar;
    public boolean bAw;
    public int eEH;
    public String eEI;
    public boolean eEJ;
    public String eEK;
    public String eEL;
    public int eEM;
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
        this.bAw = recommendForumInfo.is_like.intValue() == 1;
        this.memberCount = recommendForumInfo.member_count.intValue();
        this.threadCount = recommendForumInfo.thread_count.intValue();
        this.slogan = recommendForumInfo.slogan;
        this.eEH = recommendForumInfo.forum_type.intValue();
        this.authen = recommendForumInfo.authen;
        this.eEI = recommendForumInfo.recom_reason;
        this.eEJ = recommendForumInfo.is_brand_forum.intValue() == 1;
        this.eEK = recommendForumInfo.hot_text;
        this.eEL = recommendForumInfo.abtest_tag;
        this.source = recommendForumInfo.source;
        this.extra = recommendForumInfo.extra;
        this.eEM = 1;
    }
}
