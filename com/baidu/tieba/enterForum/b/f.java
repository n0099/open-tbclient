package com.baidu.tieba.enterForum.b;

import com.baidu.adp.lib.util.BdLog;
import tbclient.RecommendForumInfo;
/* loaded from: classes.dex */
public class f implements com.baidu.tbadk.mvc.b.a {
    private String aLG;
    private int aLH;
    private int aLI;
    private String aLJ;
    private long mForumId;
    private String mForumName;
    private int mThreadNum;
    private int mType;

    public String getAvatar() {
        return this.aLG;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public int Ip() {
        return this.aLI;
    }

    public int Iq() {
        return this.mThreadNum;
    }

    public String getSlogan() {
        return this.aLJ;
    }

    public void b(RecommendForumInfo recommendForumInfo) {
        if (recommendForumInfo != null) {
            try {
                this.aLG = recommendForumInfo.avatar;
                this.mForumId = recommendForumInfo.forum_id.longValue();
                this.mForumName = recommendForumInfo.forum_name;
                this.aLH = recommendForumInfo.is_like.intValue();
                this.aLI = recommendForumInfo.member_count.intValue();
                this.mThreadNum = recommendForumInfo.thread_count.intValue();
                this.aLJ = recommendForumInfo.slogan;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public int getType() {
        return this.mType;
    }
}
