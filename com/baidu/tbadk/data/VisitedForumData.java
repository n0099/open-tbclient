package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.HistoryForumInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes.dex */
public class VisitedForumData extends OrmObject {
    private boolean cpL;
    private int cpM;
    private String cpN;
    private int cpO;
    private boolean cpP;
    private String mForumId;
    private String mForumImageUrl;
    private String mForumName;
    private ThemeColorInfo mThemeColorInfo;

    public VisitedForumData() {
        this.mForumImageUrl = "";
        this.cpL = false;
        this.cpM = 0;
        this.mForumName = "";
        this.mForumId = "";
        this.cpN = "";
        this.mThemeColorInfo = null;
        this.cpO = 0;
        this.cpP = false;
    }

    public VisitedForumData(String str, String str2, String str3, String str4, boolean z, ThemeColorInfo themeColorInfo, int i) {
        this.mForumImageUrl = str3;
        this.cpL = z;
        this.mForumName = str2;
        this.mForumId = str;
        this.cpN = str4;
        this.cpM = 0;
        this.mThemeColorInfo = themeColorInfo;
        this.cpO = i;
    }

    public void a(HistoryForumInfo historyForumInfo) {
        if (historyForumInfo != null) {
            this.mForumImageUrl = historyForumInfo.avatar;
            this.mForumId = String.valueOf(historyForumInfo.forum_id);
            this.mForumName = historyForumInfo.forum_name;
            this.cpL = historyForumInfo.is_liveforum.intValue() == 1;
            this.cpM = historyForumInfo.unread_num.intValue();
            this.cpN = historyForumInfo.visit_time;
            this.mThemeColorInfo = historyForumInfo.theme_color;
            this.cpO = historyForumInfo.follow_num.intValue();
            this.cpP = historyForumInfo.need_trans.booleanValue();
        }
    }

    public String aqz() {
        return this.mForumImageUrl;
    }

    public boolean aqA() {
        return this.cpL;
    }

    public int aqB() {
        return this.cpM;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String aqC() {
        return this.cpN;
    }

    public int aqD() {
        return this.cpO;
    }

    public ThemeColorInfo getThemeColorInfo() {
        return this.mThemeColorInfo;
    }

    public boolean aqE() {
        return this.cpP;
    }
}
