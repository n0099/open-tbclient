package com.baidu.tieba.enterForum.b;

import com.baidu.adp.lib.util.BdLog;
import tbclient.RecommendForumInfo;
/* loaded from: classes.dex */
public class f implements com.baidu.tbadk.mvc.b.a {
    private String aPR;
    private int aPS;
    private String aPV;
    private int aTX;
    private long mForumId;
    private String mForumName;
    private int mThreadNum;
    private int mType;

    public String getAvatar() {
        return this.aPR;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public int JY() {
        return this.aTX;
    }

    public int JZ() {
        return this.mThreadNum;
    }

    public String getSlogan() {
        return this.aPV;
    }

    public void b(RecommendForumInfo recommendForumInfo) {
        if (recommendForumInfo != null) {
            try {
                this.aPR = recommendForumInfo.avatar;
                this.mForumId = recommendForumInfo.forum_id.longValue();
                this.mForumName = recommendForumInfo.forum_name;
                this.aPS = recommendForumInfo.is_like.intValue();
                this.aTX = recommendForumInfo.member_count.intValue();
                this.mThreadNum = recommendForumInfo.thread_count.intValue();
                this.aPV = recommendForumInfo.slogan;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public int getType() {
        return this.mType;
    }
}
