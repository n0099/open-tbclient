package com.baidu.tieba.enterForum.b;

import com.baidu.adp.lib.util.BdLog;
import tbclient.RecommendForumInfo;
/* loaded from: classes.dex */
public class d implements com.baidu.tbadk.mvc.b.a {
    private String aCw;
    private int aCx;
    private int aCy;
    private String aCz;
    private long mForumId;
    private String mForumName;
    private int mIsLike;
    private int mType;

    public String getAvatar() {
        return this.aCw;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public int Gy() {
        return this.aCx;
    }

    public int Gz() {
        return this.aCy;
    }

    public String getSlogan() {
        return this.aCz;
    }

    public void b(RecommendForumInfo recommendForumInfo) {
        if (recommendForumInfo != null) {
            try {
                this.aCw = recommendForumInfo.avatar;
                this.mForumId = recommendForumInfo.forum_id.longValue();
                this.mForumName = recommendForumInfo.forum_name;
                this.mIsLike = recommendForumInfo.is_like.intValue();
                this.aCx = recommendForumInfo.member_count.intValue();
                this.aCy = recommendForumInfo.thread_count.intValue();
                this.aCz = recommendForumInfo.slogan;
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
