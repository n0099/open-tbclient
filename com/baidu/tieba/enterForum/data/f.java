package com.baidu.tieba.enterForum.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import tbclient.ForumRecommend.LikeForum;
/* loaded from: classes.dex */
public class f extends e implements com.baidu.tbadk.mvc.b.a {
    private int csV;
    private String csW;
    private String mId;
    private int mLevel;
    private String mName;

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void jn(int i) {
        this.csV = i;
    }

    public int agQ() {
        return this.csV;
    }

    public void setLevel(int i) {
        this.mLevel = i;
    }

    public int getLevel() {
        return this.mLevel;
    }

    public String getAvatar() {
        return this.csW;
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
                this.csV = likeForum.is_sign.intValue();
                this.mLevel = likeForum.level_id.intValue();
                this.csW = likeForum.avatar;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
