package com.baidu.tieba.enterForum.b;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import tbclient.ForumRecommend.LikeForum;
/* loaded from: classes.dex */
public class g extends e implements com.baidu.tbadk.mvc.b.a {
    private int bYQ;
    private String bYR;
    private int bsj;
    private String mId;
    private String mName;

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void ig(int i) {
        this.bYQ = i;
    }

    public int abH() {
        return this.bYQ;
    }

    public void setLevel(int i) {
        this.bsj = i;
    }

    public int getLevel() {
        return this.bsj;
    }

    public String getAvatar() {
        return this.bYR;
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
                this.bYQ = likeForum.is_sign.intValue();
                this.bsj = likeForum.level_id.intValue();
                this.bYR = likeForum.avatar;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
