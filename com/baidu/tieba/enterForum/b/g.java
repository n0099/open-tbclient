package com.baidu.tieba.enterForum.b;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import tbclient.ForumRecommend.LikeForum;
/* loaded from: classes.dex */
public class g extends e implements com.baidu.tbadk.mvc.b.a {
    private int bSJ;
    private String bSK;
    private int bmb;
    private String mId;
    private String mName;

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void hX(int i) {
        this.bSJ = i;
    }

    public int aay() {
        return this.bSJ;
    }

    public void setLevel(int i) {
        this.bmb = i;
    }

    public int getLevel() {
        return this.bmb;
    }

    public String getAvatar() {
        return this.bSK;
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
                this.bSJ = likeForum.is_sign.intValue();
                this.bmb = likeForum.level_id.intValue();
                this.bSK = likeForum.avatar;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
