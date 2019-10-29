package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.HistoryForumInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes.dex */
public class VisitedForumData extends OrmObject {
    private boolean cEj;
    private int cEk;
    private String cEl;
    private int cEm;
    private boolean cEn;
    private String mForumId;
    private String mForumImageUrl;
    private String mForumName;
    private ThemeColorInfo mThemeColorInfo;

    public VisitedForumData() {
        this.mForumImageUrl = "";
        this.cEj = false;
        this.cEk = 0;
        this.mForumName = "";
        this.mForumId = "";
        this.cEl = "";
        this.mThemeColorInfo = null;
        this.cEm = 0;
        this.cEn = false;
    }

    public VisitedForumData(String str, String str2, String str3, String str4, boolean z, ThemeColorInfo themeColorInfo, int i) {
        this.mForumImageUrl = str3;
        this.cEj = z;
        this.mForumName = str2;
        this.mForumId = str;
        this.cEl = str4;
        this.cEk = 0;
        this.mThemeColorInfo = themeColorInfo;
        this.cEm = i;
    }

    public void a(HistoryForumInfo historyForumInfo) {
        if (historyForumInfo != null) {
            this.mForumImageUrl = historyForumInfo.avatar;
            this.mForumId = String.valueOf(historyForumInfo.forum_id);
            this.mForumName = historyForumInfo.forum_name;
            this.cEj = historyForumInfo.is_liveforum.intValue() == 1;
            this.cEk = historyForumInfo.unread_num.intValue();
            this.cEl = historyForumInfo.visit_time;
            this.mThemeColorInfo = historyForumInfo.theme_color;
            this.cEm = historyForumInfo.follow_num.intValue();
            this.cEn = historyForumInfo.need_trans.booleanValue();
        }
    }

    public String atH() {
        return this.mForumImageUrl;
    }

    public boolean atI() {
        return this.cEj;
    }

    public int atJ() {
        return this.cEk;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String atK() {
        return this.cEl;
    }

    public int atL() {
        return this.cEm;
    }

    public ThemeColorInfo getThemeColorInfo() {
        return this.mThemeColorInfo;
    }

    public boolean atM() {
        return this.cEn;
    }
}
