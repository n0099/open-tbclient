package com.baidu.tieba.enterForum.recommend.b;

import tbclient.RecommendForumInfo;
/* loaded from: classes16.dex */
public class b {
    public String authen;
    public String avatar;
    public boolean eaw;
    public String extra;
    public long forumId;
    public String forumName;
    public int hyD;
    public String hyE;
    public boolean hyF;
    public String hyG;
    public String hyH;
    public int hyI;
    public int memberCount;
    public String slogan;
    public String source;
    public int threadCount;

    public void b(RecommendForumInfo recommendForumInfo) {
        this.avatar = recommendForumInfo.avatar;
        this.forumId = recommendForumInfo.forum_id.longValue();
        this.forumName = recommendForumInfo.forum_name;
        this.eaw = recommendForumInfo.is_like.intValue() == 1;
        this.memberCount = recommendForumInfo.member_count.intValue();
        this.threadCount = recommendForumInfo.thread_count.intValue();
        this.slogan = recommendForumInfo.slogan;
        this.hyD = recommendForumInfo.forum_type.intValue();
        this.authen = recommendForumInfo.authen;
        this.hyE = recommendForumInfo.recom_reason;
        this.hyF = recommendForumInfo.is_brand_forum.intValue() == 1;
        this.hyG = recommendForumInfo.hot_text;
        this.hyH = recommendForumInfo.abtest_tag;
        this.source = recommendForumInfo.source;
        this.extra = recommendForumInfo.extra;
        this.hyI = 1;
    }
}
