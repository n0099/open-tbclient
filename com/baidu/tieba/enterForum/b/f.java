package com.baidu.tieba.enterForum.b;

import com.baidu.adp.lib.util.BdLog;
import tbclient.RecommendForumInfo;
/* loaded from: classes.dex */
public class f implements com.baidu.tbadk.mvc.b.a {
    private String aWQ;
    private int aWR;
    private int aWS;
    private String aWT;
    private long mForumId;
    private String mForumName;
    private int mThreadNum;
    private int mType;

    public String getAvatar() {
        return this.aWQ;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public int Mm() {
        return this.aWS;
    }

    public int getThreadNum() {
        return this.mThreadNum;
    }

    public String getSlogan() {
        return this.aWT;
    }

    public void b(RecommendForumInfo recommendForumInfo) {
        if (recommendForumInfo != null) {
            try {
                this.aWQ = recommendForumInfo.avatar;
                this.mForumId = recommendForumInfo.forum_id.longValue();
                this.mForumName = recommendForumInfo.forum_name;
                this.aWR = recommendForumInfo.is_like.intValue();
                this.aWS = recommendForumInfo.member_count.intValue();
                this.mThreadNum = recommendForumInfo.thread_count.intValue();
                this.aWT = recommendForumInfo.slogan;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public int getType() {
        return this.mType;
    }
}
