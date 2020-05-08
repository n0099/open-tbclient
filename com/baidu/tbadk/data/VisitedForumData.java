package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.HistoryForumInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes.dex */
public class VisitedForumData extends OrmObject {
    private boolean dVU;
    private int dVV;
    private String dVW;
    private int dVX;
    private boolean dVY;
    private String mForumId;
    private String mForumImageUrl;
    private String mForumName;
    private ThemeColorInfo mThemeColorInfo;

    public VisitedForumData() {
        this.mForumImageUrl = "";
        this.dVU = false;
        this.dVV = 0;
        this.mForumName = "";
        this.mForumId = "";
        this.dVW = "";
        this.mThemeColorInfo = null;
        this.dVX = 0;
        this.dVY = false;
    }

    public VisitedForumData(String str, String str2, String str3, String str4, boolean z, ThemeColorInfo themeColorInfo, int i) {
        this.mForumImageUrl = str3;
        this.dVU = z;
        this.mForumName = str2;
        this.mForumId = str;
        this.dVW = str4;
        this.dVV = 0;
        this.mThemeColorInfo = themeColorInfo;
        this.dVX = i;
    }

    public void a(HistoryForumInfo historyForumInfo) {
        if (historyForumInfo != null) {
            this.mForumImageUrl = historyForumInfo.avatar;
            this.mForumId = String.valueOf(historyForumInfo.forum_id);
            this.mForumName = historyForumInfo.forum_name;
            this.dVU = historyForumInfo.is_liveforum.intValue() == 1;
            this.dVV = historyForumInfo.unread_num.intValue();
            this.dVW = historyForumInfo.visit_time;
            this.mThemeColorInfo = historyForumInfo.theme_color;
            this.dVX = historyForumInfo.follow_num.intValue();
            this.dVY = historyForumInfo.need_trans.booleanValue();
        }
    }

    public String aWv() {
        return this.mForumImageUrl;
    }

    public boolean aWw() {
        return this.dVU;
    }

    public int aWx() {
        return this.dVV;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String aWy() {
        return this.dVW;
    }

    public int aWz() {
        return this.dVX;
    }

    public ThemeColorInfo getThemeColorInfo() {
        return this.mThemeColorInfo;
    }

    public boolean aWA() {
        return this.dVY;
    }
}
