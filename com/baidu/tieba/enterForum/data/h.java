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
    private PrivateForumInfo dpI;
    private int gAb;
    private int gAc;
    private int gAd;
    private int gAe;
    private int gAf;
    private ThemeColorInfo gAg;
    private boolean gAh;
    private long gAi;
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

    public String bHH() {
        return this.mContent;
    }

    public int bHI() {
        return this.gAf;
    }

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void sf(int i) {
        this.gAb = i;
    }

    public int bHJ() {
        return this.gAb;
    }

    public int bHK() {
        return this.gAd;
    }

    public int isPrivateForum() {
        return this.gAe;
    }

    public int bHL() {
        return this.gAc;
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

    public ThemeColorInfo bHM() {
        return this.gAg;
    }

    public ArrayList<Integer> bHN() {
        if (this.gAg == null || this.gAg.day == null || this.gAg.night == null || this.gAg.dark == null) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.dA(this.gAg.day.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.dA(this.gAg.day.dark_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.dA(this.gAg.night.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.dA(this.gAg.night.dark_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.dA(this.gAg.dark.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.dA(this.gAg.dark.dark_color)));
        return arrayList;
    }

    public boolean aWA() {
        return this.gAh;
    }

    public void a(LikeForum likeForum) {
        if (likeForum != null) {
            a(likeForum, null);
        }
    }

    public boolean bHO() {
        return this.gAd == 1 && this.gAe == 1 && this.dpI != null && this.dpI.private_forum_status.intValue() == 1;
    }

    public boolean bHP() {
        return this.gAd == 1 && this.gAe == 1 && this.dpI != null && this.dpI.private_forum_status.intValue() == 1 && this.dpI.private_forum_audit_status.intValue() == 2;
    }

    public void a(LikeForum likeForum, Context context) {
        if (likeForum != null) {
            try {
                this.mId = String.valueOf(likeForum.forum_id);
                this.mName = likeForum.forum_name;
                this.gAb = likeForum.is_sign.intValue();
                this.mLevel = likeForum.level_id.intValue();
                this.mAvatar = likeForum.avatar;
                this.gAd = likeForum.is_manager.intValue();
                this.gAe = likeForum.is_private_forum.intValue();
                this.dpI = likeForum.private_forum_info;
                this.gAc = likeForum.is_brand_forum.intValue();
                this.mContent = likeForum.content;
                this.gAf = likeForum.is_top.intValue();
                this.sortType = likeForum.sort_type.intValue();
                this.gAg = likeForum.theme_color;
                this.gAh = likeForum.need_trans.booleanValue();
                this.gAi = likeForum.hot_thread_id.longValue();
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

    public long bHQ() {
        return this.gAi;
    }

    public void dW(long j) {
        this.gAi = j;
    }

    public ArrayList<FrsTabItemData> bHR() {
        return this.tabItemDatas;
    }
}
