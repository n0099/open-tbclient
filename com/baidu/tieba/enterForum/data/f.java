package com.baidu.tieba.enterForum.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import tbclient.ForumRecommend.LikeForum;
import tbclient.PrivateForumInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes4.dex */
public class f extends d implements com.baidu.tbadk.mvc.b.a {
    private PrivateForumInfo bIq;
    private int eIS;
    private int eWA;
    private int eWB;
    private ThemeColorInfo eWC;
    private boolean eWD;
    private long eWE;
    private int eWx;
    private String eWy;
    private int eWz;
    private String mContent;
    private String mId;
    private int mLevel;
    private String mName;
    private int sortType;

    public f() {
        setType(1);
    }

    public String bfq() {
        return this.mContent;
    }

    public int bfr() {
        return this.eIS;
    }

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void qw(int i) {
        this.eWx = i;
    }

    public int bfs() {
        return this.eWx;
    }

    public int bft() {
        return this.eWA;
    }

    public int isPrivateForum() {
        return this.eWB;
    }

    public int bfu() {
        return this.eWz;
    }

    public void setLevel(int i) {
        this.mLevel = i;
    }

    public int getLevel() {
        return this.mLevel;
    }

    public String getAvatar() {
        return this.eWy;
    }

    public ThemeColorInfo bfv() {
        return this.eWC;
    }

    public ArrayList<Integer> bfw() {
        if (this.eWC == null || this.eWC.day == null || this.eWC.night == null) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.cE(this.eWC.day.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.cE(this.eWC.day.dark_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.cE(this.eWC.night.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.cE(this.eWC.night.dark_color)));
        return arrayList;
    }

    public boolean arM() {
        return this.eWD;
    }

    public void a(LikeForum likeForum) {
        if (likeForum != null) {
            a(likeForum, null);
        }
    }

    public boolean bfx() {
        return this.eWA == 1 && this.eWB == 1 && this.bIq != null && this.bIq.private_forum_status.intValue() == 1;
    }

    public boolean bfy() {
        return this.eWA == 1 && this.eWB == 1 && this.bIq != null && this.bIq.private_forum_status.intValue() == 1 && this.bIq.private_forum_audit_status.intValue() == 2;
    }

    public void a(LikeForum likeForum, Context context) {
        if (likeForum != null) {
            try {
                this.mId = String.valueOf(likeForum.forum_id);
                this.mName = likeForum.forum_name;
                this.eWx = likeForum.is_sign.intValue();
                this.mLevel = likeForum.level_id.intValue();
                this.eWy = likeForum.avatar;
                this.eWA = likeForum.is_manager.intValue();
                this.eWB = likeForum.is_private_forum.intValue();
                this.bIq = likeForum.private_forum_info;
                this.eWz = likeForum.is_brand_forum.intValue();
                this.mContent = likeForum.content;
                this.eIS = likeForum.is_top.intValue();
                this.sortType = likeForum.sort_type.intValue();
                this.eWC = likeForum.theme_color;
                this.eWD = likeForum.need_trans.booleanValue();
                this.eWE = likeForum.hot_thread_id.longValue();
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public long bfz() {
        return this.eWE;
    }

    public void cZ(long j) {
        this.eWE = j;
    }
}
