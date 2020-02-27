package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.RecommendForumInfo;
/* loaded from: classes9.dex */
public class i extends d implements com.baidu.tbadk.mvc.b.a {
    private String mAvatar;
    private long mForumId;
    private String mForumName;

    public String getForumName() {
        return this.mForumName;
    }

    public void a(RecommendForumInfo recommendForumInfo) {
        if (recommendForumInfo != null) {
            try {
                this.mForumId = recommendForumInfo.forum_id.longValue();
                this.mAvatar = recommendForumInfo.avatar;
                this.mForumName = recommendForumInfo.forum_name;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
