package com.baidu.tieba.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import tbclient.ForumRecommend.NewRecommend;
/* loaded from: classes.dex */
public class k {
    private long ats;
    private int att;
    private String atu;
    private String mForumName;

    public void a(NewRecommend newRecommend) {
        if (newRecommend != null) {
            a(newRecommend, null);
        }
    }

    public void a(NewRecommend newRecommend, Context context) {
        if (newRecommend != null) {
            try {
                this.ats = newRecommend.forum_id.longValue();
                this.mForumName = newRecommend.forum_name;
                this.att = newRecommend.member_count.intValue();
                this.atu = newRecommend.avatar;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
