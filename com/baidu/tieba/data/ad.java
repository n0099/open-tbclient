package com.baidu.tieba.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import tbclient.ForumRecommend.NewRecommend;
/* loaded from: classes.dex */
public class ad {
    private String aln;
    private long alv;
    private int alw;
    private String mForumName;

    public String getForumName() {
        return this.mForumName;
    }

    public int zE() {
        return this.alw;
    }

    public String getAvatar() {
        return this.aln;
    }

    public void a(NewRecommend newRecommend) {
        if (newRecommend != null) {
            a(newRecommend, null);
        }
    }

    public void a(NewRecommend newRecommend, Context context) {
        if (newRecommend != null) {
            try {
                this.alv = newRecommend.forum_id.longValue();
                this.mForumName = newRecommend.forum_name;
                this.alw = newRecommend.member_count.intValue();
                this.aln = newRecommend.avatar;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
