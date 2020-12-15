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
/* loaded from: classes22.dex */
public class f extends v implements com.baidu.tbadk.mvc.b.a {
    private PrivateForumInfo eHG;
    private String eHR;
    private int fth;
    private boolean iuA;
    private long iuB;
    private int iuu;
    private int iuv;
    private int iuw;
    private int iux;
    private int iuy;
    private ThemeColorInfo iuz;
    private String mContent;
    private String mId;
    private String mName;
    private int sortType;
    private ArrayList<FrsTabItemData> tabItemDatas;

    public f() {
        on(1);
    }

    public String cuT() {
        return this.mContent;
    }

    public int cuU() {
        return this.iuy;
    }

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void yI(int i) {
        this.iuu = i;
    }

    public int cuV() {
        return this.iuu;
    }

    public int cuW() {
        return this.iuw;
    }

    public int isPrivateForum() {
        return this.iux;
    }

    public int cuX() {
        return this.iuv;
    }

    public void setLevel(int i) {
        this.fth = i;
    }

    public int getLevel() {
        return this.fth;
    }

    public String getAvatar() {
        return this.eHR;
    }

    public ThemeColorInfo cuY() {
        return this.iuz;
    }

    public ArrayList<Integer> cuZ() {
        if (this.iuz == null || this.iuz.day == null || this.iuz.night == null || this.iuz.dark == null) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.b.sI(this.iuz.day.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.b.sI(this.iuz.day.dark_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.b.sI(this.iuz.night.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.b.sI(this.iuz.night.dark_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.b.sI(this.iuz.dark.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.b.sI(this.iuz.dark.dark_color)));
        return arrayList;
    }

    public boolean bBU() {
        return this.iuA;
    }

    public void a(LikeForum likeForum) {
        if (likeForum != null) {
            a(likeForum, (Context) null);
        }
    }

    public boolean cva() {
        return this.iuw == 1 && this.iux == 1 && this.eHG != null && this.eHG.private_forum_status.intValue() == 1;
    }

    public boolean cvb() {
        return this.iuw == 1 && this.iux == 1 && this.eHG != null && this.eHG.private_forum_status.intValue() == 1 && this.eHG.private_forum_audit_status.intValue() == 2;
    }

    public void a(LikeForum likeForum, Context context) {
        if (likeForum != null) {
            try {
                this.mId = String.valueOf(likeForum.forum_id);
                this.mName = likeForum.forum_name;
                this.iuu = likeForum.is_sign.intValue();
                this.fth = likeForum.level_id.intValue();
                this.eHR = likeForum.avatar;
                this.iuw = likeForum.is_manager.intValue();
                this.iux = likeForum.is_private_forum.intValue();
                this.eHG = likeForum.private_forum_info;
                this.iuv = likeForum.is_brand_forum.intValue();
                this.mContent = likeForum.content;
                this.iuy = likeForum.is_top.intValue();
                this.sortType = likeForum.sort_type.intValue();
                this.iuz = likeForum.theme_color;
                this.iuA = likeForum.need_trans.booleanValue();
                this.iuB = likeForum.hot_thread_id.longValue();
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

    public long cvc() {
        return this.iuB;
    }

    public void gd(long j) {
        this.iuB = j;
    }

    public ArrayList<FrsTabItemData> cvd() {
        return this.tabItemDatas;
    }
}
