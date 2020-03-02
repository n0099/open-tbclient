package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.HistoryForumInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes.dex */
public class VisitedForumData extends OrmObject {
    private boolean dvI;
    private int dvJ;
    private String dvK;
    private int dvL;
    private boolean dvM;
    private String mForumId;
    private String mForumImageUrl;
    private String mForumName;
    private ThemeColorInfo mThemeColorInfo;

    public VisitedForumData() {
        this.mForumImageUrl = "";
        this.dvI = false;
        this.dvJ = 0;
        this.mForumName = "";
        this.mForumId = "";
        this.dvK = "";
        this.mThemeColorInfo = null;
        this.dvL = 0;
        this.dvM = false;
    }

    public VisitedForumData(String str, String str2, String str3, String str4, boolean z, ThemeColorInfo themeColorInfo, int i) {
        this.mForumImageUrl = str3;
        this.dvI = z;
        this.mForumName = str2;
        this.mForumId = str;
        this.dvK = str4;
        this.dvJ = 0;
        this.mThemeColorInfo = themeColorInfo;
        this.dvL = i;
    }

    public void a(HistoryForumInfo historyForumInfo) {
        if (historyForumInfo != null) {
            this.mForumImageUrl = historyForumInfo.avatar;
            this.mForumId = String.valueOf(historyForumInfo.forum_id);
            this.mForumName = historyForumInfo.forum_name;
            this.dvI = historyForumInfo.is_liveforum.intValue() == 1;
            this.dvJ = historyForumInfo.unread_num.intValue();
            this.dvK = historyForumInfo.visit_time;
            this.mThemeColorInfo = historyForumInfo.theme_color;
            this.dvL = historyForumInfo.follow_num.intValue();
            this.dvM = historyForumInfo.need_trans.booleanValue();
        }
    }

    public String aOb() {
        return this.mForumImageUrl;
    }

    public boolean aOc() {
        return this.dvI;
    }

    public int aOd() {
        return this.dvJ;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String aOe() {
        return this.dvK;
    }

    public int aOf() {
        return this.dvL;
    }

    public ThemeColorInfo getThemeColorInfo() {
        return this.mThemeColorInfo;
    }

    public boolean aOg() {
        return this.dvM;
    }
}
