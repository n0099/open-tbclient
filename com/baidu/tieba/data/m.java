package com.baidu.tieba.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.RecommendForumInfo;
/* loaded from: classes.dex */
public class m {
    private String atu;
    private int atv;
    private int atw;
    private String atx;
    private long mForumId;
    private String mForumName;
    private int mIsLike;

    public String getAvatar() {
        return this.atu;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public int CP() {
        return this.atv;
    }

    public int CQ() {
        return this.atw;
    }

    public String getSlogan() {
        return this.atx;
    }

    public void b(RecommendForumInfo recommendForumInfo) {
        if (recommendForumInfo != null) {
            try {
                this.atu = recommendForumInfo.avatar;
                this.mForumId = recommendForumInfo.forum_id.longValue();
                this.mForumName = recommendForumInfo.forum_name;
                this.mIsLike = recommendForumInfo.is_like.intValue();
                this.atv = recommendForumInfo.member_count.intValue();
                this.atw = recommendForumInfo.thread_count.intValue();
                this.atx = recommendForumInfo.slogan;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
