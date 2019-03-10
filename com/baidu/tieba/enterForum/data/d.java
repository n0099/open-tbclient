package com.baidu.tieba.enterForum.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import tbclient.ForumRecommend.LikeForum;
import tbclient.PrivateForumInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes4.dex */
public class d extends b implements com.baidu.tbadk.mvc.b.a {
    private PrivateForumInfo bzW;
    private int eBT;
    private String eBU;
    private int eBV;
    private int eBW;
    private int eBX;
    private ThemeColorInfo eBY;
    private boolean eBZ;
    private long eCa;
    private int eox;
    private String mContent;
    private String mId;
    private int mLevel;
    private String mName;
    private int sortType;

    public d() {
        setType(1);
    }

    public String aWk() {
        return this.mContent;
    }

    public int aWl() {
        return this.eox;
    }

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void pd(int i) {
        this.eBT = i;
    }

    public int aWm() {
        return this.eBT;
    }

    public int aWn() {
        return this.eBW;
    }

    public int isPrivateForum() {
        return this.eBX;
    }

    public int aWo() {
        return this.eBV;
    }

    public void setLevel(int i) {
        this.mLevel = i;
    }

    public int getLevel() {
        return this.mLevel;
    }

    public String getAvatar() {
        return this.eBU;
    }

    public ThemeColorInfo aWp() {
        return this.eBY;
    }

    public ArrayList<Integer> aWq() {
        if (this.eBY == null || this.eBY.day == null || this.eBY.night == null) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.parseColor(this.eBY.day.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.parseColor(this.eBY.day.dark_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.parseColor(this.eBY.night.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.parseColor(this.eBY.night.dark_color)));
        return arrayList;
    }

    public boolean alF() {
        return this.eBZ;
    }

    public void a(LikeForum likeForum) {
        if (likeForum != null) {
            a(likeForum, null);
        }
    }

    public boolean aWr() {
        return this.eBW == 1 && this.eBX == 1 && this.bzW != null && this.bzW.private_forum_status.intValue() == 1;
    }

    public boolean aWs() {
        return this.eBW == 1 && this.eBX == 1 && this.bzW != null && this.bzW.private_forum_status.intValue() == 1 && this.bzW.private_forum_audit_status.intValue() == 2;
    }

    public void a(LikeForum likeForum, Context context) {
        if (likeForum != null) {
            try {
                this.mId = String.valueOf(likeForum.forum_id);
                this.mName = likeForum.forum_name;
                this.eBT = likeForum.is_sign.intValue();
                this.mLevel = likeForum.level_id.intValue();
                this.eBU = likeForum.avatar;
                this.eBW = likeForum.is_manager.intValue();
                this.eBX = likeForum.is_private_forum.intValue();
                this.bzW = likeForum.private_forum_info;
                this.eBV = likeForum.is_brand_forum.intValue();
                this.mContent = likeForum.content;
                this.eox = likeForum.is_top.intValue();
                this.sortType = likeForum.sort_type.intValue();
                this.eBY = likeForum.theme_color;
                this.eBZ = likeForum.need_trans.booleanValue();
                this.eCa = likeForum.hot_thread_id.longValue();
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public long aWt() {
        return this.eCa;
    }

    public void cv(long j) {
        this.eCa = j;
    }
}
