package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.HistoryForumInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes.dex */
public class VisitedForumData extends OrmObject {
    private boolean chC;
    private int chD;
    private String chE;
    private int chF;
    private boolean chG;
    private String mForumId;
    private String mForumImageUrl;
    private String mForumName;
    private ThemeColorInfo mThemeColorInfo;

    public VisitedForumData() {
        this.mForumImageUrl = "";
        this.chC = false;
        this.chD = 0;
        this.mForumName = "";
        this.mForumId = "";
        this.chE = "";
        this.mThemeColorInfo = null;
        this.chF = 0;
        this.chG = false;
    }

    public VisitedForumData(String str, String str2, String str3, String str4, boolean z, ThemeColorInfo themeColorInfo, int i) {
        this.mForumImageUrl = str3;
        this.chC = z;
        this.mForumName = str2;
        this.mForumId = str;
        this.chE = str4;
        this.chD = 0;
        this.mThemeColorInfo = themeColorInfo;
        this.chF = i;
    }

    public void a(HistoryForumInfo historyForumInfo) {
        if (historyForumInfo != null) {
            this.mForumImageUrl = historyForumInfo.avatar;
            this.mForumId = String.valueOf(historyForumInfo.forum_id);
            this.mForumName = historyForumInfo.forum_name;
            this.chC = historyForumInfo.is_liveforum.intValue() == 1;
            this.chD = historyForumInfo.unread_num.intValue();
            this.chE = historyForumInfo.visit_time;
            this.mThemeColorInfo = historyForumInfo.theme_color;
            this.chF = historyForumInfo.follow_num.intValue();
            this.chG = historyForumInfo.need_trans.booleanValue();
        }
    }

    public String alw() {
        return this.mForumImageUrl;
    }

    public boolean alx() {
        return this.chC;
    }

    public int aly() {
        return this.chD;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String alz() {
        return this.chE;
    }

    public int alA() {
        return this.chF;
    }

    public ThemeColorInfo getThemeColorInfo() {
        return this.mThemeColorInfo;
    }

    public boolean alB() {
        return this.chG;
    }
}
