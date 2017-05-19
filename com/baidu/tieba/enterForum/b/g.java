package com.baidu.tieba.enterForum.b;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import tbclient.ForumRecommend.LikeForum;
/* loaded from: classes.dex */
public class g extends e implements com.baidu.tbadk.mvc.b.a {
    private int bGt;
    private String bGu;
    private int bhs;
    private String mId;
    private String mName;

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void hq(int i) {
        this.bGt = i;
    }

    public int VY() {
        return this.bGt;
    }

    public void setLevel(int i) {
        this.bhs = i;
    }

    public int getLevel() {
        return this.bhs;
    }

    public String getAvatar() {
        return this.bGu;
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
                this.bGt = likeForum.is_sign.intValue();
                this.bhs = likeForum.level_id.intValue();
                this.bGu = likeForum.avatar;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
