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
    private PrivateForumInfo dZM;
    private int hun;
    private int huo;
    private int hup;
    private int huq;
    private int hur;
    private ThemeColorInfo hus;
    private boolean hut;
    private long huu;
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

    public String ceI() {
        return this.mContent;
    }

    public int ceJ() {
        return this.hur;
    }

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void vU(int i) {
        this.hun = i;
    }

    public int ceK() {
        return this.hun;
    }

    public int ceL() {
        return this.hup;
    }

    public int isPrivateForum() {
        return this.huq;
    }

    public int ceM() {
        return this.huo;
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

    public ThemeColorInfo ceN() {
        return this.hus;
    }

    public ArrayList<Integer> ceO() {
        if (this.hus == null || this.hus.day == null || this.hus.night == null || this.hus.dark == null) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.b.fo(this.hus.day.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.b.fo(this.hus.day.dark_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.b.fo(this.hus.night.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.b.fo(this.hus.night.dark_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.b.fo(this.hus.dark.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.b.fo(this.hus.dark.dark_color)));
        return arrayList;
    }

    public boolean bri() {
        return this.hut;
    }

    public void a(LikeForum likeForum) {
        if (likeForum != null) {
            a(likeForum, (Context) null);
        }
    }

    public boolean ceP() {
        return this.hup == 1 && this.huq == 1 && this.dZM != null && this.dZM.private_forum_status.intValue() == 1;
    }

    public boolean ceQ() {
        return this.hup == 1 && this.huq == 1 && this.dZM != null && this.dZM.private_forum_status.intValue() == 1 && this.dZM.private_forum_audit_status.intValue() == 2;
    }

    public void a(LikeForum likeForum, Context context) {
        if (likeForum != null) {
            try {
                this.mId = String.valueOf(likeForum.forum_id);
                this.mName = likeForum.forum_name;
                this.hun = likeForum.is_sign.intValue();
                this.mLevel = likeForum.level_id.intValue();
                this.mAvatar = likeForum.avatar;
                this.hup = likeForum.is_manager.intValue();
                this.huq = likeForum.is_private_forum.intValue();
                this.dZM = likeForum.private_forum_info;
                this.huo = likeForum.is_brand_forum.intValue();
                this.mContent = likeForum.content;
                this.hur = likeForum.is_top.intValue();
                this.sortType = likeForum.sort_type.intValue();
                this.hus = likeForum.theme_color;
                this.hut = likeForum.need_trans.booleanValue();
                this.huu = likeForum.hot_thread_id.longValue();
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

    public long ceR() {
        return this.huu;
    }

    public void ey(long j) {
        this.huu = j;
    }

    public ArrayList<FrsTabItemData> ceS() {
        return this.tabItemDatas;
    }
}
