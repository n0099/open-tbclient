package com.baidu.tieba.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.RecommendForumInfo;
/* loaded from: classes.dex */
public class m {
    private String asr;
    private int ass;
    private int ast;
    private String asu;
    private long mForumId;
    private String mForumName;
    private int mIsLike;

    public String getAvatar() {
        return this.asr;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public int Cw() {
        return this.ass;
    }

    public int Cx() {
        return this.ast;
    }

    public String getSlogan() {
        return this.asu;
    }

    public void b(RecommendForumInfo recommendForumInfo) {
        if (recommendForumInfo != null) {
            try {
                this.asr = recommendForumInfo.avatar;
                this.mForumId = recommendForumInfo.forum_id.longValue();
                this.mForumName = recommendForumInfo.forum_name;
                this.mIsLike = recommendForumInfo.is_like.intValue();
                this.ass = recommendForumInfo.member_count.intValue();
                this.ast = recommendForumInfo.thread_count.intValue();
                this.asu = recommendForumInfo.slogan;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
