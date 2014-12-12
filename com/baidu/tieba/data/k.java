package com.baidu.tieba.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import tbclient.ForumRecommend.NewRecommend;
/* loaded from: classes.dex */
public class k {
    private long asp;
    private int asq;
    private String asr;
    private String mForumName;

    public void a(NewRecommend newRecommend) {
        if (newRecommend != null) {
            a(newRecommend, null);
        }
    }

    public void a(NewRecommend newRecommend, Context context) {
        if (newRecommend != null) {
            try {
                this.asp = newRecommend.forum_id.longValue();
                this.mForumName = newRecommend.forum_name;
                this.asq = newRecommend.member_count.intValue();
                this.asr = newRecommend.avatar;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
