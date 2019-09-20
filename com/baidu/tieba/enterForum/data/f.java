package com.baidu.tieba.enterForum.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import tbclient.ForumRecommend.LikeForum;
import tbclient.PrivateForumInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes4.dex */
public class f extends d implements com.baidu.tbadk.mvc.b.a {
    private PrivateForumInfo bIO;
    private int eKB;
    private int eYd;
    private String eYe;
    private int eYf;
    private int eYg;
    private int eYh;
    private ThemeColorInfo eYi;
    private boolean eYj;
    private long eYk;
    private String mContent;
    private String mId;
    private int mLevel;
    private String mName;
    private int sortType;

    public f() {
        setType(1);
    }

    public String bfU() {
        return this.mContent;
    }

    public int bfV() {
        return this.eKB;
    }

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void qz(int i) {
        this.eYd = i;
    }

    public int bfW() {
        return this.eYd;
    }

    public int bfX() {
        return this.eYg;
    }

    public int isPrivateForum() {
        return this.eYh;
    }

    public int bfY() {
        return this.eYf;
    }

    public void setLevel(int i) {
        this.mLevel = i;
    }

    public int getLevel() {
        return this.mLevel;
    }

    public String getAvatar() {
        return this.eYe;
    }

    public ThemeColorInfo bfZ() {
        return this.eYi;
    }

    public ArrayList<Integer> bga() {
        if (this.eYi == null || this.eYi.day == null || this.eYi.night == null) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.cE(this.eYi.day.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.cE(this.eYi.day.dark_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.cE(this.eYi.night.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.cE(this.eYi.night.dark_color)));
        return arrayList;
    }

    public boolean arY() {
        return this.eYj;
    }

    public void a(LikeForum likeForum) {
        if (likeForum != null) {
            a(likeForum, null);
        }
    }

    public boolean bgb() {
        return this.eYg == 1 && this.eYh == 1 && this.bIO != null && this.bIO.private_forum_status.intValue() == 1;
    }

    public boolean bgc() {
        return this.eYg == 1 && this.eYh == 1 && this.bIO != null && this.bIO.private_forum_status.intValue() == 1 && this.bIO.private_forum_audit_status.intValue() == 2;
    }

    public void a(LikeForum likeForum, Context context) {
        if (likeForum != null) {
            try {
                this.mId = String.valueOf(likeForum.forum_id);
                this.mName = likeForum.forum_name;
                this.eYd = likeForum.is_sign.intValue();
                this.mLevel = likeForum.level_id.intValue();
                this.eYe = likeForum.avatar;
                this.eYg = likeForum.is_manager.intValue();
                this.eYh = likeForum.is_private_forum.intValue();
                this.bIO = likeForum.private_forum_info;
                this.eYf = likeForum.is_brand_forum.intValue();
                this.mContent = likeForum.content;
                this.eKB = likeForum.is_top.intValue();
                this.sortType = likeForum.sort_type.intValue();
                this.eYi = likeForum.theme_color;
                this.eYj = likeForum.need_trans.booleanValue();
                this.eYk = likeForum.hot_thread_id.longValue();
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public long bgd() {
        return this.eYk;
    }

    public void dc(long j) {
        this.eYk = j;
    }
}
