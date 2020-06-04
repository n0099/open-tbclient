package com.baidu.tieba.enterForum.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.frs.FrsTabItemData;
import java.util.ArrayList;
import tbclient.ForumRecommend.LikeForum;
import tbclient.FrsTabInfo;
import tbclient.PrivateForumInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes9.dex */
public class h extends f implements com.baidu.tbadk.mvc.b.a {
    private PrivateForumInfo dDH;
    private int gOW;
    private int gOX;
    private int gOY;
    private int gOZ;
    private int gPa;
    private ThemeColorInfo gPb;
    private boolean gPc;
    private long gPd;
    private String mAvatar;
    private String mContent;
    private String mId;
    private int mLevel;
    private String mName;
    private int sortType;
    private ArrayList<FrsTabItemData> tabItemDatas;

    public h() {
        setType(1);
    }

    public String bOd() {
        return this.mContent;
    }

    public int bOe() {
        return this.gPa;
    }

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void sM(int i) {
        this.gOW = i;
    }

    public int bOf() {
        return this.gOW;
    }

    public int bOg() {
        return this.gOY;
    }

    public int isPrivateForum() {
        return this.gOZ;
    }

    public int bOh() {
        return this.gOX;
    }

    public void setLevel(int i) {
        this.mLevel = i;
    }

    public int getLevel() {
        return this.mLevel;
    }

    public String getAvatar() {
        return this.mAvatar;
    }

    public ThemeColorInfo bOi() {
        return this.gPb;
    }

    public ArrayList<Integer> bOj() {
        if (this.gPb == null || this.gPb.day == null || this.gPb.night == null || this.gPb.dark == null) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.dT(this.gPb.day.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.dT(this.gPb.day.dark_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.dT(this.gPb.night.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.dT(this.gPb.night.dark_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.dT(this.gPb.dark.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.dT(this.gPb.dark.dark_color)));
        return arrayList;
    }

    public boolean bcK() {
        return this.gPc;
    }

    public void a(LikeForum likeForum) {
        if (likeForum != null) {
            a(likeForum, null);
        }
    }

    public boolean bOk() {
        return this.gOY == 1 && this.gOZ == 1 && this.dDH != null && this.dDH.private_forum_status.intValue() == 1;
    }

    public boolean bOl() {
        return this.gOY == 1 && this.gOZ == 1 && this.dDH != null && this.dDH.private_forum_status.intValue() == 1 && this.dDH.private_forum_audit_status.intValue() == 2;
    }

    public void a(LikeForum likeForum, Context context) {
        if (likeForum != null) {
            try {
                this.mId = String.valueOf(likeForum.forum_id);
                this.mName = likeForum.forum_name;
                this.gOW = likeForum.is_sign.intValue();
                this.mLevel = likeForum.level_id.intValue();
                this.mAvatar = likeForum.avatar;
                this.gOY = likeForum.is_manager.intValue();
                this.gOZ = likeForum.is_private_forum.intValue();
                this.dDH = likeForum.private_forum_info;
                this.gOX = likeForum.is_brand_forum.intValue();
                this.mContent = likeForum.content;
                this.gPa = likeForum.is_top.intValue();
                this.sortType = likeForum.sort_type.intValue();
                this.gPb = likeForum.theme_color;
                this.gPc = likeForum.need_trans.booleanValue();
                this.gPd = likeForum.hot_thread_id.longValue();
                this.tabItemDatas = new ArrayList<>();
                for (FrsTabInfo frsTabInfo : likeForum.tab_info) {
                    if (frsTabInfo != null && frsTabInfo.is_general_tab.intValue() == 1 && frsTabInfo.tab_id.intValue() > 0 && !StringUtils.isNull(frsTabInfo.tab_name)) {
                        this.tabItemDatas.add(new FrsTabItemData(frsTabInfo));
                    }
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public long bOm() {
        return this.gPd;
    }

    public void dX(long j) {
        this.gPd = j;
    }

    public ArrayList<FrsTabItemData> bOn() {
        return this.tabItemDatas;
    }
}
