package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.HistoryForumInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes.dex */
public class VisitedForumData extends OrmObject {
    private boolean cqX;
    private int cqY;
    private String cqZ;
    private int cra;
    private boolean crb;
    private String mForumId;
    private String mForumImageUrl;
    private String mForumName;
    private ThemeColorInfo mThemeColorInfo;

    public VisitedForumData() {
        this.mForumImageUrl = "";
        this.cqX = false;
        this.cqY = 0;
        this.mForumName = "";
        this.mForumId = "";
        this.cqZ = "";
        this.mThemeColorInfo = null;
        this.cra = 0;
        this.crb = false;
    }

    public VisitedForumData(String str, String str2, String str3, String str4, boolean z, ThemeColorInfo themeColorInfo, int i) {
        this.mForumImageUrl = str3;
        this.cqX = z;
        this.mForumName = str2;
        this.mForumId = str;
        this.cqZ = str4;
        this.cqY = 0;
        this.mThemeColorInfo = themeColorInfo;
        this.cra = i;
    }

    public void a(HistoryForumInfo historyForumInfo) {
        if (historyForumInfo != null) {
            this.mForumImageUrl = historyForumInfo.avatar;
            this.mForumId = String.valueOf(historyForumInfo.forum_id);
            this.mForumName = historyForumInfo.forum_name;
            this.cqX = historyForumInfo.is_liveforum.intValue() == 1;
            this.cqY = historyForumInfo.unread_num.intValue();
            this.cqZ = historyForumInfo.visit_time;
            this.mThemeColorInfo = historyForumInfo.theme_color;
            this.cra = historyForumInfo.follow_num.intValue();
            this.crb = historyForumInfo.need_trans.booleanValue();
        }
    }

    public String arF() {
        return this.mForumImageUrl;
    }

    public boolean arG() {
        return this.cqX;
    }

    public int arH() {
        return this.cqY;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String arI() {
        return this.cqZ;
    }

    public int arJ() {
        return this.cra;
    }

    public ThemeColorInfo getThemeColorInfo() {
        return this.mThemeColorInfo;
    }

    public boolean arK() {
        return this.crb;
    }
}
