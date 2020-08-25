package com.baidu.tieba.enterForum.recommend.b;

import tbclient.RecommendForumInfo;
/* loaded from: classes16.dex */
public class b {
    public String authen;
    public String avatar;
    public boolean eas;
    public String extra;
    public long forumId;
    public String forumName;
    public String hyA;
    public String hyB;
    public int hyC;
    public int hyx;
    public String hyy;
    public boolean hyz;
    public int memberCount;
    public String slogan;
    public String source;
    public int threadCount;

    public void b(RecommendForumInfo recommendForumInfo) {
        this.avatar = recommendForumInfo.avatar;
        this.forumId = recommendForumInfo.forum_id.longValue();
        this.forumName = recommendForumInfo.forum_name;
        this.eas = recommendForumInfo.is_like.intValue() == 1;
        this.memberCount = recommendForumInfo.member_count.intValue();
        this.threadCount = recommendForumInfo.thread_count.intValue();
        this.slogan = recommendForumInfo.slogan;
        this.hyx = recommendForumInfo.forum_type.intValue();
        this.authen = recommendForumInfo.authen;
        this.hyy = recommendForumInfo.recom_reason;
        this.hyz = recommendForumInfo.is_brand_forum.intValue() == 1;
        this.hyA = recommendForumInfo.hot_text;
        this.hyB = recommendForumInfo.abtest_tag;
        this.source = recommendForumInfo.source;
        this.extra = recommendForumInfo.extra;
        this.hyC = 1;
    }
}
