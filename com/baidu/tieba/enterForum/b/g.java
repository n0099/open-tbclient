package com.baidu.tieba.enterForum.b;

import com.baidu.adp.lib.util.BdLog;
import tbclient.RecommendForumInfo;
/* loaded from: classes.dex */
public class g implements com.baidu.tbadk.mvc.b.a {
    private String aox;
    private int bsO;
    private int bsP;
    private String bsQ;
    private long mForumId;
    private String mForumName;
    private int mThreadNum;
    private int mType;

    public String getAvatar() {
        return this.aox;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public int RS() {
        return this.bsP;
    }

    public int getThreadNum() {
        return this.mThreadNum;
    }

    public String getSlogan() {
        return this.bsQ;
    }

    public void b(RecommendForumInfo recommendForumInfo) {
        if (recommendForumInfo != null) {
            try {
                this.aox = recommendForumInfo.avatar;
                this.mForumId = recommendForumInfo.forum_id.longValue();
                this.mForumName = recommendForumInfo.forum_name;
                this.bsO = recommendForumInfo.is_like.intValue();
                this.bsP = recommendForumInfo.member_count.intValue();
                this.mThreadNum = recommendForumInfo.thread_count.intValue();
                this.bsQ = recommendForumInfo.slogan;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public int getType() {
        return this.mType;
    }
}
