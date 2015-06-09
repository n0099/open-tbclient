package com.baidu.tieba.enterForum.b;

import com.baidu.adp.lib.util.BdLog;
import tbclient.RecommendForumInfo;
/* loaded from: classes.dex */
public class e implements com.baidu.tbadk.mvc.b.a {
    private String aEH;
    private int aEI;
    private int aEJ;
    private String aEK;
    private long mForumId;
    private String mForumName;
    private int mIsLike;
    private int mType;

    public String getAvatar() {
        return this.aEH;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public int HJ() {
        return this.aEI;
    }

    public int HK() {
        return this.aEJ;
    }

    public String getSlogan() {
        return this.aEK;
    }

    public void b(RecommendForumInfo recommendForumInfo) {
        if (recommendForumInfo != null) {
            try {
                this.aEH = recommendForumInfo.avatar;
                this.mForumId = recommendForumInfo.forum_id.longValue();
                this.mForumName = recommendForumInfo.forum_name;
                this.mIsLike = recommendForumInfo.is_like.intValue();
                this.aEI = recommendForumInfo.member_count.intValue();
                this.aEJ = recommendForumInfo.thread_count.intValue();
                this.aEK = recommendForumInfo.slogan;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public int getType() {
        return this.mType;
    }
}
