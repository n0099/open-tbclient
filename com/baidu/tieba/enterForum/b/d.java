package com.baidu.tieba.enterForum.b;

import com.baidu.adp.lib.util.BdLog;
import tbclient.RecommendForumInfo;
/* loaded from: classes.dex */
public class d implements com.baidu.tbadk.mvc.b.a {
    private String aCE;
    private int aCF;
    private int aCG;
    private String aCH;
    private long mForumId;
    private String mForumName;
    private int mIsLike;
    private int mType;

    public String getAvatar() {
        return this.aCE;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public int GE() {
        return this.aCF;
    }

    public int GF() {
        return this.aCG;
    }

    public String getSlogan() {
        return this.aCH;
    }

    public void b(RecommendForumInfo recommendForumInfo) {
        if (recommendForumInfo != null) {
            try {
                this.aCE = recommendForumInfo.avatar;
                this.mForumId = recommendForumInfo.forum_id.longValue();
                this.mForumName = recommendForumInfo.forum_name;
                this.mIsLike = recommendForumInfo.is_like.intValue();
                this.aCF = recommendForumInfo.member_count.intValue();
                this.aCG = recommendForumInfo.thread_count.intValue();
                this.aCH = recommendForumInfo.slogan;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }
}
