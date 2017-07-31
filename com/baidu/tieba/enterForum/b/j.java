package com.baidu.tieba.enterForum.b;

import com.baidu.adp.lib.util.BdLog;
import tbclient.RecommendForumInfo;
/* loaded from: classes.dex */
public class j extends e implements com.baidu.tbadk.mvc.b.a {
    private String bYe;
    private int bYh;
    private int bYi;
    private String bYj;
    private long mForumId;
    private String mForumName;
    private int mThreadNum;

    public long getForumId() {
        return this.mForumId;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public void a(RecommendForumInfo recommendForumInfo) {
        if (recommendForumInfo != null) {
            try {
                this.bYe = recommendForumInfo.avatar;
                this.mForumId = recommendForumInfo.forum_id.longValue();
                this.mForumName = recommendForumInfo.forum_name;
                this.bYh = recommendForumInfo.is_like.intValue();
                this.bYi = recommendForumInfo.member_count.intValue();
                this.mThreadNum = recommendForumInfo.thread_count.intValue();
                this.bYj = recommendForumInfo.slogan;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
