package com.baidu.tieba.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import tbclient.ForumRecommend.NewRecommend;
/* loaded from: classes.dex */
public class ad {
    private long alE;
    private int alF;
    private String alw;
    private String mForumName;

    public String getForumName() {
        return this.mForumName;
    }

    public int zG() {
        return this.alF;
    }

    public String getAvatar() {
        return this.alw;
    }

    public void a(NewRecommend newRecommend) {
        if (newRecommend != null) {
            a(newRecommend, null);
        }
    }

    public void a(NewRecommend newRecommend, Context context) {
        if (newRecommend != null) {
            try {
                this.alE = newRecommend.forum_id.longValue();
                this.mForumName = newRecommend.forum_name;
                this.alF = newRecommend.member_count.intValue();
                this.alw = newRecommend.avatar;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
