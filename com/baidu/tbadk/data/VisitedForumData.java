package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.HistoryForumInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes.dex */
public class VisitedForumData extends OrmObject {
    private boolean dvH;
    private int dvI;
    private String dvJ;
    private int dvK;
    private boolean dvL;
    private String mForumId;
    private String mForumImageUrl;
    private String mForumName;
    private ThemeColorInfo mThemeColorInfo;

    public VisitedForumData() {
        this.mForumImageUrl = "";
        this.dvH = false;
        this.dvI = 0;
        this.mForumName = "";
        this.mForumId = "";
        this.dvJ = "";
        this.mThemeColorInfo = null;
        this.dvK = 0;
        this.dvL = false;
    }

    public VisitedForumData(String str, String str2, String str3, String str4, boolean z, ThemeColorInfo themeColorInfo, int i) {
        this.mForumImageUrl = str3;
        this.dvH = z;
        this.mForumName = str2;
        this.mForumId = str;
        this.dvJ = str4;
        this.dvI = 0;
        this.mThemeColorInfo = themeColorInfo;
        this.dvK = i;
    }

    public void a(HistoryForumInfo historyForumInfo) {
        if (historyForumInfo != null) {
            this.mForumImageUrl = historyForumInfo.avatar;
            this.mForumId = String.valueOf(historyForumInfo.forum_id);
            this.mForumName = historyForumInfo.forum_name;
            this.dvH = historyForumInfo.is_liveforum.intValue() == 1;
            this.dvI = historyForumInfo.unread_num.intValue();
            this.dvJ = historyForumInfo.visit_time;
            this.mThemeColorInfo = historyForumInfo.theme_color;
            this.dvK = historyForumInfo.follow_num.intValue();
            this.dvL = historyForumInfo.need_trans.booleanValue();
        }
    }

    public String aNZ() {
        return this.mForumImageUrl;
    }

    public boolean aOa() {
        return this.dvH;
    }

    public int aOb() {
        return this.dvI;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String aOc() {
        return this.dvJ;
    }

    public int aOd() {
        return this.dvK;
    }

    public ThemeColorInfo getThemeColorInfo() {
        return this.mThemeColorInfo;
    }

    public boolean aOe() {
        return this.dvL;
    }
}
