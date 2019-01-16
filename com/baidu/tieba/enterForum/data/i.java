package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.RecommendForumInfo;
/* loaded from: classes4.dex */
public class i extends e implements com.baidu.tbadk.mvc.b.a {
    private String drD;
    private long mForumId;
    private String mForumName;

    public String getForumName() {
        return this.mForumName;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public void a(RecommendForumInfo recommendForumInfo) {
        if (recommendForumInfo != null) {
            try {
                this.mForumId = recommendForumInfo.forum_id.longValue();
                this.drD = recommendForumInfo.avatar;
                this.mForumName = recommendForumInfo.forum_name;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
