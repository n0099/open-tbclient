package com.baidu.tieba.enterForum.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import tbclient.ForumRecommend.LikeForum;
import tbclient.PrivateForumInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes4.dex */
public class d extends b implements com.baidu.tbadk.mvc.b.a {
    private PrivateForumInfo bAb;
    private int eBA;
    private String eBB;
    private int eBC;
    private int eBD;
    private int eBE;
    private ThemeColorInfo eBF;
    private boolean eBG;
    private long eBH;
    private int eoe;
    private String mContent;
    private String mId;
    private int mLevel;
    private String mName;
    private int sortType;

    public d() {
        setType(1);
    }

    public String aWh() {
        return this.mContent;
    }

    public int aWi() {
        return this.eoe;
    }

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void oZ(int i) {
        this.eBA = i;
    }

    public int aWj() {
        return this.eBA;
    }

    public int aWk() {
        return this.eBD;
    }

    public int isPrivateForum() {
        return this.eBE;
    }

    public int aWl() {
        return this.eBC;
    }

    public void setLevel(int i) {
        this.mLevel = i;
    }

    public int getLevel() {
        return this.mLevel;
    }

    public String getAvatar() {
        return this.eBB;
    }

    public ThemeColorInfo aWm() {
        return this.eBF;
    }

    public ArrayList<Integer> aWn() {
        if (this.eBF == null || this.eBF.day == null || this.eBF.night == null) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.parseColor(this.eBF.day.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.parseColor(this.eBF.day.dark_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.parseColor(this.eBF.night.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.parseColor(this.eBF.night.dark_color)));
        return arrayList;
    }

    public boolean alB() {
        return this.eBG;
    }

    public void a(LikeForum likeForum) {
        if (likeForum != null) {
            a(likeForum, null);
        }
    }

    public boolean aWo() {
        return this.eBD == 1 && this.eBE == 1 && this.bAb != null && this.bAb.private_forum_status.intValue() == 1;
    }

    public boolean aWp() {
        return this.eBD == 1 && this.eBE == 1 && this.bAb != null && this.bAb.private_forum_status.intValue() == 1 && this.bAb.private_forum_audit_status.intValue() == 2;
    }

    public void a(LikeForum likeForum, Context context) {
        if (likeForum != null) {
            try {
                this.mId = String.valueOf(likeForum.forum_id);
                this.mName = likeForum.forum_name;
                this.eBA = likeForum.is_sign.intValue();
                this.mLevel = likeForum.level_id.intValue();
                this.eBB = likeForum.avatar;
                this.eBD = likeForum.is_manager.intValue();
                this.eBE = likeForum.is_private_forum.intValue();
                this.bAb = likeForum.private_forum_info;
                this.eBC = likeForum.is_brand_forum.intValue();
                this.mContent = likeForum.content;
                this.eoe = likeForum.is_top.intValue();
                this.sortType = likeForum.sort_type.intValue();
                this.eBF = likeForum.theme_color;
                this.eBG = likeForum.need_trans.booleanValue();
                this.eBH = likeForum.hot_thread_id.longValue();
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public long aWq() {
        return this.eBH;
    }

    public void cv(long j) {
        this.eBH = j;
    }
}
