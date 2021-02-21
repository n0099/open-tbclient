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
    private int iHY;
    private int iHZ;
    private int iIa;
    private int iIb;
    private int iIc;
    private ThemeColorInfo iId;
    private boolean iIe;
    private long iIf;
    private String mContent;
    private String mId;
    private int mLevel;
    private String mName;
    private int sortType;
    private ArrayList<FrsTabItemData> tabItemDatas;

    public f() {
        mU(1);
    }

    public String cvo() {
        return this.mContent;
    }

    public int cvp() {
        return this.iIc;
    }

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void xz(int i) {
        this.iHY = i;
    }

    public int cvq() {
        return this.iHY;
    }

    public int cvr() {
        return this.iIa;
    }

    public int isPrivateForum() {
        return this.iIb;
    }

    public int cvs() {
        return this.iHZ;
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

    public ThemeColorInfo cvt() {
        return this.iId;
    }

    public ArrayList<Integer> cvu() {
        if (this.iId == null || this.iId.day == null || this.iId.night == null || this.iId.dark == null) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.c.b.rM(this.iId.day.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.c.b.rM(this.iId.day.dark_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.c.b.rM(this.iId.night.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.c.b.rM(this.iId.night.dark_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.c.b.rM(this.iId.dark.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.c.b.rM(this.iId.dark.dark_color)));
        return arrayList;
    }

    public boolean bAO() {
        return this.iIe;
    }

    public void a(LikeForum likeForum) {
        if (likeForum != null) {
            a(likeForum, (Context) null);
        }
    }

    public boolean cvv() {
        return this.iIa == 1 && this.iIb == 1 && this.eOY != null && this.eOY.private_forum_status.intValue() == 1;
    }

    public boolean cvw() {
        return this.iIa == 1 && this.iIb == 1 && this.eOY != null && this.eOY.private_forum_status.intValue() == 1 && this.eOY.private_forum_audit_status.intValue() == 2;
    }

    public void a(LikeForum likeForum, Context context) {
        if (likeForum != null) {
            try {
                this.mId = String.valueOf(likeForum.forum_id);
                this.mName = likeForum.forum_name;
                this.iHY = likeForum.is_sign.intValue();
                this.mLevel = likeForum.level_id.intValue();
                this.ePk = likeForum.avatar;
                this.iIa = likeForum.is_manager.intValue();
                this.iIb = likeForum.is_private_forum.intValue();
                this.eOY = likeForum.private_forum_info;
                this.iHZ = likeForum.is_brand_forum.intValue();
                this.mContent = likeForum.content;
                this.iIc = likeForum.is_top.intValue();
                this.sortType = likeForum.sort_type.intValue();
                this.iId = likeForum.theme_color;
                this.iIe = likeForum.need_trans.booleanValue();
                this.iIf = likeForum.hot_thread_id.longValue();
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

    public long cvx() {
        return this.iIf;
    }

    public void gi(long j) {
        this.iIf = j;
    }

    public ArrayList<FrsTabItemData> cvy() {
        return this.tabItemDatas;
    }
}
