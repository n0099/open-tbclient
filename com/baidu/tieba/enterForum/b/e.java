package com.baidu.tieba.enterForum.b;

import com.baidu.adp.lib.util.BdLog;
import tbclient.RecommendForumInfo;
/* loaded from: classes.dex */
public class e implements com.baidu.tbadk.mvc.b.a {
    private String aEG;
    private int aEH;
    private int aEI;
    private String aEJ;
    private long mForumId;
    private String mForumName;
    private int mIsLike;
    private int mType;

    public String getAvatar() {
        return this.aEG;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public int HI() {
        return this.aEH;
    }

    public int HJ() {
        return this.aEI;
    }

    public String getSlogan() {
        return this.aEJ;
    }

    public void b(RecommendForumInfo recommendForumInfo) {
        if (recommendForumInfo != null) {
            try {
                this.aEG = recommendForumInfo.avatar;
                this.mForumId = recommendForumInfo.forum_id.longValue();
                this.mForumName = recommendForumInfo.forum_name;
                this.mIsLike = recommendForumInfo.is_like.intValue();
                this.aEH = recommendForumInfo.member_count.intValue();
                this.aEI = recommendForumInfo.thread_count.intValue();
                this.aEJ = recommendForumInfo.slogan;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public int getType() {
        return this.mType;
    }
}
