package com.baidu.tieba.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import tbclient.ForumRecommend.LikeForum;
/* loaded from: classes.dex */
public class y {
    private String mId = null;
    private String mName = null;
    private int alu = 0;
    private int alv = 0;
    private int alx = 0;
    private String alw = null;

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void ec(int i) {
        this.alv = i;
    }

    public int zy() {
        return this.alv;
    }

    public void setLevel(int i) {
        this.alu = i;
    }

    public int getLevel() {
        return this.alu;
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
                this.alv = likeForum.is_sign.intValue();
                this.alu = likeForum.level_id.intValue();
                this.alw = likeForum.avatar;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public int isLike() {
        return this.alx;
    }
}
