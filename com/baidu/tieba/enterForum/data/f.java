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
/* loaded from: classes22.dex */
public class f extends u implements com.baidu.tbadk.mvc.b.a {
    private PrivateForumInfo ewy;
    private int icK;
    private int icL;
    private int icM;
    private int icN;
    private int icO;
    private ThemeColorInfo icP;
    private boolean icQ;
    private long icR;
    private String mAvatar;
    private String mContent;
    private String mId;
    private int mLevel;
    private String mName;
    private int sortType;
    private ArrayList<FrsTabItemData> tabItemDatas;

    public f() {
        nJ(1);
    }

    public String coA() {
        return this.mContent;
    }

    public int coB() {
        return this.icO;
    }

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void xs(int i) {
        this.icK = i;
    }

    public int coC() {
        return this.icK;
    }

    public int coD() {
        return this.icM;
    }

    public int isPrivateForum() {
        return this.icN;
    }

    public int coE() {
        return this.icL;
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

    public ThemeColorInfo coF() {
        return this.icP;
    }

    public ArrayList<Integer> coG() {
        if (this.icP == null || this.icP.day == null || this.icP.night == null || this.icP.dark == null) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.b.fv(this.icP.day.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.b.fv(this.icP.day.dark_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.b.fv(this.icP.night.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.b.fv(this.icP.night.dark_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.b.fv(this.icP.dark.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.b.fv(this.icP.dark.dark_color)));
        return arrayList;
    }

    public boolean bwF() {
        return this.icQ;
    }

    public void a(LikeForum likeForum) {
        if (likeForum != null) {
            a(likeForum, (Context) null);
        }
    }

    public boolean coH() {
        return this.icM == 1 && this.icN == 1 && this.ewy != null && this.ewy.private_forum_status.intValue() == 1;
    }

    public boolean coI() {
        return this.icM == 1 && this.icN == 1 && this.ewy != null && this.ewy.private_forum_status.intValue() == 1 && this.ewy.private_forum_audit_status.intValue() == 2;
    }

    public void a(LikeForum likeForum, Context context) {
        if (likeForum != null) {
            try {
                this.mId = String.valueOf(likeForum.forum_id);
                this.mName = likeForum.forum_name;
                this.icK = likeForum.is_sign.intValue();
                this.mLevel = likeForum.level_id.intValue();
                this.mAvatar = likeForum.avatar;
                this.icM = likeForum.is_manager.intValue();
                this.icN = likeForum.is_private_forum.intValue();
                this.ewy = likeForum.private_forum_info;
                this.icL = likeForum.is_brand_forum.intValue();
                this.mContent = likeForum.content;
                this.icO = likeForum.is_top.intValue();
                this.sortType = likeForum.sort_type.intValue();
                this.icP = likeForum.theme_color;
                this.icQ = likeForum.need_trans.booleanValue();
                this.icR = likeForum.hot_thread_id.longValue();
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

    public long coJ() {
        return this.icR;
    }

    public void fa(long j) {
        this.icR = j;
    }

    public ArrayList<FrsTabItemData> coK() {
        return this.tabItemDatas;
    }
}
