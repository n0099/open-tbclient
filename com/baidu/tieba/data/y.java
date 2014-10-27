package com.baidu.tieba.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import tbclient.ForumRecommend.LikeForum;
/* loaded from: classes.dex */
public class y {
    private String mId = null;
    private String mName = null;
    private int alk = 0;
    private int alm = 0;
    private int alo = 0;
    private String aln = null;

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void ec(int i) {
        this.alm = i;
    }

    public int zw() {
        return this.alm;
    }

    public void setLevel(int i) {
        this.alk = i;
    }

    public int getLevel() {
        return this.alk;
    }

    public void a(LikeForum likeForum) {
        if (likeForum != null) {
            a(likeForum, null);
        }
    }

    public void a(LikeForum likeForum, Context context) {
        if (likeForum != null) {
            try {
                this.mId = String.valueOf(likeForum.forum_id);
                this.mName = likeForum.forum_name;
                this.alm = likeForum.is_sign.intValue();
                this.alk = likeForum.level_id.intValue();
                this.aln = likeForum.avatar;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public int isLike() {
        return this.alo;
    }
}
