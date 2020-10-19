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
    private PrivateForumInfo eoa;
    private int hQn;
    private int hQo;
    private int hQp;
    private int hQq;
    private int hQr;
    private ThemeColorInfo hQs;
    private boolean hQt;
    private long hQu;
    private String mAvatar;
    private String mContent;
    private String mId;
    private int mLevel;
    private String mName;
    private int sortType;
    private ArrayList<FrsTabItemData> tabItemDatas;

    public f() {
        ny(1);
    }

    public String clt() {
        return this.mContent;
    }

    public int clu() {
        return this.hQr;
    }

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void wZ(int i) {
        this.hQn = i;
    }

    public int clv() {
        return this.hQn;
    }

    public int clw() {
        return this.hQp;
    }

    public int isPrivateForum() {
        return this.hQq;
    }

    public int clx() {
        return this.hQo;
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

    public ThemeColorInfo cly() {
        return this.hQs;
    }

    public ArrayList<Integer> clz() {
        if (this.hQs == null || this.hQs.day == null || this.hQs.night == null || this.hQs.dark == null) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.b.fv(this.hQs.day.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.b.fv(this.hQs.day.dark_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.b.fv(this.hQs.night.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.b.fv(this.hQs.night.dark_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.b.fv(this.hQs.dark.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.b.fv(this.hQs.dark.dark_color)));
        return arrayList;
    }

    public boolean buM() {
        return this.hQt;
    }

    public void a(LikeForum likeForum) {
        if (likeForum != null) {
            a(likeForum, (Context) null);
        }
    }

    public boolean clA() {
        return this.hQp == 1 && this.hQq == 1 && this.eoa != null && this.eoa.private_forum_status.intValue() == 1;
    }

    public boolean clB() {
        return this.hQp == 1 && this.hQq == 1 && this.eoa != null && this.eoa.private_forum_status.intValue() == 1 && this.eoa.private_forum_audit_status.intValue() == 2;
    }

    public void a(LikeForum likeForum, Context context) {
        if (likeForum != null) {
            try {
                this.mId = String.valueOf(likeForum.forum_id);
                this.mName = likeForum.forum_name;
                this.hQn = likeForum.is_sign.intValue();
                this.mLevel = likeForum.level_id.intValue();
                this.mAvatar = likeForum.avatar;
                this.hQp = likeForum.is_manager.intValue();
                this.hQq = likeForum.is_private_forum.intValue();
                this.eoa = likeForum.private_forum_info;
                this.hQo = likeForum.is_brand_forum.intValue();
                this.mContent = likeForum.content;
                this.hQr = likeForum.is_top.intValue();
                this.sortType = likeForum.sort_type.intValue();
                this.hQs = likeForum.theme_color;
                this.hQt = likeForum.need_trans.booleanValue();
                this.hQu = likeForum.hot_thread_id.longValue();
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

    public long clC() {
        return this.hQu;
    }

    public void eZ(long j) {
        this.hQu = j;
    }

    public ArrayList<FrsTabItemData> clD() {
        return this.tabItemDatas;
    }
}
