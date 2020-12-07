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
    private int ius;
    private int iut;
    private int iuu;
    private int iuv;
    private int iuw;
    private ThemeColorInfo iux;
    private boolean iuy;
    private long iuz;
    private String mContent;
    private String mId;
    private String mName;
    private int sortType;
    private ArrayList<FrsTabItemData> tabItemDatas;

    public f() {
        on(1);
    }

    public String cuS() {
        return this.mContent;
    }

    public int cuT() {
        return this.iuw;
    }

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void yI(int i) {
        this.ius = i;
    }

    public int cuU() {
        return this.ius;
    }

    public int cuV() {
        return this.iuu;
    }

    public int isPrivateForum() {
        return this.iuv;
    }

    public int cuW() {
        return this.iut;
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

    public ThemeColorInfo cuX() {
        return this.iux;
    }

    public ArrayList<Integer> cuY() {
        if (this.iux == null || this.iux.day == null || this.iux.night == null || this.iux.dark == null) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.b.sI(this.iux.day.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.b.sI(this.iux.day.dark_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.b.sI(this.iux.night.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.b.sI(this.iux.night.dark_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.b.sI(this.iux.dark.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.b.sI(this.iux.dark.dark_color)));
        return arrayList;
    }

    public boolean bBU() {
        return this.iuy;
    }

    public void a(LikeForum likeForum) {
        if (likeForum != null) {
            a(likeForum, (Context) null);
        }
    }

    public boolean cuZ() {
        return this.iuu == 1 && this.iuv == 1 && this.eHG != null && this.eHG.private_forum_status.intValue() == 1;
    }

    public boolean cva() {
        return this.iuu == 1 && this.iuv == 1 && this.eHG != null && this.eHG.private_forum_status.intValue() == 1 && this.eHG.private_forum_audit_status.intValue() == 2;
    }

    public void a(LikeForum likeForum, Context context) {
        if (likeForum != null) {
            try {
                this.mId = String.valueOf(likeForum.forum_id);
                this.mName = likeForum.forum_name;
                this.ius = likeForum.is_sign.intValue();
                this.fth = likeForum.level_id.intValue();
                this.eHR = likeForum.avatar;
                this.iuu = likeForum.is_manager.intValue();
                this.iuv = likeForum.is_private_forum.intValue();
                this.eHG = likeForum.private_forum_info;
                this.iut = likeForum.is_brand_forum.intValue();
                this.mContent = likeForum.content;
                this.iuw = likeForum.is_top.intValue();
                this.sortType = likeForum.sort_type.intValue();
                this.iux = likeForum.theme_color;
                this.iuy = likeForum.need_trans.booleanValue();
                this.iuz = likeForum.hot_thread_id.longValue();
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

    public long cvb() {
        return this.iuz;
    }

    public void gd(long j) {
        this.iuz = j;
    }

    public ArrayList<FrsTabItemData> cvc() {
        return this.tabItemDatas;
    }
}
