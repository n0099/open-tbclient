package com.baidu.tieba.enterForum.b;

import com.baidu.adp.lib.util.BdLog;
import tbclient.RecommendForumInfo;
/* loaded from: classes.dex */
public class g implements com.baidu.tbadk.mvc.b.a {
    private String axr;
    private int bEj;
    private int bEk;
    private String bEl;
    private long mForumId;
    private String mForumName;
    private int mThreadNum;
    private int mType;

    public String getAvatar() {
        return this.axr;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public int VI() {
        return this.bEk;
    }

    public int VJ() {
        return this.mThreadNum;
    }

    public String getSlogan() {
        return this.bEl;
    }

    public void a(RecommendForumInfo recommendForumInfo) {
        if (recommendForumInfo != null) {
            try {
                this.axr = recommendForumInfo.avatar;
                this.mForumId = recommendForumInfo.forum_id.longValue();
                this.mForumName = recommendForumInfo.forum_name;
                this.bEj = recommendForumInfo.is_like.intValue();
                this.bEk = recommendForumInfo.member_count.intValue();
                this.mThreadNum = recommendForumInfo.thread_count.intValue();
                this.bEl = recommendForumInfo.slogan;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public int getType() {
        return this.mType;
    }
}
