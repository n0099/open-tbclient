package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.HistoryForumInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes.dex */
public class VisitedForumData extends OrmObject {
    private int chA;
    private String chB;
    private int chC;
    private boolean chD;
    private boolean chz;
    private String mForumId;
    private String mForumImageUrl;
    private String mForumName;
    private ThemeColorInfo mThemeColorInfo;

    public VisitedForumData() {
        this.mForumImageUrl = "";
        this.chz = false;
        this.chA = 0;
        this.mForumName = "";
        this.mForumId = "";
        this.chB = "";
        this.mThemeColorInfo = null;
        this.chC = 0;
        this.chD = false;
    }

    public VisitedForumData(String str, String str2, String str3, String str4, boolean z, ThemeColorInfo themeColorInfo, int i) {
        this.mForumImageUrl = str3;
        this.chz = z;
        this.mForumName = str2;
        this.mForumId = str;
        this.chB = str4;
        this.chA = 0;
        this.mThemeColorInfo = themeColorInfo;
        this.chC = i;
    }

    public void a(HistoryForumInfo historyForumInfo) {
        if (historyForumInfo != null) {
            this.mForumImageUrl = historyForumInfo.avatar;
            this.mForumId = String.valueOf(historyForumInfo.forum_id);
            this.mForumName = historyForumInfo.forum_name;
            this.chz = historyForumInfo.is_liveforum.intValue() == 1;
            this.chA = historyForumInfo.unread_num.intValue();
            this.chB = historyForumInfo.visit_time;
            this.mThemeColorInfo = historyForumInfo.theme_color;
            this.chC = historyForumInfo.follow_num.intValue();
            this.chD = historyForumInfo.need_trans.booleanValue();
        }
    }

    public String alz() {
        return this.mForumImageUrl;
    }

    public boolean alA() {
        return this.chz;
    }

    public int alB() {
        return this.chA;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String alC() {
        return this.chB;
    }

    public int alD() {
        return this.chC;
    }

    public ThemeColorInfo getThemeColorInfo() {
        return this.mThemeColorInfo;
    }

    public boolean alE() {
        return this.chD;
    }
}
