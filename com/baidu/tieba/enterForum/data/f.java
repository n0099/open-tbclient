package com.baidu.tieba.enterForum.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import tbclient.ForumRecommend.LikeForum;
/* loaded from: classes4.dex */
public class f extends e implements com.baidu.tbadk.mvc.b.a {
    private int dhr;
    private String dhs;
    private int dht;
    private int dhu;
    private String mId;
    private int mLevel;
    private String mName;

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void kW(int i) {
        this.dhr = i;
    }

    public int ath() {
        return this.dhr;
    }

    public int ati() {
        return this.dhu;
    }

    public void setLevel(int i) {
        this.mLevel = i;
    }

    public int getLevel() {
        return this.mLevel;
    }

    public String getAvatar() {
        return this.dhs;
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
                this.dhr = likeForum.is_sign.intValue();
                this.mLevel = likeForum.level_id.intValue();
                this.dhs = likeForum.avatar;
                this.dht = likeForum.is_liveforum.intValue();
                this.dhu = likeForum.is_brand_forum.intValue();
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
