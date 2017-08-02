package com.baidu.tieba.enterForum.b;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import tbclient.ForumRecommend.LikeForum;
/* loaded from: classes.dex */
public class g extends e implements com.baidu.tbadk.mvc.b.a {
    private int bWX;
    private String bWY;
    private int bpY;
    private String mId;
    private String mName;

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void ie(int i) {
        this.bWX = i;
    }

    public int abk() {
        return this.bWX;
    }

    public void setLevel(int i) {
        this.bpY = i;
    }

    public int getLevel() {
        return this.bpY;
    }

    public String getAvatar() {
        return this.bWY;
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
                this.bWX = likeForum.is_sign.intValue();
                this.bpY = likeForum.level_id.intValue();
                this.bWY = likeForum.avatar;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
