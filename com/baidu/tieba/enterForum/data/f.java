package com.baidu.tieba.enterForum.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import tbclient.ForumRecommend.LikeForum;
/* loaded from: classes4.dex */
public class f extends e implements com.baidu.tbadk.mvc.b.a {
    private int dqQ;
    private String dqR;
    private int dqS;
    private int dqT;
    private String mId;
    private int mLevel;
    private String mName;

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void lz(int i) {
        this.dqQ = i;
    }

    public int avI() {
        return this.dqQ;
    }

    public int avJ() {
        return this.dqT;
    }

    public void setLevel(int i) {
        this.mLevel = i;
    }

    public int getLevel() {
        return this.mLevel;
    }

    public String getAvatar() {
        return this.dqR;
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
                this.dqQ = likeForum.is_sign.intValue();
                this.mLevel = likeForum.level_id.intValue();
                this.dqR = likeForum.avatar;
                this.dqS = likeForum.is_liveforum.intValue();
                this.dqT = likeForum.is_brand_forum.intValue();
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
