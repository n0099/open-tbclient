package com.baidu.tieba.enterForum.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.u;
import com.baidu.tieba.frs.FrsTabItemData;
import java.util.ArrayList;
import tbclient.ForumRecommend.LikeForum;
import tbclient.FrsTabInfo;
import tbclient.PrivateForumInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes21.dex */
public class f extends u implements com.baidu.tbadk.mvc.b.a {
    private PrivateForumInfo ebW;
    private int hBs;
    private int hBt;
    private int hBu;
    private int hBv;
    private int hBw;
    private ThemeColorInfo hBx;
    private boolean hBy;
    private long hBz;
    private String mAvatar;
    private String mContent;
    private String mId;
    private int mLevel;
    private String mName;
    private int sortType;
    private ArrayList<FrsTabItemData> tabItemDatas;

    public f() {
        nb(1);
    }

    public String chX() {
        return this.mContent;
    }

    public int chY() {
        return this.hBw;
    }

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void wt(int i) {
        this.hBs = i;
    }

    public int chZ() {
        return this.hBs;
    }

    public int cia() {
        return this.hBu;
    }

    public int isPrivateForum() {
        return this.hBv;
    }

    public int cib() {
        return this.hBt;
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

    public ThemeColorInfo cic() {
        return this.hBx;
    }

    public ArrayList<Integer> cid() {
        if (this.hBx == null || this.hBx.day == null || this.hBx.night == null || this.hBx.dark == null) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.b.fq(this.hBx.day.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.b.fq(this.hBx.day.dark_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.b.fq(this.hBx.night.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.b.fq(this.hBx.night.dark_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.b.fq(this.hBx.dark.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.b.fq(this.hBx.dark.dark_color)));
        return arrayList;
    }

    public boolean bsc() {
        return this.hBy;
    }

    public void a(LikeForum likeForum) {
        if (likeForum != null) {
            a(likeForum, (Context) null);
        }
    }

    public boolean cie() {
        return this.hBu == 1 && this.hBv == 1 && this.ebW != null && this.ebW.private_forum_status.intValue() == 1;
    }

    public boolean cif() {
        return this.hBu == 1 && this.hBv == 1 && this.ebW != null && this.ebW.private_forum_status.intValue() == 1 && this.ebW.private_forum_audit_status.intValue() == 2;
    }

    public void a(LikeForum likeForum, Context context) {
        if (likeForum != null) {
            try {
                this.mId = String.valueOf(likeForum.forum_id);
                this.mName = likeForum.forum_name;
                this.hBs = likeForum.is_sign.intValue();
                this.mLevel = likeForum.level_id.intValue();
                this.mAvatar = likeForum.avatar;
                this.hBu = likeForum.is_manager.intValue();
                this.hBv = likeForum.is_private_forum.intValue();
                this.ebW = likeForum.private_forum_info;
                this.hBt = likeForum.is_brand_forum.intValue();
                this.mContent = likeForum.content;
                this.hBw = likeForum.is_top.intValue();
                this.sortType = likeForum.sort_type.intValue();
                this.hBx = likeForum.theme_color;
                this.hBy = likeForum.need_trans.booleanValue();
                this.hBz = likeForum.hot_thread_id.longValue();
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

    public long cig() {
        return this.hBz;
    }

    public void eI(long j) {
        this.hBz = j;
    }

    public ArrayList<FrsTabItemData> cih() {
        return this.tabItemDatas;
    }
}
