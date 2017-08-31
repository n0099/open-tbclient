package com.baidu.tieba.enterForum.b;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import tbclient.ForumRecommend.LikeForum;
/* loaded from: classes.dex */
public class g extends e implements com.baidu.tbadk.mvc.b.a {
    private int bsN;
    private int cbN;
    private String cbO;
    private String mId;
    private String mName;

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void iq(int i) {
        this.cbN = i;
    }

    public int acJ() {
        return this.cbN;
    }

    public void setLevel(int i) {
        this.bsN = i;
    }

    public int getLevel() {
        return this.bsN;
    }

    public String getAvatar() {
        return this.cbO;
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
                this.cbN = likeForum.is_sign.intValue();
                this.bsN = likeForum.level_id.intValue();
                this.cbO = likeForum.avatar;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
