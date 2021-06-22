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
    public String f12869e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f12870f;

    /* renamed from: g  reason: collision with root package name */
    public int f12871g;

    /* renamed from: h  reason: collision with root package name */
    public String f12872h;

    /* renamed from: i  reason: collision with root package name */
    public String f12873i;
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
        this.f12869e = "";
        this.f12870f = false;
        this.f12871g = 0;
        this.f12872h = "";
        this.f12873i = "";
        this.j = "";
        this.k = null;
        this.l = 0;
        this.m = false;
        this.o = false;
        this.p = false;
        this.q = "";
    }

    public PostPrefixData A() {
        return this.s;
    }

    public int B() {
        return this.f12871g;
    }

    public List<FrsTabItemData> C() {
        return this.r;
    }

    public ThemeColorInfo D() {
        return this.k;
    }

    public String E() {
        return this.j;
    }

    public boolean F() {
        return this.f12870f;
    }

    public boolean G() {
        return this.p;
    }

    public boolean H() {
        return this.o;
    }

    public void I(HistoryForumInfo historyForumInfo) {
        if (historyForumInfo == null) {
            return;
        }
        this.f12869e = historyForumInfo.avatar;
        this.f12873i = String.valueOf(historyForumInfo.forum_id);
        this.f12872h = historyForumInfo.forum_name;
        this.f12870f = historyForumInfo.is_liveforum.intValue() == 1;
        this.f12871g = historyForumInfo.unread_num.intValue();
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

    public void J(boolean z) {
        this.o = z;
    }

    public String getForumId() {
        return this.f12873i;
    }

    public String getForumName() {
        return this.f12872h;
    }

    public int getLevel() {
        return this.n;
    }

    public void setForumId(String str) {
        this.f12873i = str;
    }

    public String w() {
        return this.q;
    }

    public int x() {
        return this.l;
    }

    public String y() {
        return this.f12869e;
    }

    public boolean z() {
        return this.m;
    }

    public VisitedForumData(String str, String str2, String str3, String str4, boolean z, ThemeColorInfo themeColorInfo, int i2) {
        this.f12869e = str3;
        this.f12870f = z;
        this.f12872h = str2;
        this.f12873i = str;
        this.j = str4;
        this.f12871g = 0;
        this.k = themeColorInfo;
        this.l = i2;
    }
}
