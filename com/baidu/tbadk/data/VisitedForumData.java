package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.HistoryForumInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes.dex */
public class VisitedForumData extends OrmObject {
    private boolean dVP;
    private int dVQ;
    private String dVR;
    private int dVS;
    private boolean dVT;
    private String mForumId;
    private String mForumImageUrl;
    private String mForumName;
    private ThemeColorInfo mThemeColorInfo;

    public VisitedForumData() {
        this.mForumImageUrl = "";
        this.dVP = false;
        this.dVQ = 0;
        this.mForumName = "";
        this.mForumId = "";
        this.dVR = "";
        this.mThemeColorInfo = null;
        this.dVS = 0;
        this.dVT = false;
    }

    public VisitedForumData(String str, String str2, String str3, String str4, boolean z, ThemeColorInfo themeColorInfo, int i) {
        this.mForumImageUrl = str3;
        this.dVP = z;
        this.mForumName = str2;
        this.mForumId = str;
        this.dVR = str4;
        this.dVQ = 0;
        this.mThemeColorInfo = themeColorInfo;
        this.dVS = i;
    }

    public void a(HistoryForumInfo historyForumInfo) {
        if (historyForumInfo != null) {
            this.mForumImageUrl = historyForumInfo.avatar;
            this.mForumId = String.valueOf(historyForumInfo.forum_id);
            this.mForumName = historyForumInfo.forum_name;
            this.dVP = historyForumInfo.is_liveforum.intValue() == 1;
            this.dVQ = historyForumInfo.unread_num.intValue();
            this.dVR = historyForumInfo.visit_time;
            this.mThemeColorInfo = historyForumInfo.theme_color;
            this.dVS = historyForumInfo.follow_num.intValue();
            this.dVT = historyForumInfo.need_trans.booleanValue();
        }
    }

    public String aWx() {
        return this.mForumImageUrl;
    }

    public boolean aWy() {
        return this.dVP;
    }

    public int aWz() {
        return this.dVQ;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String aWA() {
        return this.dVR;
    }

    public int aWB() {
        return this.dVS;
    }

    public ThemeColorInfo getThemeColorInfo() {
        return this.mThemeColorInfo;
    }

    public boolean aWC() {
        return this.dVT;
    }
}
