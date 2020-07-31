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
/* loaded from: classes16.dex */
public class f extends t implements com.baidu.tbadk.mvc.b.a {
    private PrivateForumInfo dQp;
    private int hho;
    private int hhp;
    private int hhq;
    private int hhr;
    private int hhs;
    private ThemeColorInfo hht;
    private boolean hhu;
    private long hhv;
    private String mAvatar;
    private String mContent;
    private String mId;
    private int mLevel;
    private String mName;
    private int sortType;
    private ArrayList<FrsTabItemData> tabItemDatas;

    public f() {
        kK(1);
    }

    public String bUw() {
        return this.mContent;
    }

    public int bUx() {
        return this.hhs;
    }

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void tF(int i) {
        this.hho = i;
    }

    public int bUy() {
        return this.hho;
    }

    public int bUz() {
        return this.hhq;
    }

    public int isPrivateForum() {
        return this.hhr;
    }

    public int bUA() {
        return this.hhp;
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

    public ThemeColorInfo bUB() {
        return this.hht;
    }

    public ArrayList<Integer> bUC() {
        if (this.hht == null || this.hht.day == null || this.hht.night == null || this.hht.dark == null) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.dU(this.hht.day.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.dU(this.hht.day.dark_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.dU(this.hht.night.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.dU(this.hht.night.dark_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.dU(this.hht.dark.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.dU(this.hht.dark.dark_color)));
        return arrayList;
    }

    public boolean biv() {
        return this.hhu;
    }

    public void a(LikeForum likeForum) {
        if (likeForum != null) {
            a(likeForum, (Context) null);
        }
    }

    public boolean bUD() {
        return this.hhq == 1 && this.hhr == 1 && this.dQp != null && this.dQp.private_forum_status.intValue() == 1;
    }

    public boolean bUE() {
        return this.hhq == 1 && this.hhr == 1 && this.dQp != null && this.dQp.private_forum_status.intValue() == 1 && this.dQp.private_forum_audit_status.intValue() == 2;
    }

    public void a(LikeForum likeForum, Context context) {
        if (likeForum != null) {
            try {
                this.mId = String.valueOf(likeForum.forum_id);
                this.mName = likeForum.forum_name;
                this.hho = likeForum.is_sign.intValue();
                this.mLevel = likeForum.level_id.intValue();
                this.mAvatar = likeForum.avatar;
                this.hhq = likeForum.is_manager.intValue();
                this.hhr = likeForum.is_private_forum.intValue();
                this.dQp = likeForum.private_forum_info;
                this.hhp = likeForum.is_brand_forum.intValue();
                this.mContent = likeForum.content;
                this.hhs = likeForum.is_top.intValue();
                this.sortType = likeForum.sort_type.intValue();
                this.hht = likeForum.theme_color;
                this.hhu = likeForum.need_trans.booleanValue();
                this.hhv = likeForum.hot_thread_id.longValue();
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

    public long bUF() {
        return this.hhv;
    }

    public void en(long j) {
        this.hhv = j;
    }

    public ArrayList<FrsTabItemData> bUG() {
        return this.tabItemDatas;
    }
}
