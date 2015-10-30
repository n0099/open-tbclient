package com.baidu.tieba.enterForum.b;

import com.baidu.adp.lib.util.BdLog;
import tbclient.RecommendForumInfo;
/* loaded from: classes.dex */
public class f implements com.baidu.tbadk.mvc.b.a {
    private int aLA;
    private String aLB;
    private String aLy;
    private int aLz;
    private long mForumId;
    private String mForumName;
    private int mThreadNum;
    private int mType;

    public String getAvatar() {
        return this.aLy;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public int HZ() {
        return this.aLA;
    }

    public int Ia() {
        return this.mThreadNum;
    }

    public String getSlogan() {
        return this.aLB;
    }

    public void b(RecommendForumInfo recommendForumInfo) {
        if (recommendForumInfo != null) {
            try {
                this.aLy = recommendForumInfo.avatar;
                this.mForumId = recommendForumInfo.forum_id.longValue();
                this.mForumName = recommendForumInfo.forum_name;
                this.aLz = recommendForumInfo.is_like.intValue();
                this.aLA = recommendForumInfo.member_count.intValue();
                this.mThreadNum = recommendForumInfo.thread_count.intValue();
                this.aLB = recommendForumInfo.slogan;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public int getType() {
        return this.mType;
    }
}
