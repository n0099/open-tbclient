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
    private int gOL;
    private int gOM;
    private int gON;
    private int gOO;
    private int gOP;
    private ThemeColorInfo gOQ;
    private boolean gOR;
    private long gOS;
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

    public String bOb() {
        return this.mContent;
    }

    public int bOc() {
        return this.gOP;
    }

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void sK(int i) {
        this.gOL = i;
    }

    public int bOd() {
        return this.gOL;
    }

    public int bOe() {
        return this.gON;
    }

    public int isPrivateForum() {
        return this.gOO;
    }

    public int bOf() {
        return this.gOM;
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

    public ThemeColorInfo bOg() {
        return this.gOQ;
    }

    public ArrayList<Integer> bOh() {
        if (this.gOQ == null || this.gOQ.day == null || this.gOQ.night == null || this.gOQ.dark == null) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.dT(this.gOQ.day.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.dT(this.gOQ.day.dark_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.dT(this.gOQ.night.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.dT(this.gOQ.night.dark_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.dT(this.gOQ.dark.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.dT(this.gOQ.dark.dark_color)));
        return arrayList;
    }

    public boolean bcJ() {
        return this.gOR;
    }

    public void a(LikeForum likeForum) {
        if (likeForum != null) {
            a(likeForum, null);
        }
    }

    public boolean bOi() {
        return this.gON == 1 && this.gOO == 1 && this.dDH != null && this.dDH.private_forum_status.intValue() == 1;
    }

    public boolean bOj() {
        return this.gON == 1 && this.gOO == 1 && this.dDH != null && this.dDH.private_forum_status.intValue() == 1 && this.dDH.private_forum_audit_status.intValue() == 2;
    }

    public void a(LikeForum likeForum, Context context) {
        if (likeForum != null) {
            try {
                this.mId = String.valueOf(likeForum.forum_id);
                this.mName = likeForum.forum_name;
                this.gOL = likeForum.is_sign.intValue();
                this.mLevel = likeForum.level_id.intValue();
                this.mAvatar = likeForum.avatar;
                this.gON = likeForum.is_manager.intValue();
                this.gOO = likeForum.is_private_forum.intValue();
                this.dDH = likeForum.private_forum_info;
                this.gOM = likeForum.is_brand_forum.intValue();
                this.mContent = likeForum.content;
                this.gOP = likeForum.is_top.intValue();
                this.sortType = likeForum.sort_type.intValue();
                this.gOQ = likeForum.theme_color;
                this.gOR = likeForum.need_trans.booleanValue();
                this.gOS = likeForum.hot_thread_id.longValue();
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

    public long bOk() {
        return this.gOS;
    }

    public void dX(long j) {
        this.gOS = j;
    }

    public ArrayList<FrsTabItemData> bOl() {
        return this.tabItemDatas;
    }
}
