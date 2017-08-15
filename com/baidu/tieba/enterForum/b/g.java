package com.baidu.tieba.enterForum.b;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import tbclient.ForumRecommend.LikeForum;
/* loaded from: classes.dex */
public class g extends e implements com.baidu.tbadk.mvc.b.a {
    private int bYP;
    private String bYQ;
    private int bsh;
    private String mId;
    private String mName;

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void ig(int i) {
        this.bYP = i;
    }

    public int abK() {
        return this.bYP;
    }

    public void setLevel(int i) {
        this.bsh = i;
    }

    public int getLevel() {
        return this.bsh;
    }

    public String getAvatar() {
        return this.bYQ;
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
                this.bYP = likeForum.is_sign.intValue();
                this.bsh = likeForum.level_id.intValue();
                this.bYQ = likeForum.avatar;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
