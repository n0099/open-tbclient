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
    private String eQL;
    private PrivateForumInfo eQz;
    private int iJH;
    private int iJI;
    private int iJJ;
    private int iJK;
    private int iJL;
    private ThemeColorInfo iJM;
    private boolean iJN;
    private long iJO;
    private String mContent;
    private String mId;
    private int mLevel;
    private String mName;
    private int sortType;
    private ArrayList<FrsTabItemData> tabItemDatas;

    public f() {
        mV(1);
    }

    public String cvu() {
        return this.mContent;
    }

    public int cvv() {
        return this.iJL;
    }

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void xA(int i) {
        this.iJH = i;
    }

    public int cvw() {
        return this.iJH;
    }

    public int cvx() {
        return this.iJJ;
    }

    public int isPrivateForum() {
        return this.iJK;
    }

    public int cvy() {
        return this.iJI;
    }

    public void setLevel(int i) {
        this.mLevel = i;
    }

    public int getLevel() {
        return this.mLevel;
    }

    public String getAvatar() {
        return this.eQL;
    }

    public ThemeColorInfo cvz() {
        return this.iJM;
    }

    public ArrayList<Integer> cvA() {
        if (this.iJM == null || this.iJM.day == null || this.iJM.night == null || this.iJM.dark == null) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.c.b.rT(this.iJM.day.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.c.b.rT(this.iJM.day.dark_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.c.b.rT(this.iJM.night.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.c.b.rT(this.iJM.night.dark_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.c.b.rT(this.iJM.dark.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.c.b.rT(this.iJM.dark.dark_color)));
        return arrayList;
    }

    public boolean bAR() {
        return this.iJN;
    }

    public void a(LikeForum likeForum) {
        if (likeForum != null) {
            a(likeForum, (Context) null);
        }
    }

    public boolean cvB() {
        return this.iJJ == 1 && this.iJK == 1 && this.eQz != null && this.eQz.private_forum_status.intValue() == 1;
    }

    public boolean cvC() {
        return this.iJJ == 1 && this.iJK == 1 && this.eQz != null && this.eQz.private_forum_status.intValue() == 1 && this.eQz.private_forum_audit_status.intValue() == 2;
    }

    public void a(LikeForum likeForum, Context context) {
        if (likeForum != null) {
            try {
                this.mId = String.valueOf(likeForum.forum_id);
                this.mName = likeForum.forum_name;
                this.iJH = likeForum.is_sign.intValue();
                this.mLevel = likeForum.level_id.intValue();
                this.eQL = likeForum.avatar;
                this.iJJ = likeForum.is_manager.intValue();
                this.iJK = likeForum.is_private_forum.intValue();
                this.eQz = likeForum.private_forum_info;
                this.iJI = likeForum.is_brand_forum.intValue();
                this.mContent = likeForum.content;
                this.iJL = likeForum.is_top.intValue();
                this.sortType = likeForum.sort_type.intValue();
                this.iJM = likeForum.theme_color;
                this.iJN = likeForum.need_trans.booleanValue();
                this.iJO = likeForum.hot_thread_id.longValue();
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

    public long cvD() {
        return this.iJO;
    }

    public void gi(long j) {
        this.iJO = j;
    }

    public ArrayList<FrsTabItemData> cvE() {
        return this.tabItemDatas;
    }
}
