package com.baidu.tieba.enterForum.b;

import com.baidu.adp.lib.util.BdLog;
import tbclient.RecommendForumInfo;
/* loaded from: classes.dex */
public class j extends e implements com.baidu.tbadk.mvc.b.a {
    private String ccu;
    private int ccx;
    private int ccy;
    private String ccz;
    private long mForumId;
    private String mForumName;
    private int mThreadNum;

    public String getForumName() {
        return this.mForumName;
    }

    public void a(RecommendForumInfo recommendForumInfo) {
        if (recommendForumInfo != null) {
            try {
                this.ccu = recommendForumInfo.avatar;
                this.mForumId = recommendForumInfo.forum_id.longValue();
                this.mForumName = recommendForumInfo.forum_name;
                this.ccx = recommendForumInfo.is_like.intValue();
                this.ccy = recommendForumInfo.member_count.intValue();
                this.mThreadNum = recommendForumInfo.thread_count.intValue();
                this.ccz = recommendForumInfo.slogan;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
