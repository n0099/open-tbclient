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
    public String f13495e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f13496f;

    /* renamed from: g  reason: collision with root package name */
    public int f13497g;

    /* renamed from: h  reason: collision with root package name */
    public String f13498h;
    public String i;
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
        this.f13495e = "";
        this.f13496f = false;
        this.f13497g = 0;
        this.f13498h = "";
        this.i = "";
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
        return this.f13496f;
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
        this.f13495e = historyForumInfo.avatar;
        this.i = String.valueOf(historyForumInfo.forum_id);
        this.f13498h = historyForumInfo.forum_name;
        this.f13496f = historyForumInfo.is_liveforum.intValue() == 1;
        this.f13497g = historyForumInfo.unread_num.intValue();
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
        return this.i;
    }

    public String getForumName() {
        return this.f13498h;
    }

    public int getLevel() {
        return this.n;
    }

    public String s() {
        return this.q;
    }

    public void setForumId(String str) {
        this.i = str;
    }

    public int t() {
        return this.l;
    }

    public String u() {
        return this.f13495e;
    }

    public boolean v() {
        return this.m;
    }

    public PostPrefixData w() {
        return this.s;
    }

    public int x() {
        return this.f13497g;
    }

    public List<FrsTabItemData> y() {
        return this.r;
    }

    public ThemeColorInfo z() {
        return this.k;
    }

    public VisitedForumData(String str, String str2, String str3, String str4, boolean z, ThemeColorInfo themeColorInfo, int i) {
        this.f13495e = str3;
        this.f13496f = z;
        this.f13498h = str2;
        this.i = str;
        this.j = str4;
        this.f13497g = 0;
        this.k = themeColorInfo;
        this.l = i;
    }
}
