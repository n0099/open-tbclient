package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.HistoryForumInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes.dex */
public class VisitedForumData extends OrmObject {
    private boolean cpK;
    private int cpL;
    private String cpM;
    private int cpN;
    private boolean cpO;
    private String mForumId;
    private String mForumImageUrl;
    private String mForumName;
    private ThemeColorInfo mThemeColorInfo;

    public VisitedForumData() {
        this.mForumImageUrl = "";
        this.cpK = false;
        this.cpL = 0;
        this.mForumName = "";
        this.mForumId = "";
        this.cpM = "";
        this.mThemeColorInfo = null;
        this.cpN = 0;
        this.cpO = false;
    }

    public VisitedForumData(String str, String str2, String str3, String str4, boolean z, ThemeColorInfo themeColorInfo, int i) {
        this.mForumImageUrl = str3;
        this.cpK = z;
        this.mForumName = str2;
        this.mForumId = str;
        this.cpM = str4;
        this.cpL = 0;
        this.mThemeColorInfo = themeColorInfo;
        this.cpN = i;
    }

    public void a(HistoryForumInfo historyForumInfo) {
        if (historyForumInfo != null) {
            this.mForumImageUrl = historyForumInfo.avatar;
            this.mForumId = String.valueOf(historyForumInfo.forum_id);
            this.mForumName = historyForumInfo.forum_name;
            this.cpK = historyForumInfo.is_liveforum.intValue() == 1;
            this.cpL = historyForumInfo.unread_num.intValue();
            this.cpM = historyForumInfo.visit_time;
            this.mThemeColorInfo = historyForumInfo.theme_color;
            this.cpN = historyForumInfo.follow_num.intValue();
            this.cpO = historyForumInfo.need_trans.booleanValue();
        }
    }

    public String aqz() {
        return this.mForumImageUrl;
    }

    public boolean aqA() {
        return this.cpK;
    }

    public int aqB() {
        return this.cpL;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String aqC() {
        return this.cpM;
    }

    public int aqD() {
        return this.cpN;
    }

    public ThemeColorInfo getThemeColorInfo() {
        return this.mThemeColorInfo;
    }

    public boolean aqE() {
        return this.cpO;
    }
}
