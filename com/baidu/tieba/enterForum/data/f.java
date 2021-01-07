package com.baidu.tieba.enterForum.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.v;
import com.baidu.tieba.frs.FrsTabItemData;
import java.util.ArrayList;
import tbclient.ForumRecommend.LikeForum;
import tbclient.FrsTabInfo;
import tbclient.PrivateForumInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes2.dex */
public class f extends v implements com.baidu.tbadk.mvc.b.a {
    private String eRJ;
    private PrivateForumInfo eRx;
    private int fCN;
    private int iGH;
    private int iGI;
    private int iGJ;
    private int iGK;
    private int iGL;
    private ThemeColorInfo iGM;
    private boolean iGN;
    private long iGO;
    private String mContent;
    private String mId;
    private String mName;
    private int sortType;
    private ArrayList<FrsTabItemData> tabItemDatas;

    public f() {
        ox(1);
    }

    public String cxN() {
        return this.mContent;
    }

    public int cxO() {
        return this.iGL;
    }

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void yV(int i) {
        this.iGH = i;
    }

    public int cxP() {
        return this.iGH;
    }

    public int cxQ() {
        return this.iGJ;
    }

    public int isPrivateForum() {
        return this.iGK;
    }

    public int cxR() {
        return this.iGI;
    }

    public void setLevel(int i) {
        this.fCN = i;
    }

    public int getLevel() {
        return this.fCN;
    }

    public String getAvatar() {
        return this.eRJ;
    }

    public ThemeColorInfo cxS() {
        return this.iGM;
    }

    public ArrayList<Integer> cxT() {
        if (this.iGM == null || this.iGM.day == null || this.iGM.night == null || this.iGM.dark == null) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.c.b.sF(this.iGM.day.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.c.b.sF(this.iGM.day.dark_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.c.b.sF(this.iGM.night.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.c.b.sF(this.iGM.night.dark_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.c.b.sF(this.iGM.dark.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.c.b.sF(this.iGM.dark.dark_color)));
        return arrayList;
    }

    public boolean bEq() {
        return this.iGN;
    }

    public void a(LikeForum likeForum) {
        if (likeForum != null) {
            a(likeForum, (Context) null);
        }
    }

    public boolean cxU() {
        return this.iGJ == 1 && this.iGK == 1 && this.eRx != null && this.eRx.private_forum_status.intValue() == 1;
    }

    public boolean cxV() {
        return this.iGJ == 1 && this.iGK == 1 && this.eRx != null && this.eRx.private_forum_status.intValue() == 1 && this.eRx.private_forum_audit_status.intValue() == 2;
    }

    public void a(LikeForum likeForum, Context context) {
        if (likeForum != null) {
            try {
                this.mId = String.valueOf(likeForum.forum_id);
                this.mName = likeForum.forum_name;
                this.iGH = likeForum.is_sign.intValue();
                this.fCN = likeForum.level_id.intValue();
                this.eRJ = likeForum.avatar;
                this.iGJ = likeForum.is_manager.intValue();
                this.iGK = likeForum.is_private_forum.intValue();
                this.eRx = likeForum.private_forum_info;
                this.iGI = likeForum.is_brand_forum.intValue();
                this.mContent = likeForum.content;
                this.iGL = likeForum.is_top.intValue();
                this.sortType = likeForum.sort_type.intValue();
                this.iGM = likeForum.theme_color;
                this.iGN = likeForum.need_trans.booleanValue();
                this.iGO = likeForum.hot_thread_id.longValue();
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

    public long cxW() {
        return this.iGO;
    }

    public void gd(long j) {
        this.iGO = j;
    }

    public ArrayList<FrsTabItemData> cxX() {
        return this.tabItemDatas;
    }
}
