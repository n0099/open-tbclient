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
public class f extends d implements com.baidu.tbadk.mvc.b.a {
    private PrivateForumInfo cQy;
    private int fVf;
    private int fVg;
    private int fVh;
    private int fVi;
    private int fVj;
    private ThemeColorInfo fVk;
    private boolean fVl;
    private long fVm;
    private String mAvatar;
    private String mContent;
    private String mId;
    private int mLevel;
    private String mName;
    private int sortType;
    private ArrayList<FrsTabItemData> tabItemDatas;

    public f() {
        setType(1);
    }

    public String bxV() {
        return this.mContent;
    }

    public int bxW() {
        return this.fVj;
    }

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void rO(int i) {
        this.fVf = i;
    }

    public int bxX() {
        return this.fVf;
    }

    public int bxY() {
        return this.fVh;
    }

    public int isPrivateForum() {
        return this.fVi;
    }

    public int bxZ() {
        return this.fVg;
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

    public ThemeColorInfo bya() {
        return this.fVk;
    }

    public ArrayList<Integer> byb() {
        if (this.fVk == null || this.fVk.day == null || this.fVk.night == null || this.fVk.dark == null) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.cF(this.fVk.day.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.cF(this.fVk.day.dark_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.cF(this.fVk.night.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.cF(this.fVk.night.dark_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.cF(this.fVk.dark.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.cF(this.fVk.dark.dark_color)));
        return arrayList;
    }

    public boolean aOl() {
        return this.fVl;
    }

    public void a(LikeForum likeForum) {
        if (likeForum != null) {
            a(likeForum, null);
        }
    }

    public boolean byc() {
        return this.fVh == 1 && this.fVi == 1 && this.cQy != null && this.cQy.private_forum_status.intValue() == 1;
    }

    public boolean byd() {
        return this.fVh == 1 && this.fVi == 1 && this.cQy != null && this.cQy.private_forum_status.intValue() == 1 && this.cQy.private_forum_audit_status.intValue() == 2;
    }

    public void a(LikeForum likeForum, Context context) {
        if (likeForum != null) {
            try {
                this.mId = String.valueOf(likeForum.forum_id);
                this.mName = likeForum.forum_name;
                this.fVf = likeForum.is_sign.intValue();
                this.mLevel = likeForum.level_id.intValue();
                this.mAvatar = likeForum.avatar;
                this.fVh = likeForum.is_manager.intValue();
                this.fVi = likeForum.is_private_forum.intValue();
                this.cQy = likeForum.private_forum_info;
                this.fVg = likeForum.is_brand_forum.intValue();
                this.mContent = likeForum.content;
                this.fVj = likeForum.is_top.intValue();
                this.sortType = likeForum.sort_type.intValue();
                this.fVk = likeForum.theme_color;
                this.fVl = likeForum.need_trans.booleanValue();
                this.fVm = likeForum.hot_thread_id.longValue();
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

    public long bye() {
        return this.fVm;
    }

    /* renamed from: do  reason: not valid java name */
    public void m31do(long j) {
        this.fVm = j;
    }

    public ArrayList<FrsTabItemData> byf() {
        return this.tabItemDatas;
    }
}
