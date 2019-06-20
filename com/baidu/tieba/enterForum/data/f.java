package com.baidu.tieba.enterForum.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import tbclient.ForumRecommend.LikeForum;
import tbclient.PrivateForumInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes4.dex */
public class f extends d implements com.baidu.tbadk.mvc.b.a {
    private PrivateForumInfo bHp;
    private int eDP;
    private int eRn;
    private String eRo;
    private int eRp;
    private int eRq;
    private int eRr;
    private ThemeColorInfo eRs;
    private boolean eRt;
    private long eRu;
    private String mContent;
    private String mId;
    private int mLevel;
    private String mName;
    private int sortType;

    public f() {
        setType(1);
    }

    public String bdm() {
        return this.mContent;
    }

    public int bdn() {
        return this.eDP;
    }

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void qd(int i) {
        this.eRn = i;
    }

    public int bdo() {
        return this.eRn;
    }

    public int bdp() {
        return this.eRq;
    }

    public int isPrivateForum() {
        return this.eRr;
    }

    public int bdq() {
        return this.eRp;
    }

    public void setLevel(int i) {
        this.mLevel = i;
    }

    public int getLevel() {
        return this.mLevel;
    }

    public String getAvatar() {
        return this.eRo;
    }

    public ThemeColorInfo bdr() {
        return this.eRs;
    }

    public ArrayList<Integer> bds() {
        if (this.eRs == null || this.eRs.day == null || this.eRs.night == null) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.parseColor(this.eRs.day.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.parseColor(this.eRs.day.dark_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.parseColor(this.eRs.night.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.parseColor(this.eRs.night.dark_color)));
        return arrayList;
    }

    public boolean aqE() {
        return this.eRt;
    }

    public void a(LikeForum likeForum) {
        if (likeForum != null) {
            a(likeForum, null);
        }
    }

    public boolean bdt() {
        return this.eRq == 1 && this.eRr == 1 && this.bHp != null && this.bHp.private_forum_status.intValue() == 1;
    }

    public boolean bdu() {
        return this.eRq == 1 && this.eRr == 1 && this.bHp != null && this.bHp.private_forum_status.intValue() == 1 && this.bHp.private_forum_audit_status.intValue() == 2;
    }

    public void a(LikeForum likeForum, Context context) {
        if (likeForum != null) {
            try {
                this.mId = String.valueOf(likeForum.forum_id);
                this.mName = likeForum.forum_name;
                this.eRn = likeForum.is_sign.intValue();
                this.mLevel = likeForum.level_id.intValue();
                this.eRo = likeForum.avatar;
                this.eRq = likeForum.is_manager.intValue();
                this.eRr = likeForum.is_private_forum.intValue();
                this.bHp = likeForum.private_forum_info;
                this.eRp = likeForum.is_brand_forum.intValue();
                this.mContent = likeForum.content;
                this.eDP = likeForum.is_top.intValue();
                this.sortType = likeForum.sort_type.intValue();
                this.eRs = likeForum.theme_color;
                this.eRt = likeForum.need_trans.booleanValue();
                this.eRu = likeForum.hot_thread_id.longValue();
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public long bdv() {
        return this.eRu;
    }

    public void cS(long j) {
        this.eRu = j;
    }
}
