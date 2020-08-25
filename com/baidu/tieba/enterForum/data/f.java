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
/* loaded from: classes16.dex */
public class f extends u implements com.baidu.tbadk.mvc.b.a {
    private PrivateForumInfo dZI;
    private int huh;
    private int hui;
    private int huj;
    private int huk;
    private int hul;
    private ThemeColorInfo hum;
    private boolean hun;
    private long huo;
    private String mAvatar;
    private String mContent;
    private String mId;
    private int mLevel;
    private String mName;
    private int sortType;
    private ArrayList<FrsTabItemData> tabItemDatas;

    public f() {
        mQ(1);
    }

    public String ceH() {
        return this.mContent;
    }

    public int ceI() {
        return this.hul;
    }

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void vU(int i) {
        this.huh = i;
    }

    public int ceJ() {
        return this.huh;
    }

    public int ceK() {
        return this.huj;
    }

    public int isPrivateForum() {
        return this.huk;
    }

    public int ceL() {
        return this.hui;
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

    public ThemeColorInfo ceM() {
        return this.hum;
    }

    public ArrayList<Integer> ceN() {
        if (this.hum == null || this.hum.day == null || this.hum.night == null || this.hum.dark == null) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.b.fn(this.hum.day.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.b.fn(this.hum.day.dark_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.b.fn(this.hum.night.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.b.fn(this.hum.night.dark_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.b.fn(this.hum.dark.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.b.fn(this.hum.dark.dark_color)));
        return arrayList;
    }

    public boolean brh() {
        return this.hun;
    }

    public void a(LikeForum likeForum) {
        if (likeForum != null) {
            a(likeForum, (Context) null);
        }
    }

    public boolean ceO() {
        return this.huj == 1 && this.huk == 1 && this.dZI != null && this.dZI.private_forum_status.intValue() == 1;
    }

    public boolean ceP() {
        return this.huj == 1 && this.huk == 1 && this.dZI != null && this.dZI.private_forum_status.intValue() == 1 && this.dZI.private_forum_audit_status.intValue() == 2;
    }

    public void a(LikeForum likeForum, Context context) {
        if (likeForum != null) {
            try {
                this.mId = String.valueOf(likeForum.forum_id);
                this.mName = likeForum.forum_name;
                this.huh = likeForum.is_sign.intValue();
                this.mLevel = likeForum.level_id.intValue();
                this.mAvatar = likeForum.avatar;
                this.huj = likeForum.is_manager.intValue();
                this.huk = likeForum.is_private_forum.intValue();
                this.dZI = likeForum.private_forum_info;
                this.hui = likeForum.is_brand_forum.intValue();
                this.mContent = likeForum.content;
                this.hul = likeForum.is_top.intValue();
                this.sortType = likeForum.sort_type.intValue();
                this.hum = likeForum.theme_color;
                this.hun = likeForum.need_trans.booleanValue();
                this.huo = likeForum.hot_thread_id.longValue();
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

    public long ceQ() {
        return this.huo;
    }

    public void ey(long j) {
        this.huo = j;
    }

    public ArrayList<FrsTabItemData> ceR() {
        return this.tabItemDatas;
    }
}
