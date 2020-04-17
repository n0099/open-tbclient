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
    private PrivateForumInfo dpE;
    private ThemeColorInfo gAa;
    private boolean gAb;
    private long gAc;
    private int gzV;
    private int gzW;
    private int gzX;
    private int gzY;
    private int gzZ;
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

    public String bHJ() {
        return this.mContent;
    }

    public int bHK() {
        return this.gzZ;
    }

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void sf(int i) {
        this.gzV = i;
    }

    public int bHL() {
        return this.gzV;
    }

    public int bHM() {
        return this.gzX;
    }

    public int isPrivateForum() {
        return this.gzY;
    }

    public int bHN() {
        return this.gzW;
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

    public ThemeColorInfo bHO() {
        return this.gAa;
    }

    public ArrayList<Integer> bHP() {
        if (this.gAa == null || this.gAa.day == null || this.gAa.night == null || this.gAa.dark == null) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.dA(this.gAa.day.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.dA(this.gAa.day.dark_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.dA(this.gAa.night.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.dA(this.gAa.night.dark_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.dA(this.gAa.dark.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.dA(this.gAa.dark.dark_color)));
        return arrayList;
    }

    public boolean aWC() {
        return this.gAb;
    }

    public void a(LikeForum likeForum) {
        if (likeForum != null) {
            a(likeForum, null);
        }
    }

    public boolean bHQ() {
        return this.gzX == 1 && this.gzY == 1 && this.dpE != null && this.dpE.private_forum_status.intValue() == 1;
    }

    public boolean bHR() {
        return this.gzX == 1 && this.gzY == 1 && this.dpE != null && this.dpE.private_forum_status.intValue() == 1 && this.dpE.private_forum_audit_status.intValue() == 2;
    }

    public void a(LikeForum likeForum, Context context) {
        if (likeForum != null) {
            try {
                this.mId = String.valueOf(likeForum.forum_id);
                this.mName = likeForum.forum_name;
                this.gzV = likeForum.is_sign.intValue();
                this.mLevel = likeForum.level_id.intValue();
                this.mAvatar = likeForum.avatar;
                this.gzX = likeForum.is_manager.intValue();
                this.gzY = likeForum.is_private_forum.intValue();
                this.dpE = likeForum.private_forum_info;
                this.gzW = likeForum.is_brand_forum.intValue();
                this.mContent = likeForum.content;
                this.gzZ = likeForum.is_top.intValue();
                this.sortType = likeForum.sort_type.intValue();
                this.gAa = likeForum.theme_color;
                this.gAb = likeForum.need_trans.booleanValue();
                this.gAc = likeForum.hot_thread_id.longValue();
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

    public long bHS() {
        return this.gAc;
    }

    public void dW(long j) {
        this.gAc = j;
    }

    public ArrayList<FrsTabItemData> bHT() {
        return this.tabItemDatas;
    }
}
