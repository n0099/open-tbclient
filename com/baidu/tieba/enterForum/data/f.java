package com.baidu.tieba.enterForum.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import tbclient.ForumRecommend.LikeForum;
/* loaded from: classes2.dex */
public class f extends e implements com.baidu.tbadk.mvc.b.a {
    private int cPA;
    private int cPB;
    private int cPy;
    private String cPz;
    private String mId;
    private int mLevel;
    private String mName;

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void jw(int i) {
        this.cPy = i;
    }

    public int anX() {
        return this.cPy;
    }

    public int anY() {
        return this.cPB;
    }

    public void setLevel(int i) {
        this.mLevel = i;
    }

    public int getLevel() {
        return this.mLevel;
    }

    public String getAvatar() {
        return this.cPz;
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
                this.cPy = likeForum.is_sign.intValue();
                this.mLevel = likeForum.level_id.intValue();
                this.cPz = likeForum.avatar;
                this.cPA = likeForum.is_liveforum.intValue();
                this.cPB = likeForum.is_brand_forum.intValue();
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
