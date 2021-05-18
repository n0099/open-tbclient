package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.frs.FrsTabItemData;
import java.util.ArrayList;
import java.util.List;
import tbclient.BlockPopInfo;
import tbclient.FrsTabInfo;
import tbclient.HistoryForumInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes3.dex */
public class VisitedForumData extends OrmObject {

    /* renamed from: e  reason: collision with root package name */
    public String f12814e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f12815f;

    /* renamed from: g  reason: collision with root package name */
    public int f12816g;

    /* renamed from: h  reason: collision with root package name */
    public String f12817h;

    /* renamed from: i  reason: collision with root package name */
    public String f12818i;
    public boolean isForumBusinessAccount;
    public String j;
    public ThemeColorInfo k;
    public int l;
    public boolean m;
    public int n;
    public boolean o;
    public boolean p;
    public String q;
    public List<FrsTabItemData> r;
    public PostPrefixData s;

    public VisitedForumData() {
        this.f12814e = "";
        this.f12815f = false;
        this.f12816g = 0;
        this.f12817h = "";
        this.f12818i = "";
        this.j = "";
        this.k = null;
        this.l = 0;
        this.m = false;
        this.o = false;
        this.p = false;
        this.q = "";
    }

    public String A() {
        return this.j;
    }

    public boolean B() {
        return this.f12815f;
    }

    public boolean C() {
        return this.p;
    }

    public boolean D() {
        return this.o;
    }

    public void E(HistoryForumInfo historyForumInfo) {
        if (historyForumInfo == null) {
            return;
        }
        this.f12814e = historyForumInfo.avatar;
        this.f12818i = String.valueOf(historyForumInfo.forum_id);
        this.f12817h = historyForumInfo.forum_name;
        this.f12815f = historyForumInfo.is_liveforum.intValue() == 1;
        this.f12816g = historyForumInfo.unread_num.intValue();
        this.j = historyForumInfo.visit_time;
        this.k = historyForumInfo.theme_color;
        this.l = historyForumInfo.follow_num.intValue();
        this.m = historyForumInfo.need_trans.booleanValue();
        this.n = historyForumInfo.level_id.intValue();
        BlockPopInfo blockPopInfo = historyForumInfo.block_pop_info;
        if (blockPopInfo != null) {
            this.p = blockPopInfo.can_post.intValue() == 1;
            this.q = historyForumInfo.block_pop_info.block_info;
        }
        if (!ListUtils.isEmpty(historyForumInfo.tab_info)) {
            this.r = new ArrayList();
            for (FrsTabInfo frsTabInfo : historyForumInfo.tab_info) {
                if (frsTabInfo != null) {
                    this.r.add(new FrsTabItemData(frsTabInfo));
                }
            }
        }
        if (historyForumInfo.has_postpre.booleanValue()) {
            PostPrefixData postPrefixData = new PostPrefixData();
            this.s = postPrefixData;
            postPrefixData.parserProtobuf(historyForumInfo.post_prefix);
        }
        this.isForumBusinessAccount = historyForumInfo.is_forum_business_account.intValue() == 1;
    }

    public void F(boolean z) {
        this.o = z;
    }

    public String getForumId() {
        return this.f12818i;
    }

    public String getForumName() {
        return this.f12817h;
    }

    public int getLevel() {
        return this.n;
    }

    public String s() {
        return this.q;
    }

    public void setForumId(String str) {
        this.f12818i = str;
    }

    public int t() {
        return this.l;
    }

    public String u() {
        return this.f12814e;
    }

    public boolean v() {
        return this.m;
    }

    public PostPrefixData w() {
        return this.s;
    }

    public int x() {
        return this.f12816g;
    }

    public List<FrsTabItemData> y() {
        return this.r;
    }

    public ThemeColorInfo z() {
        return this.k;
    }

    public VisitedForumData(String str, String str2, String str3, String str4, boolean z, ThemeColorInfo themeColorInfo, int i2) {
        this.f12814e = str3;
        this.f12815f = z;
        this.f12817h = str2;
        this.f12818i = str;
        this.j = str4;
        this.f12816g = 0;
        this.k = themeColorInfo;
        this.l = i2;
    }
}
