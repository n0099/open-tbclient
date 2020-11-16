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
/* loaded from: classes21.dex */
public class f extends v implements com.baidu.tbadk.mvc.b.a {
    private PrivateForumInfo eAH;
    private int ijA;
    private int ijB;
    private int ijC;
    private int ijD;
    private ThemeColorInfo ijE;
    private boolean ijF;
    private long ijG;
    private int ijz;
    private String mAvatar;
    private String mContent;
    private String mId;
    private int mLevel;
    private String mName;
    private int sortType;
    private ArrayList<FrsTabItemData> tabItemDatas;

    public f() {
        nP(1);
    }

    public String cqE() {
        return this.mContent;
    }

    public int cqF() {
        return this.ijD;
    }

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void yd(int i) {
        this.ijz = i;
    }

    public int cqG() {
        return this.ijz;
    }

    public int cqH() {
        return this.ijB;
    }

    public int isPrivateForum() {
        return this.ijC;
    }

    public int cqI() {
        return this.ijA;
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

    public ThemeColorInfo cqJ() {
        return this.ijE;
    }

    public ArrayList<Integer> cqK() {
        if (this.ijE == null || this.ijE.day == null || this.ijE.night == null || this.ijE.dark == null) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.b.sa(this.ijE.day.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.b.sa(this.ijE.day.dark_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.b.sa(this.ijE.night.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.b.sa(this.ijE.night.dark_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.b.sa(this.ijE.dark.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.b.sa(this.ijE.dark.dark_color)));
        return arrayList;
    }

    public boolean byu() {
        return this.ijF;
    }

    public void a(LikeForum likeForum) {
        if (likeForum != null) {
            a(likeForum, (Context) null);
        }
    }

    public boolean cqL() {
        return this.ijB == 1 && this.ijC == 1 && this.eAH != null && this.eAH.private_forum_status.intValue() == 1;
    }

    public boolean cqM() {
        return this.ijB == 1 && this.ijC == 1 && this.eAH != null && this.eAH.private_forum_status.intValue() == 1 && this.eAH.private_forum_audit_status.intValue() == 2;
    }

    public void a(LikeForum likeForum, Context context) {
        if (likeForum != null) {
            try {
                this.mId = String.valueOf(likeForum.forum_id);
                this.mName = likeForum.forum_name;
                this.ijz = likeForum.is_sign.intValue();
                this.mLevel = likeForum.level_id.intValue();
                this.mAvatar = likeForum.avatar;
                this.ijB = likeForum.is_manager.intValue();
                this.ijC = likeForum.is_private_forum.intValue();
                this.eAH = likeForum.private_forum_info;
                this.ijA = likeForum.is_brand_forum.intValue();
                this.mContent = likeForum.content;
                this.ijD = likeForum.is_top.intValue();
                this.sortType = likeForum.sort_type.intValue();
                this.ijE = likeForum.theme_color;
                this.ijF = likeForum.need_trans.booleanValue();
                this.ijG = likeForum.hot_thread_id.longValue();
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

    public long cqN() {
        return this.ijG;
    }

    public void fz(long j) {
        this.ijG = j;
    }

    public ArrayList<FrsTabItemData> cqO() {
        return this.tabItemDatas;
    }
}
