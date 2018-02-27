package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.RecommendForumInfo;
/* loaded from: classes2.dex */
public class i extends e implements com.baidu.tbadk.mvc.b.a {
    private String doZ;
    private String mForumName;

    public String getForumName() {
        return this.mForumName;
    }

    public void a(RecommendForumInfo recommendForumInfo) {
        if (recommendForumInfo != null) {
            try {
                this.doZ = recommendForumInfo.avatar;
                this.mForumName = recommendForumInfo.forum_name;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
