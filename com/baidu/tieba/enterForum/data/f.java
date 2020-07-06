package com.baidu.tieba.enterForum.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.t;
import com.baidu.tieba.frs.FrsTabItemData;
import java.util.ArrayList;
import tbclient.ForumRecommend.LikeForum;
import tbclient.FrsTabInfo;
import tbclient.PrivateForumInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes9.dex */
public class f extends t implements com.baidu.tbadk.mvc.b.a {
    private PrivateForumInfo dKd;
    private int hbI;
    private int hbJ;
    private int hbK;
    private int hbL;
    private int hbM;
    private ThemeColorInfo hbN;
    private boolean hbO;
    private long hbP;
    private String mAvatar;
    private String mContent;
    private String mId;
    private int mLevel;
    private String mName;
    private int sortType;
    private ArrayList<FrsTabItemData> tabItemDatas;

    public f() {
        kq(1);
    }

    public String bRk() {
        return this.mContent;
    }

    public int bRl() {
        return this.hbM;
    }

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void tn(int i) {
        this.hbI = i;
    }

    public int bRm() {
        return this.hbI;
    }

    public int bRn() {
        return this.hbK;
    }

    public int isPrivateForum() {
        return this.hbL;
    }

    public int bRo() {
        return this.hbJ;
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

    public ThemeColorInfo bRp() {
        return this.hbN;
    }

    public ArrayList<Integer> bRq() {
        if (this.hbN == null || this.hbN.day == null || this.hbN.night == null || this.hbN.dark == null) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.dV(this.hbN.day.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.dV(this.hbN.day.dark_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.dV(this.hbN.night.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.dV(this.hbN.night.dark_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.dV(this.hbN.dark.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.dV(this.hbN.dark.dark_color)));
        return arrayList;
    }

    public boolean beM() {
        return this.hbO;
    }

    public void a(LikeForum likeForum) {
        if (likeForum != null) {
            a(likeForum, null);
        }
    }

    public boolean bRr() {
        return this.hbK == 1 && this.hbL == 1 && this.dKd != null && this.dKd.private_forum_status.intValue() == 1;
    }

    public boolean bRs() {
        return this.hbK == 1 && this.hbL == 1 && this.dKd != null && this.dKd.private_forum_status.intValue() == 1 && this.dKd.private_forum_audit_status.intValue() == 2;
    }

    public void a(LikeForum likeForum, Context context) {
        if (likeForum != null) {
            try {
                this.mId = String.valueOf(likeForum.forum_id);
                this.mName = likeForum.forum_name;
                this.hbI = likeForum.is_sign.intValue();
                this.mLevel = likeForum.level_id.intValue();
                this.mAvatar = likeForum.avatar;
                this.hbK = likeForum.is_manager.intValue();
                this.hbL = likeForum.is_private_forum.intValue();
                this.dKd = likeForum.private_forum_info;
                this.hbJ = likeForum.is_brand_forum.intValue();
                this.mContent = likeForum.content;
                this.hbM = likeForum.is_top.intValue();
                this.sortType = likeForum.sort_type.intValue();
                this.hbN = likeForum.theme_color;
                this.hbO = likeForum.need_trans.booleanValue();
                this.hbP = likeForum.hot_thread_id.longValue();
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

    public long bRt() {
        return this.hbP;
    }

    public void ea(long j) {
        this.hbP = j;
    }

    public ArrayList<FrsTabItemData> bRu() {
        return this.tabItemDatas;
    }
}
