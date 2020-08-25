package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.HistoryForumInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes2.dex */
public class VisitedForumData extends OrmObject {
    private boolean eJF;
    private int eJG;
    private String eJH;
    private int eJI;
    private boolean eJJ;
    private String mForumId;
    private String mForumImageUrl;
    private String mForumName;
    private ThemeColorInfo mThemeColorInfo;

    public VisitedForumData() {
        this.mForumImageUrl = "";
        this.eJF = false;
        this.eJG = 0;
        this.mForumName = "";
        this.mForumId = "";
        this.eJH = "";
        this.mThemeColorInfo = null;
        this.eJI = 0;
        this.eJJ = false;
    }

    public VisitedForumData(String str, String str2, String str3, String str4, boolean z, ThemeColorInfo themeColorInfo, int i) {
        this.mForumImageUrl = str3;
        this.eJF = z;
        this.mForumName = str2;
        this.mForumId = str;
        this.eJH = str4;
        this.eJG = 0;
        this.mThemeColorInfo = themeColorInfo;
        this.eJI = i;
    }

    public void a(HistoryForumInfo historyForumInfo) {
        if (historyForumInfo != null) {
            this.mForumImageUrl = historyForumInfo.avatar;
            this.mForumId = String.valueOf(historyForumInfo.forum_id);
            this.mForumName = historyForumInfo.forum_name;
            this.eJF = historyForumInfo.is_liveforum.intValue() == 1;
            this.eJG = historyForumInfo.unread_num.intValue();
            this.eJH = historyForumInfo.visit_time;
            this.mThemeColorInfo = historyForumInfo.theme_color;
            this.eJI = historyForumInfo.follow_num.intValue();
            this.eJJ = historyForumInfo.need_trans.booleanValue();
        }
    }

    public String brc() {
        return this.mForumImageUrl;
    }

    public boolean brd() {
        return this.eJF;
    }

    public int bre() {
        return this.eJG;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String brf() {
        return this.eJH;
    }

    public int brg() {
        return this.eJI;
    }

    public ThemeColorInfo getThemeColorInfo() {
        return this.mThemeColorInfo;
    }

    public boolean brh() {
        return this.eJJ;
    }
}
