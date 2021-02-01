package com.baidu.tieba.enterForum.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.w;
import com.baidu.tieba.frs.FrsTabItemData;
import java.util.ArrayList;
import tbclient.ForumRecommend.LikeForum;
import tbclient.FrsTabInfo;
import tbclient.PrivateForumInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes2.dex */
public class f extends w implements com.baidu.tbadk.mvc.b.a {
    private PrivateForumInfo eOY;
    private String ePk;
    private int iHK;
    private int iHL;
    private int iHM;
    private int iHN;
    private int iHO;
    private ThemeColorInfo iHP;
    private boolean iHQ;
    private long iHR;
    private String mContent;
    private String mId;
    private int mLevel;
    private String mName;
    private int sortType;
    private ArrayList<FrsTabItemData> tabItemDatas;

    public f() {
        mU(1);
    }

    public String cvh() {
        return this.mContent;
    }

    public int cvi() {
        return this.iHO;
    }

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void xz(int i) {
        this.iHK = i;
    }

    public int cvj() {
        return this.iHK;
    }

    public int cvk() {
        return this.iHM;
    }

    public int isPrivateForum() {
        return this.iHN;
    }

    public int cvl() {
        return this.iHL;
    }

    public void setLevel(int i) {
        this.mLevel = i;
    }

    public int getLevel() {
        return this.mLevel;
    }

    public String getAvatar() {
        return this.ePk;
    }

    public ThemeColorInfo cvm() {
        return this.iHP;
    }

    public ArrayList<Integer> cvn() {
        if (this.iHP == null || this.iHP.day == null || this.iHP.night == null || this.iHP.dark == null) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.c.b.rM(this.iHP.day.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.c.b.rM(this.iHP.day.dark_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.c.b.rM(this.iHP.night.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.c.b.rM(this.iHP.night.dark_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.c.b.rM(this.iHP.dark.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.c.b.rM(this.iHP.dark.dark_color)));
        return arrayList;
    }

    public boolean bAO() {
        return this.iHQ;
    }

    public void a(LikeForum likeForum) {
        if (likeForum != null) {
            a(likeForum, (Context) null);
        }
    }

    public boolean cvo() {
        return this.iHM == 1 && this.iHN == 1 && this.eOY != null && this.eOY.private_forum_status.intValue() == 1;
    }

    public boolean cvp() {
        return this.iHM == 1 && this.iHN == 1 && this.eOY != null && this.eOY.private_forum_status.intValue() == 1 && this.eOY.private_forum_audit_status.intValue() == 2;
    }

    public void a(LikeForum likeForum, Context context) {
        if (likeForum != null) {
            try {
                this.mId = String.valueOf(likeForum.forum_id);
                this.mName = likeForum.forum_name;
                this.iHK = likeForum.is_sign.intValue();
                this.mLevel = likeForum.level_id.intValue();
                this.ePk = likeForum.avatar;
                this.iHM = likeForum.is_manager.intValue();
                this.iHN = likeForum.is_private_forum.intValue();
                this.eOY = likeForum.private_forum_info;
                this.iHL = likeForum.is_brand_forum.intValue();
                this.mContent = likeForum.content;
                this.iHO = likeForum.is_top.intValue();
                this.sortType = likeForum.sort_type.intValue();
                this.iHP = likeForum.theme_color;
                this.iHQ = likeForum.need_trans.booleanValue();
                this.iHR = likeForum.hot_thread_id.longValue();
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

    public long cvq() {
        return this.iHR;
    }

    public void gi(long j) {
        this.iHR = j;
    }

    public ArrayList<FrsTabItemData> cvr() {
        return this.tabItemDatas;
    }
}
