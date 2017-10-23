package com.baidu.tieba.enterForum.b;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import tbclient.ForumRecommend.LikeForum;
/* loaded from: classes.dex */
public class g extends e implements com.baidu.tbadk.mvc.b.a {
    private int buH;
    private int cct;
    private String ccu;
    private String mId;
    private String mName;

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void iz(int i) {
        this.cct = i;
    }

    public int acD() {
        return this.cct;
    }

    public void setLevel(int i) {
        this.buH = i;
    }

    public int getLevel() {
        return this.buH;
    }

    public String getAvatar() {
        return this.ccu;
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
                this.cct = likeForum.is_sign.intValue();
                this.buH = likeForum.level_id.intValue();
                this.ccu = likeForum.avatar;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
