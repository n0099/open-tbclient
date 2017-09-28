package com.baidu.tieba.enterForum.b;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import tbclient.ForumRecommend.LikeForum;
/* loaded from: classes.dex */
public class g extends e implements com.baidu.tbadk.mvc.b.a {
    private int buT;
    private int ccF;
    private String ccG;
    private String mId;
    private String mName;

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void iA(int i) {
        this.ccF = i;
    }

    public int acH() {
        return this.ccF;
    }

    public void setLevel(int i) {
        this.buT = i;
    }

    public int getLevel() {
        return this.buT;
    }

    public String getAvatar() {
        return this.ccG;
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
                this.ccF = likeForum.is_sign.intValue();
                this.buT = likeForum.level_id.intValue();
                this.ccG = likeForum.avatar;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
