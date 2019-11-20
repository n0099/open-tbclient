package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.HistoryForumInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes.dex */
public class VisitedForumData extends OrmObject {
    private boolean cDs;
    private int cDt;
    private String cDu;
    private int cDv;
    private boolean cDw;
    private String mForumId;
    private String mForumImageUrl;
    private String mForumName;
    private ThemeColorInfo mThemeColorInfo;

    public VisitedForumData() {
        this.mForumImageUrl = "";
        this.cDs = false;
        this.cDt = 0;
        this.mForumName = "";
        this.mForumId = "";
        this.cDu = "";
        this.mThemeColorInfo = null;
        this.cDv = 0;
        this.cDw = false;
    }

    public VisitedForumData(String str, String str2, String str3, String str4, boolean z, ThemeColorInfo themeColorInfo, int i) {
        this.mForumImageUrl = str3;
        this.cDs = z;
        this.mForumName = str2;
        this.mForumId = str;
        this.cDu = str4;
        this.cDt = 0;
        this.mThemeColorInfo = themeColorInfo;
        this.cDv = i;
    }

    public void a(HistoryForumInfo historyForumInfo) {
        if (historyForumInfo != null) {
            this.mForumImageUrl = historyForumInfo.avatar;
            this.mForumId = String.valueOf(historyForumInfo.forum_id);
            this.mForumName = historyForumInfo.forum_name;
            this.cDs = historyForumInfo.is_liveforum.intValue() == 1;
            this.cDt = historyForumInfo.unread_num.intValue();
            this.cDu = historyForumInfo.visit_time;
            this.mThemeColorInfo = historyForumInfo.theme_color;
            this.cDv = historyForumInfo.follow_num.intValue();
            this.cDw = historyForumInfo.need_trans.booleanValue();
        }
    }

    public String atF() {
        return this.mForumImageUrl;
    }

    public boolean atG() {
        return this.cDs;
    }

    public int atH() {
        return this.cDt;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String atI() {
        return this.cDu;
    }

    public int atJ() {
        return this.cDv;
    }

    public ThemeColorInfo getThemeColorInfo() {
        return this.mThemeColorInfo;
    }

    public boolean atK() {
        return this.cDw;
    }
}
