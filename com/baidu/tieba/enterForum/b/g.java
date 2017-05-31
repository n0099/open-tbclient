package com.baidu.tieba.enterForum.b;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import tbclient.ForumRecommend.LikeForum;
/* loaded from: classes.dex */
public class g extends e implements com.baidu.tbadk.mvc.b.a {
    private int bMi;
    private String bMj;
    private int biB;
    private String mId;
    private String mName;

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void hO(int i) {
        this.bMi = i;
    }

    public int Xb() {
        return this.bMi;
    }

    public void setLevel(int i) {
        this.biB = i;
    }

    public int getLevel() {
        return this.biB;
    }

    public String getAvatar() {
        return this.bMj;
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
                this.bMi = likeForum.is_sign.intValue();
                this.biB = likeForum.level_id.intValue();
                this.bMj = likeForum.avatar;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
