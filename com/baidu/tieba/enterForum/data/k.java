package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.RecommendForumInfo;
/* loaded from: classes9.dex */
public class k extends f implements com.baidu.tbadk.mvc.b.a {
    private boolean gOU;
    private String mAvatar;
    private long mForumId;
    private String mForumName;
    private int member_count;
    private String recom_reason;
    private int thread_count;

    public k() {
        setType(8);
    }

    public String getAvatar() {
        return this.mAvatar;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public boolean isLike() {
        return this.gOU;
    }

    public void setLike(boolean z) {
        this.gOU = z;
    }

    public int bOo() {
        return this.member_count;
    }

    public int bOp() {
        return this.thread_count;
    }

    public void a(RecommendForumInfo recommendForumInfo) {
        if (recommendForumInfo != null) {
            try {
                this.mForumId = recommendForumInfo.forum_id.longValue();
                this.mAvatar = recommendForumInfo.avatar;
                this.mForumName = recommendForumInfo.forum_name;
                this.gOU = recommendForumInfo.is_like.intValue() == 1;
                this.member_count = recommendForumInfo.member_count.intValue();
                this.thread_count = recommendForumInfo.thread_count.intValue();
                this.recom_reason = recommendForumInfo.recom_reason;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public String aOj() {
        return this.recom_reason;
    }
}
