package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.HistoryForumInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes.dex */
public class VisitedForumData extends OrmObject {
    private boolean esO;
    private int esP;
    private String esQ;
    private int esR;
    private boolean esS;
    private String mForumId;
    private String mForumImageUrl;
    private String mForumName;
    private ThemeColorInfo mThemeColorInfo;

    public VisitedForumData() {
        this.mForumImageUrl = "";
        this.esO = false;
        this.esP = 0;
        this.mForumName = "";
        this.mForumId = "";
        this.esQ = "";
        this.mThemeColorInfo = null;
        this.esR = 0;
        this.esS = false;
    }

    public VisitedForumData(String str, String str2, String str3, String str4, boolean z, ThemeColorInfo themeColorInfo, int i) {
        this.mForumImageUrl = str3;
        this.esO = z;
        this.mForumName = str2;
        this.mForumId = str;
        this.esQ = str4;
        this.esP = 0;
        this.mThemeColorInfo = themeColorInfo;
        this.esR = i;
    }

    public void a(HistoryForumInfo historyForumInfo) {
        if (historyForumInfo != null) {
            this.mForumImageUrl = historyForumInfo.avatar;
            this.mForumId = String.valueOf(historyForumInfo.forum_id);
            this.mForumName = historyForumInfo.forum_name;
            this.esO = historyForumInfo.is_liveforum.intValue() == 1;
            this.esP = historyForumInfo.unread_num.intValue();
            this.esQ = historyForumInfo.visit_time;
            this.mThemeColorInfo = historyForumInfo.theme_color;
            this.esR = historyForumInfo.follow_num.intValue();
            this.esS = historyForumInfo.need_trans.booleanValue();
        }
    }

    public String beH() {
        return this.mForumImageUrl;
    }

    public boolean beI() {
        return this.esO;
    }

    public int beJ() {
        return this.esP;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String beK() {
        return this.esQ;
    }

    public int beL() {
        return this.esR;
    }

    public ThemeColorInfo getThemeColorInfo() {
        return this.mThemeColorInfo;
    }

    public boolean beM() {
        return this.esS;
    }
}
