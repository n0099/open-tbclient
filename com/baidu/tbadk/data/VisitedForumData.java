package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.HistoryForumInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes.dex */
public class VisitedForumData extends OrmObject {
    private boolean chB;
    private int chC;
    private String chD;
    private int chE;
    private boolean chF;
    private String mForumId;
    private String mForumImageUrl;
    private String mForumName;
    private ThemeColorInfo mThemeColorInfo;

    public VisitedForumData() {
        this.mForumImageUrl = "";
        this.chB = false;
        this.chC = 0;
        this.mForumName = "";
        this.mForumId = "";
        this.chD = "";
        this.mThemeColorInfo = null;
        this.chE = 0;
        this.chF = false;
    }

    public VisitedForumData(String str, String str2, String str3, String str4, boolean z, ThemeColorInfo themeColorInfo, int i) {
        this.mForumImageUrl = str3;
        this.chB = z;
        this.mForumName = str2;
        this.mForumId = str;
        this.chD = str4;
        this.chC = 0;
        this.mThemeColorInfo = themeColorInfo;
        this.chE = i;
    }

    public void a(HistoryForumInfo historyForumInfo) {
        if (historyForumInfo != null) {
            this.mForumImageUrl = historyForumInfo.avatar;
            this.mForumId = String.valueOf(historyForumInfo.forum_id);
            this.mForumName = historyForumInfo.forum_name;
            this.chB = historyForumInfo.is_liveforum.intValue() == 1;
            this.chC = historyForumInfo.unread_num.intValue();
            this.chD = historyForumInfo.visit_time;
            this.mThemeColorInfo = historyForumInfo.theme_color;
            this.chE = historyForumInfo.follow_num.intValue();
            this.chF = historyForumInfo.need_trans.booleanValue();
        }
    }

    public String alw() {
        return this.mForumImageUrl;
    }

    public boolean alx() {
        return this.chB;
    }

    public int aly() {
        return this.chC;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String alz() {
        return this.chD;
    }

    public int alA() {
        return this.chE;
    }

    public ThemeColorInfo getThemeColorInfo() {
        return this.mThemeColorInfo;
    }

    public boolean alB() {
        return this.chF;
    }
}
