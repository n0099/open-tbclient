package com.baidu.tieba.enterForum.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import tbclient.ForumRecommend.LikeForum;
/* loaded from: classes4.dex */
public class f extends e implements com.baidu.tbadk.mvc.b.a {
    private int dgm;
    private String dgn;
    private int dgo;
    private int dgp;
    private String mId;
    private int mLevel;
    private String mName;

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void kE(int i) {
        this.dgm = i;
    }

    public int atH() {
        return this.dgm;
    }

    public int atI() {
        return this.dgp;
    }

    public void setLevel(int i) {
        this.mLevel = i;
    }

    public int getLevel() {
        return this.mLevel;
    }

    public String getAvatar() {
        return this.dgn;
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
                this.dgm = likeForum.is_sign.intValue();
                this.mLevel = likeForum.level_id.intValue();
                this.dgn = likeForum.avatar;
                this.dgo = likeForum.is_liveforum.intValue();
                this.dgp = likeForum.is_brand_forum.intValue();
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
