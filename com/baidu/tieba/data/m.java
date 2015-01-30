package com.baidu.tieba.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.RecommendForumInfo;
/* loaded from: classes.dex */
public class m {
    private String atA;
    private String atx;
    private int aty;
    private int atz;
    private long mForumId;
    private String mForumName;
    private int mIsLike;

    public String getAvatar() {
        return this.atx;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public int CV() {
        return this.aty;
    }

    public int CW() {
        return this.atz;
    }

    public String getSlogan() {
        return this.atA;
    }

    public void b(RecommendForumInfo recommendForumInfo) {
        if (recommendForumInfo != null) {
            try {
                this.atx = recommendForumInfo.avatar;
                this.mForumId = recommendForumInfo.forum_id.longValue();
                this.mForumName = recommendForumInfo.forum_name;
                this.mIsLike = recommendForumInfo.is_like.intValue();
                this.aty = recommendForumInfo.member_count.intValue();
                this.atz = recommendForumInfo.thread_count.intValue();
                this.atA = recommendForumInfo.slogan;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
