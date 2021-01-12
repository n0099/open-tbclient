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
    private PrivateForumInfo eMM;
    private String eMY;
    private int fyf;
    private int iCa;
    private int iCb;
    private int iCc;
    private int iCd;
    private int iCe;
    private ThemeColorInfo iCf;
    private boolean iCg;
    private long iCh;
    private String mContent;
    private String mId;
    private String mName;
    private int sortType;
    private ArrayList<FrsTabItemData> tabItemDatas;

    public f() {
        mR(1);
    }

    public String ctV() {
        return this.mContent;
    }

    public int ctW() {
        return this.iCe;
    }

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void xp(int i) {
        this.iCa = i;
    }

    public int ctX() {
        return this.iCa;
    }

    public int ctY() {
        return this.iCc;
    }

    public int isPrivateForum() {
        return this.iCd;
    }

    public int ctZ() {
        return this.iCb;
    }

    public void setLevel(int i) {
        this.fyf = i;
    }

    public int getLevel() {
        return this.fyf;
    }

    public String getAvatar() {
        return this.eMY;
    }

    public ThemeColorInfo cua() {
        return this.iCf;
    }

    public ArrayList<Integer> cub() {
        if (this.iCf == null || this.iCf.day == null || this.iCf.night == null || this.iCf.dark == null) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.c.b.rt(this.iCf.day.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.c.b.rt(this.iCf.day.dark_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.c.b.rt(this.iCf.night.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.c.b.rt(this.iCf.night.dark_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.c.b.rt(this.iCf.dark.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.c.b.rt(this.iCf.dark.dark_color)));
        return arrayList;
    }

    public boolean bAw() {
        return this.iCg;
    }

    public void a(LikeForum likeForum) {
        if (likeForum != null) {
            a(likeForum, (Context) null);
        }
    }

    public boolean cuc() {
        return this.iCc == 1 && this.iCd == 1 && this.eMM != null && this.eMM.private_forum_status.intValue() == 1;
    }

    public boolean cud() {
        return this.iCc == 1 && this.iCd == 1 && this.eMM != null && this.eMM.private_forum_status.intValue() == 1 && this.eMM.private_forum_audit_status.intValue() == 2;
    }

    public void a(LikeForum likeForum, Context context) {
        if (likeForum != null) {
            try {
                this.mId = String.valueOf(likeForum.forum_id);
                this.mName = likeForum.forum_name;
                this.iCa = likeForum.is_sign.intValue();
                this.fyf = likeForum.level_id.intValue();
                this.eMY = likeForum.avatar;
                this.iCc = likeForum.is_manager.intValue();
                this.iCd = likeForum.is_private_forum.intValue();
                this.eMM = likeForum.private_forum_info;
                this.iCb = likeForum.is_brand_forum.intValue();
                this.mContent = likeForum.content;
                this.iCe = likeForum.is_top.intValue();
                this.sortType = likeForum.sort_type.intValue();
                this.iCf = likeForum.theme_color;
                this.iCg = likeForum.need_trans.booleanValue();
                this.iCh = likeForum.hot_thread_id.longValue();
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

    public long cue() {
        return this.iCh;
    }

    public void gd(long j) {
        this.iCh = j;
    }

    public ArrayList<FrsTabItemData> cuf() {
        return this.tabItemDatas;
    }
}
