package com.baidu.tieba.enterForum.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import tbclient.ForumRecommend.LikeForum;
import tbclient.PrivateForumInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes4.dex */
public class d extends b implements com.baidu.tbadk.mvc.b.a {
    private PrivateForumInfo bzY;
    private int eBP;
    private String eBQ;
    private int eBR;
    private int eBS;
    private int eBT;
    private ThemeColorInfo eBU;
    private boolean eBV;
    private long eBW;
    private int eot;
    private String mContent;
    private String mId;
    private int mLevel;
    private String mName;
    private int sortType;

    public d() {
        setType(1);
    }

    public String aWj() {
        return this.mContent;
    }

    public int aWk() {
        return this.eot;
    }

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void pd(int i) {
        this.eBP = i;
    }

    public int aWl() {
        return this.eBP;
    }

    public int aWm() {
        return this.eBS;
    }

    public int isPrivateForum() {
        return this.eBT;
    }

    public int aWn() {
        return this.eBR;
    }

    public void setLevel(int i) {
        this.mLevel = i;
    }

    public int getLevel() {
        return this.mLevel;
    }

    public String getAvatar() {
        return this.eBQ;
    }

    public ThemeColorInfo aWo() {
        return this.eBU;
    }

    public ArrayList<Integer> aWp() {
        if (this.eBU == null || this.eBU.day == null || this.eBU.night == null) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.parseColor(this.eBU.day.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.parseColor(this.eBU.day.dark_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.parseColor(this.eBU.night.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.parseColor(this.eBU.night.dark_color)));
        return arrayList;
    }

    public boolean alE() {
        return this.eBV;
    }

    public void a(LikeForum likeForum) {
        if (likeForum != null) {
            a(likeForum, null);
        }
    }

    public boolean aWq() {
        return this.eBS == 1 && this.eBT == 1 && this.bzY != null && this.bzY.private_forum_status.intValue() == 1;
    }

    public boolean aWr() {
        return this.eBS == 1 && this.eBT == 1 && this.bzY != null && this.bzY.private_forum_status.intValue() == 1 && this.bzY.private_forum_audit_status.intValue() == 2;
    }

    public void a(LikeForum likeForum, Context context) {
        if (likeForum != null) {
            try {
                this.mId = String.valueOf(likeForum.forum_id);
                this.mName = likeForum.forum_name;
                this.eBP = likeForum.is_sign.intValue();
                this.mLevel = likeForum.level_id.intValue();
                this.eBQ = likeForum.avatar;
                this.eBS = likeForum.is_manager.intValue();
                this.eBT = likeForum.is_private_forum.intValue();
                this.bzY = likeForum.private_forum_info;
                this.eBR = likeForum.is_brand_forum.intValue();
                this.mContent = likeForum.content;
                this.eot = likeForum.is_top.intValue();
                this.sortType = likeForum.sort_type.intValue();
                this.eBU = likeForum.theme_color;
                this.eBV = likeForum.need_trans.booleanValue();
                this.eBW = likeForum.hot_thread_id.longValue();
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public long aWs() {
        return this.eBW;
    }

    public void cv(long j) {
        this.eBW = j;
    }
}
