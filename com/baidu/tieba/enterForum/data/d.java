package com.baidu.tieba.enterForum.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import tbclient.ForumRecommend.LikeForum;
import tbclient.PrivateForumInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes4.dex */
public class d extends b implements com.baidu.tbadk.mvc.b.a {
    private PrivateForumInfo bAc;
    private int eBB;
    private String eBC;
    private int eBD;
    private int eBE;
    private int eBF;
    private ThemeColorInfo eBG;
    private boolean eBH;
    private long eBI;
    private int eog;
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
        return this.eog;
    }

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void oZ(int i) {
        this.eBB = i;
    }

    public int aWj() {
        return this.eBB;
    }

    public int aWk() {
        return this.eBE;
    }

    public int isPrivateForum() {
        return this.eBF;
    }

    public int aWl() {
        return this.eBD;
    }

    public void setLevel(int i) {
        this.mLevel = i;
    }

    public int getLevel() {
        return this.mLevel;
    }

    public String getAvatar() {
        return this.eBC;
    }

    public ThemeColorInfo aWm() {
        return this.eBG;
    }

    public ArrayList<Integer> aWn() {
        if (this.eBG == null || this.eBG.day == null || this.eBG.night == null) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.parseColor(this.eBG.day.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.parseColor(this.eBG.day.dark_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.parseColor(this.eBG.night.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.parseColor(this.eBG.night.dark_color)));
        return arrayList;
    }

    public boolean alB() {
        return this.eBH;
    }

    public void a(LikeForum likeForum) {
        if (likeForum != null) {
            a(likeForum, null);
        }
    }

    public boolean aWo() {
        return this.eBE == 1 && this.eBF == 1 && this.bAc != null && this.bAc.private_forum_status.intValue() == 1;
    }

    public boolean aWp() {
        return this.eBE == 1 && this.eBF == 1 && this.bAc != null && this.bAc.private_forum_status.intValue() == 1 && this.bAc.private_forum_audit_status.intValue() == 2;
    }

    public void a(LikeForum likeForum, Context context) {
        if (likeForum != null) {
            try {
                this.mId = String.valueOf(likeForum.forum_id);
                this.mName = likeForum.forum_name;
                this.eBB = likeForum.is_sign.intValue();
                this.mLevel = likeForum.level_id.intValue();
                this.eBC = likeForum.avatar;
                this.eBE = likeForum.is_manager.intValue();
                this.eBF = likeForum.is_private_forum.intValue();
                this.bAc = likeForum.private_forum_info;
                this.eBD = likeForum.is_brand_forum.intValue();
                this.mContent = likeForum.content;
                this.eog = likeForum.is_top.intValue();
                this.sortType = likeForum.sort_type.intValue();
                this.eBG = likeForum.theme_color;
                this.eBH = likeForum.need_trans.booleanValue();
                this.eBI = likeForum.hot_thread_id.longValue();
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public long aWq() {
        return this.eBI;
    }

    public void cv(long j) {
        this.eBI = j;
    }
}
