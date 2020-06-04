package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.HistoryForumInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes.dex */
public class VisitedForumData extends OrmObject {
    private boolean ekd;
    private int eke;
    private String ekf;
    private int ekg;
    private boolean ekh;
    private String mForumId;
    private String mForumImageUrl;
    private String mForumName;
    private ThemeColorInfo mThemeColorInfo;

    public VisitedForumData() {
        this.mForumImageUrl = "";
        this.ekd = false;
        this.eke = 0;
        this.mForumName = "";
        this.mForumId = "";
        this.ekf = "";
        this.mThemeColorInfo = null;
        this.ekg = 0;
        this.ekh = false;
    }

    public VisitedForumData(String str, String str2, String str3, String str4, boolean z, ThemeColorInfo themeColorInfo, int i) {
        this.mForumImageUrl = str3;
        this.ekd = z;
        this.mForumName = str2;
        this.mForumId = str;
        this.ekf = str4;
        this.eke = 0;
        this.mThemeColorInfo = themeColorInfo;
        this.ekg = i;
    }

    public void a(HistoryForumInfo historyForumInfo) {
        if (historyForumInfo != null) {
            this.mForumImageUrl = historyForumInfo.avatar;
            this.mForumId = String.valueOf(historyForumInfo.forum_id);
            this.mForumName = historyForumInfo.forum_name;
            this.ekd = historyForumInfo.is_liveforum.intValue() == 1;
            this.eke = historyForumInfo.unread_num.intValue();
            this.ekf = historyForumInfo.visit_time;
            this.mThemeColorInfo = historyForumInfo.theme_color;
            this.ekg = historyForumInfo.follow_num.intValue();
            this.ekh = historyForumInfo.need_trans.booleanValue();
        }
    }

    public String bcF() {
        return this.mForumImageUrl;
    }

    public boolean bcG() {
        return this.ekd;
    }

    public int bcH() {
        return this.eke;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String bcI() {
        return this.ekf;
    }

    public int bcJ() {
        return this.ekg;
    }

    public ThemeColorInfo getThemeColorInfo() {
        return this.mThemeColorInfo;
    }

    public boolean bcK() {
        return this.ekh;
    }
}
