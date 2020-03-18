package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.HistoryForumInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes.dex */
public class VisitedForumData extends OrmObject {
    private boolean dwi;
    private int dwj;
    private String dwk;
    private int dwl;
    private boolean dwm;
    private String mForumId;
    private String mForumImageUrl;
    private String mForumName;
    private ThemeColorInfo mThemeColorInfo;

    public VisitedForumData() {
        this.mForumImageUrl = "";
        this.dwi = false;
        this.dwj = 0;
        this.mForumName = "";
        this.mForumId = "";
        this.dwk = "";
        this.mThemeColorInfo = null;
        this.dwl = 0;
        this.dwm = false;
    }

    public VisitedForumData(String str, String str2, String str3, String str4, boolean z, ThemeColorInfo themeColorInfo, int i) {
        this.mForumImageUrl = str3;
        this.dwi = z;
        this.mForumName = str2;
        this.mForumId = str;
        this.dwk = str4;
        this.dwj = 0;
        this.mThemeColorInfo = themeColorInfo;
        this.dwl = i;
    }

    public void a(HistoryForumInfo historyForumInfo) {
        if (historyForumInfo != null) {
            this.mForumImageUrl = historyForumInfo.avatar;
            this.mForumId = String.valueOf(historyForumInfo.forum_id);
            this.mForumName = historyForumInfo.forum_name;
            this.dwi = historyForumInfo.is_liveforum.intValue() == 1;
            this.dwj = historyForumInfo.unread_num.intValue();
            this.dwk = historyForumInfo.visit_time;
            this.mThemeColorInfo = historyForumInfo.theme_color;
            this.dwl = historyForumInfo.follow_num.intValue();
            this.dwm = historyForumInfo.need_trans.booleanValue();
        }
    }

    public String aOg() {
        return this.mForumImageUrl;
    }

    public boolean aOh() {
        return this.dwi;
    }

    public int aOi() {
        return this.dwj;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String aOj() {
        return this.dwk;
    }

    public int aOk() {
        return this.dwl;
    }

    public ThemeColorInfo getThemeColorInfo() {
        return this.mThemeColorInfo;
    }

    public boolean aOl() {
        return this.dwm;
    }
}
