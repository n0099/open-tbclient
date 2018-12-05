package com.baidu.tieba.enterForum.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import tbclient.ForumRecommend.LikeForum;
/* loaded from: classes4.dex */
public class f extends e implements com.baidu.tbadk.mvc.b.a {
    private int dnZ;
    private String doa;
    private int dob;
    private int dod;
    private String mId;
    private int mLevel;
    private String mName;

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void lm(int i) {
        this.dnZ = i;
    }

    public int auT() {
        return this.dnZ;
    }

    public int auU() {
        return this.dod;
    }

    public void setLevel(int i) {
        this.mLevel = i;
    }

    public int getLevel() {
        return this.mLevel;
    }

    public String getAvatar() {
        return this.doa;
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
                this.dnZ = likeForum.is_sign.intValue();
                this.mLevel = likeForum.level_id.intValue();
                this.doa = likeForum.avatar;
                this.dob = likeForum.is_liveforum.intValue();
                this.dod = likeForum.is_brand_forum.intValue();
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
