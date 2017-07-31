package com.baidu.tieba.enterForum.b;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import tbclient.ForumRecommend.LikeForum;
/* loaded from: classes.dex */
public class g extends e implements com.baidu.tbadk.mvc.b.a {
    private int bYd;
    private String bYe;
    private int bri;
    private String mId;
    private String mName;

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void ie(int i) {
        this.bYd = i;
    }

    public int abp() {
        return this.bYd;
    }

    public void setLevel(int i) {
        this.bri = i;
    }

    public int getLevel() {
        return this.bri;
    }

    public String getAvatar() {
        return this.bYe;
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
                this.bYd = likeForum.is_sign.intValue();
                this.bri = likeForum.level_id.intValue();
                this.bYe = likeForum.avatar;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
